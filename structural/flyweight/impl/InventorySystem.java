import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventorySystem {
    private final AmazonCatalog catalog = new AmazonCatalog();
    /*
     * CopyOnWriteArrayList creates a Cloned copy of underlying ArrayList, 
     * for every update operation at certain point both will synchronized automatically which is takes care by JVM. 
     * Therefore there is no effect for threads which are performing read operation. 
     * Therefore thread-safety is not there in ArrayList whereas CopyOnWriteArrayList is thread-safe.
     */
    private final List<Order> orders = new CopyOnWriteArrayList<Order>();

    void takeOrder(String itemName, int orderNumber) {
        Item item = catalog.lookupItem(itemName);
        Order order = new Order(orderNumber, item);
        orders.add(order);
    }

    void processOrders() {
        for(Order order: orders) {
            order.processOrder();
            orders.remove(order);
        }
    }

    String report() {
        return "Total items made: " + catalog.getCatalogSize();
    }
}
