
// Acts as factory pattern, since it provides flyweight Item based on product name (Can use enum for item names)
import java.util.HashMap;
import java.util.Map;

public class AmazonCatalog {
    private Map<String, Item> catalog = new HashMap<>();

    // Lookup aka factory
    public Item lookupItem(String itemName) {
        if (catalog.containsKey(itemName))
            return catalog.get(itemName);
        catalog.put(itemName, new Item(itemName));
        return catalog.get(itemName);
    }

    public int getCatalogSize() {
        return catalog.size();
    }

    // Redundant: Causes memory and performance issues due to creation of new instance.
    public Item getNewItem(String itemName) {
        return new Item(itemName);
    }
}
