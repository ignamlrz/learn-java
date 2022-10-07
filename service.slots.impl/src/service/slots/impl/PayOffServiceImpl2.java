package service.slots.impl;

import service.slots.spi.PayOffService;

public class PayOffServiceImpl2 implements PayOffService {

    /**
     * This is a public no args constructor, one of the two ways to configure a
     * Provider
     * <p>
     * Another way to configure a provider is to use a static provider
     * method. If both is declared, the provider method will be executed
     * <p>
     * Must be public and must not be an inner class
     *
     * @see PayOffServiceImpl1
     */
    public PayOffServiceImpl2() {
        System.out.println("PayOffServiceImpl2 is getting loaded by public " +
                "constructor");
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
