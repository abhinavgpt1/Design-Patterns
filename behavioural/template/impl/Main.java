public class Main {
    public static void main(String[] args) {
        OrderTemplate webOrder = new WebOrder();
        webOrder.processOrder();

        System.out.println();

        OrderTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder();

        // PTR: processOrder() is same i.e. algo is same, but the inner parts change with sub-classes
        // PTR: the parent i.e. OrderTemplate calls the child's methods (doCheckout, doPayment, etc.) - rewriting pieces is a core feature of Template Pattern
        
        // PTR: Template is written with abstract base class usually.

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