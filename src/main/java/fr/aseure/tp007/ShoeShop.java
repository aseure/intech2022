package fr.aseure.tp007;

class ShoeShop implements EShop, PhysicalShop {
    @Override
    public void placeOrder() {
        System.out.println("ShoeShop order has been placed");
    }

    @Override
    public void trackOrder() {
        System.out.println("ShoeShop order is on its way");
    }

    @Override
    public void cancelOrder() {
        System.out.println("ShoeShop order has been cancelled");
    }
}