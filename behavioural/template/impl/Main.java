public class Main {
    public static void main(String[] args) {
        OrderTemplate webOrder = new WebOrder();
        webOrder.processOrder();

        System.out.println();

        OrderTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder();

        // PTR:
        // - processOrder() algo is same but the inner parts change with sub-classes
        // - Template method (aka parent, OrderTemplate) calls the overriden methods in subclasses
        // - Rewriting pieces is a core feature of Template Pattern
        // - Template relies on abstract base class unlike strategy pattern which has algo logic contained in subclasses.

    }
}
/**
 * Output:
 * -------
 * WebOrder: get items from cart
 * WebOrder: get gift preference
 * WebOrder: get delivery address
 * WebOrder: get billing address
 * WebOrder: process online payment
 * WebOrder: email the receipt
 * WebOrder: ship the item to delivery address
 * 
 * StoreOrder: get items from shelf
 * StoreOrder: ask gift preference
 * StoreOrder: process payment at counter
 * StoreOrder: print the receipt
 * StoreOrder: hand over the item to customer
 */