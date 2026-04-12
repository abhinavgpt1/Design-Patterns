import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventorySystem {
    private final AmazonCatalog catalog = new AmazonCatalog();
    /*
     * CopyOnWriteArrayList creates a Cloned copy of underlying ArrayList,
     * for every update operation at certain point both will synchronized
     * automatically which is takes care by JVM.
     * Therefore there is no effect for threads which are performing read operation.
     * Therefore thread-safety is not there in ArrayList whereas
     * CopyOnWriteArrayList is thread-safe.
     */
    private final List<Order> orders = new CopyOnWriteArrayList<Order>();

    void takeOrder(String itemName, int orderNumber) {
        Item item = catalog.lookupItem(itemName);
        Order order = new Order(orderNumber, item);
        orders.add(order);
    }

    void processOrders() {
        for (Order order : orders) {
            order.processOrder();
            orders.remove(order); // throws ConcurrentModificationException in case of normal List<> since it's fail-fast.
            // Alternate soln to CopyOnWriteArrayList
            // - Iterator<Order> it = orders.iterator(); it.remove() is safe becoz it controls modification.
            // - orders.removeIf(order -> {order.processOrder();return true;});
            // - Iterate over copy eg. for (Order order : new ArrayList<>(orders)) {...}
            // - process all orders and after for-each ends, clear the orders list: prone to failure and runtime exception, hence would need proper handling.
        }
    }

    String getDistinctInventoryItemCount() {
        // This is based on assumption that whatever's there in catalog 
        // i.e. visible on Amazon.com catalog will be available => present in inventory
        return "Distinct items in inventory: " + catalog.getCatalogSize();
    }
}
