import service.slots.impl.PayOffServiceImpl1;
import service.slots.impl.PayOffServiceImpl2;

/**
 * Module which provide the implementation of an SPI (Service Provider
 * Interface)
 */
module service.slots.impl {
    requires service.slots.spi;
    provides service.slots.spi.PayOffService
            with PayOffServiceImpl1, PayOffServiceImpl2;
}