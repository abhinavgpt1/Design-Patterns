//acts as factory (pattern) -> since it provides Item.class (flyweight) objects based on type of item
//can use enum for types

import java.util.HashMap;
import java.util.Map;

public class AmazonCatalog {
    private Map<String, Item> cacheItems = new HashMap<>();

    //lookup method aka factory method
    public Item lookupItem(String itemName) {
        if(cacheItems.containsKey(itemName))
            return cacheItems.get(itemName);
        cacheItems.put(itemName, new Item(itemName));
        return cacheItems.get(itemName);
    }
    public int getCatalogSize() {
        return cacheItems.size();
    }

    public Item getNewItem(String itemName) {
        return new Item(itemName);
    }
}
