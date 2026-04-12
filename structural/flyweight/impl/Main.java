public class Main {
    public static void main(String[] args) {
        // Verifying hashCode for a headphone model when looked up twice in catalog
        AmazonCatalog catalog = new AmazonCatalog();
        System.out.println("Lookup:" + catalog.lookupItem("WH-CH710N"));
        Item headphone1 = catalog.lookupItem("WH-CH710N");
        Item headphone2 = catalog.lookupItem("WH-CH710N");
        System.out.println("HashCode for headphone1: " + headphone1.hashCode());
        System.out.println("HashCode for headphone2: " + headphone2.hashCode());
        System.out.println("Catalog size: " + catalog.getCatalogSize());
        System.out.println();

        // Problem statement:
        // When multiple users select same item from Amazon.com, then we don't want to
        // create cart/order with different instances of product. 
        // Using basic catalog.getNewItem() method causes memory spike thus, leading to high memory consumption.
        
        // Soln: Using flyweight pattern to retrieve items via factory, memory consumption decreases
        InventorySystem inventorySystem = new InventorySystem();
        inventorySystem.takeOrder("WH-CH710N", 111);
        inventorySystem.takeOrder("SamsungTV", 232);
        inventorySystem.takeOrder("WH-CH710N", 212);
        inventorySystem.takeOrder("SamsungTV", 562);
        inventorySystem.takeOrder("WH-CH710N", 217);
        inventorySystem.takeOrder("iRobot-Roomba", 162);
        inventorySystem.takeOrder("iRobot-Roomba", 163);

        inventorySystem.processOrders();

        System.out.println(inventorySystem.getDistinctInventoryItemCount());
    }
}
/**
 * Output:
 * -------
 * Lookup:WH-CH710N
 * HashCode for headphone1: 1933863327
 * HashCode for headphone2: 1933863327
 * Catalog size: 1
 * 
 * Ordering for 111 with item WH-CH710N
 * Ordering for 232 with item SamsungTV
 * Ordering for 212 with item WH-CH710N
 * Ordering for 562 with item SamsungTV
 * Ordering for 217 with item WH-CH710N
 * Ordering for 162 with item iRobot-Roomba
 * Ordering for 163 with item iRobot-Roomba
 * Distinct items in inventory: 3
 */