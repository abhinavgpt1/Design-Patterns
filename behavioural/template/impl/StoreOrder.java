public class StoreOrder extends OrderTemplate{

    @Override
    protected void doCheckout() {
        System.out.println("StoreOrder: get items from shelf");
        System.out.println("StoreOrder: ask gift preference"); // can take user input to set isGift
    }

    @Override
    protected void doPayment() {
        System.out.println("StoreOrder: process payment at counter");
    }

    @Override
    protected void doReceipt() {
        System.out.println("StoreOrder: print the receipt");
    }

    @Override
    protected void doDelivery() {
        System.out.println("StoreOrder: hand over the item to customer");
    }
    
}
