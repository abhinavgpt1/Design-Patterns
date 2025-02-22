public class FlyweightDemo {

    public static void main(String[] args) {

        // just for verification
        AmazonCatalog c = new AmazonCatalog();
        System.out.println(c.lookupItem("Samsung Headphones WH-CH710N"));
        Item x = c.lookupItem("Samsung Headphones WH-CH710N");
        Item y = c.lookupItem("Samsung Headphones WH-CH710N");
        System.out.println(x.hashCode());
        System.out.println(y.hashCode());
        System.out.println(c.getCatalogSize());

        // practical demo
        // By traditional Item creation using c.getNewItem every order will have new instance for same item thus leading to high memory consumption when irl the item is exactly same in orders
        // using flyweight the memory consumption decreases
        InventorySystem ims = new InventorySystem();
        ims.takeOrder("WH-CH710N", 111);
        ims.takeOrder("SamsungTV", 232);
        ims.takeOrder("WH-CH710N", 212);
        ims.takeOrder("SamsungTV", 562);
        ims.takeOrder("WH-CH710N", 217);
        ims.takeOrder("Roomba", 162);
        ims.takeOrder("Roomba", 163);

        ims.processOrders();
        System.out.println(ims.report());
    }
}
