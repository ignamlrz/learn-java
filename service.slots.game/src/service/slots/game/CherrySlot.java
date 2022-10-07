package service.slots.game;

import service.slots.spi.PayOffService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The {@link CherrySlot} class act as de Consumer, which is going to call
 * methods on a provider.
 * <p>
 * It's module descriptor contains <b>uses</b> directive, which declares
 * which Service will be use. Also, contains a <b>requires</b> directive
 * where the service interface's is declared is also necessary.
 */
public class CherrySlot {

    public static void main(String... args) {
        // Mock playing the game
        new CherrySlot().playGame();
    }

    /**
     * Method which execute service implementations
     */
    private void playGame() {
        System.out.println();
        PayOffService p = getServiceInManyWays(3);
        if (p == null) System.out.println("Provider not found");
        else {
            System.out.println("Congratulations: You're a winner");
            p.threeInRow(PayOffService.SlotType.GOLDBAR_ONE);
            p.twoInRow(PayOffService.SlotType.FRUIT);
            p.hitTheJackPot();
        }
    }

    /**
     * Method which load a {@link PayOffService} implementation
     * <p>
     * The {@link ServiceLoader} class only load on demand, at the request of
     * a consumer, and are cached
     * <p>
     * An invocation of the iterator method or stream method returns cached
     * elements in instantiation order, and then lazily locates and
     * instantiates any remaining providers, adding each to the cache.
     * <p>
     * Cache are cleared with the reload method
     *
     * @return a {@link PayOffService} implementation
     */
    private PayOffService getService() {
        List<PayOffService> providers = new ArrayList<>();
        ServiceLoader.load(PayOffService.class).forEach(providers::add);
        if (providers.size() > 0) {
            return providers.get(providers.size() - 1);
        }
        return null;
    }

    /**
     * Method that searches for providers and first one which is not the
     * default provider packaged with the application
     *
     * @return a {@link PayOffService} implementation
     */
    private PayOffService getPreferredService() {
        List<PayOffService> providers = ServiceLoader.load(PayOffService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());

        // ...give precedence to provider that is NOT the default provider
        Optional<PayOffService> service = providers.stream()
                .filter((s) ->
                        !s.getClass().getName().contains("gamble.slots.impl"))
                .findFirst();

        if (service.isEmpty()) {
            return providers.stream().findFirst().orElse(null);
        } else return service.get();
    }

    /**
     * Method for get services in many ways
     *
     * @param whichWay Select way in which get the service. You can select:
     *                 <ul>
     *                 <li><b>0</b>: Simplest way
     *                 <li><b>1</b>: With iterable
     *                 <li><b>2</b>: With stream without map the provider
     *                 <li><b>3</b>: With stream mapping the provider
     *                 </ul>
     * @return a {@link PayOffService} implementation
     */
    private PayOffService getServiceInManyWays(int whichWay) {
        System.out.println("whichWay = " + whichWay);

        // Call the static load() method on ServiceLoader which returns
        // instance of ServiceLoader and an Iterable whose iterator is made
        // up of PayOffService objects
        ServiceLoader<PayOffService> loader =
                ServiceLoader.load(PayOffService.class);

        // Print out type of the result of load()
        System.out.println("Result of load method = " + loader.getClass());

        // Local variable will be returned from this method
        PayOffService payOffService = null;

        switch (whichWay) {
            case (0):
                // Simplest
                payOffService = loader.findFirst().orElse(null);
                break;
            case (1):
                // With iterable
                Iterator<PayOffService> iterator = loader.iterator();
                while (iterator.hasNext()) {
                    PayOffService service = iterator.next();
                    System.out.println(service.getClass());
                    if (!iterator.hasNext()) payOffService = service;
                }
                break;
            case (2):
                // With stream without map instance
                ServiceLoader.Provider<PayOffService> service = loader.stream()
                        // In this instance I do not map to PayOffService,
                        // but instead use ServiceLoader.Provider.get()
                        // method in the filter
                        .filter(s ->
                                s.get().getClass().getName().endsWith("2"))
                        // findFirst is the terminal operation and returns
                        // Optional<Provider<PayOffService>>
                        .findFirst()
                        // get method on Optional returns a Provider
                        .orElse(null);

                // need to call get again, this time on Provider to
                // get our PayOffService
                if (service != null) payOffService = service.get();

                // NOTE: Selected provider will be initiated 2 times:
                //      - 1º: when run stream
                //      - 2º: when get the final service
                break;
            case (3):
                payOffService = loader.stream()
                        // map form a Provider<PayOffService> to a PayOffService
                        .map(ServiceLoader.Provider::get)
                        // now have a PayOffService, so do not need .get()
                        // method
                        .filter(s -> s.getClass().getName().endsWith("2"))
                        // Now return an Optional<PayOffService> and not
                        // Optional<Provider<PayOffService>>
                        .findFirst()
                        .orElse(null);
                break;

        }

        // Print service loaded
        if (payOffService != null)
            System.out.println("Selected class: " + payOffService.getClass());
        else
            System.out.println("Not service loaded");

        return payOffService;
    }
}
