public class WebOrder extends OrderTemplate {

    @Override
    protected void doCheckout() {
        System.out.println("WebOrder: get items from cart");
        System.out.println("WebOrder: get gift preference"); // can take user input to set isGift
        System.out.println("WebOrder: get delivery address");
        System.out.println("WebOrder: get billing address");
    }

    @Override
    protected void doPayment() {
        System.out.println("WebOrder: process online payment");
    }

    @Override
    protected void doReceipt() {
        System.out.println("WebOrder: email the receipt");
    }

    @Override
    protected void doDelivery() {
        System.out.println("WebOrder: ship the item to delivery address");
    }
}
