package service.slots.game;

import service.slots.spi.PayOffService;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

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


    private void playGame() {
        PayOffService p = getService();
        if (p == null) System.out.println("Provider not found");
        else {
            System.out.println("Congratulations: You're a winner");
            p.threeInRow(PayOffService.SlotType.GOLDBAR_ONE);
            p.twoInRow(PayOffService.SlotType.FRUIT);
            p.hitTheJackPot();
        }
    }
}
