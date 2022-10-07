/**
 * Module which use an SPI (Service Provider Interface)
 */
module service.slots.game {
    requires service.slots.spi;
    uses service.slots.spi.PayOffService;
}