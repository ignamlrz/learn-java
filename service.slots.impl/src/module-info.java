
module service.slots.impl {
    requires service.slots.spi;
    provides service.slots.spi.PayOffService
            with service.slots.impl.PayOffServiceImpl;
}