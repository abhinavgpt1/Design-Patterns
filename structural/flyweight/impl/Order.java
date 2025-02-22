public class Order {
    private int orderNumber;
    private Item item; // assuming single order has single item

    public Order(int orderNumber, Item item) {
        this.orderNumber = orderNumber;
        this.item = item;
    }

    public void processOrder() {
        System.out.println("Ordering for " + orderNumber + " with item " + item);
    }
}
