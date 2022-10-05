package service.slots.impl;

import service.slots.spi.PayOffService;

public class PayOffServiceImpl implements PayOffService {

    /**
     * This is a static provider method, one of the two ways to configure a
     * Provider
     * <p></p>
     *
     * Another way to configure a provider is to use a public no args
     * constructor
     * <p></p>
     *
     * Must be public and must not be an inner class
     *
     * @return the {@link PayOffService} implementation
     */
    public static PayOffService provider() {
        System.out.println("PayOffServiceImpl is getting loaded by provider " +
                "method");
        return new PayOffServiceImpl();
    }


    @Override
    public void hitTheJackPot() {
    }

    @Override
    public void threeInRow(SlotType s) {

    }

    @Override
    public void twoInRow(SlotType s) {

    }
}
