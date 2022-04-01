package fr.aseure.tp007;

class ISP {
    public static void main(String[] args) {
        ShoeShop shoeShop = new ShoeShop();
        NintendoEShop nintendoShop = new NintendoEShop();
        SteamShop steamShop = new SteamShop();

        // OK by design thanks to the EShop interface
        placeOrder(shoeShop);
        placeOrder(nintendoShop);
        placeOrder(steamShop);

        // OK by design thanks to the PhysicalShop interface
        trackOrder(shoeShop);
        cancelOrder(shoeShop);

        // Prevent by design (does not compile)
        // trackOrder(steamShop);
        // cancelOrder(steamShop);

        // prevented by design (does not compile)
        // cancelOrder(nintendoShop);
        // trackOrder(nintendoShop);
    }

    static void placeOrder(EShop shop) {
        shop.placeOrder();
    }

    static void trackOrder(PhysicalShop shop) {
        shop.trackOrder();
    }

    static void cancelOrder(PhysicalShop shop) {
        shop.cancelOrder();
    }
}