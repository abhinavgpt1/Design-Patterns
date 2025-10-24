public class BuilderLunchDemo {
    public static void main(String args[]) {
        LunchOrder lunchOrder = new LunchOrder()
                .withBread("Wheat")
                .withSauce("Tomato")
                .withPatty("Aloo");
        lunchOrder.print();
    }
}