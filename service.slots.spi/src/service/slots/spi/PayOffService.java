package service.slots.spi;

/**
 * The {@link PayOffService} interface is the Service Provider Interface (SPI)
 * which represents the PayOff Service
 */
public interface PayOffService {
    // Enum representing slot machine images
    enum SlotType {
        FRUIT, JACKPOT, GOLDBAR_ONE, GOLDBAR_TWO, GOLDBAR_THREE
    }

    // Methods which define different types of payoffs
    void hitTheJackPot();

    void threeInRow(SlotType s);

    void twoInRow(SlotType s);
}
