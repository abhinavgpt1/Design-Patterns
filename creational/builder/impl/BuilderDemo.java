public class BuilderDemo {
    public static void main(String[] args) {
        LunchOrderBuilder lunchOrder = new LunchOrderBuilder.Builder()
                .withBread("Wheat")
                .withSauce("Tomato")
                .withPatty("Aloo")
                .build();
        lunchOrder.print();
        LunchOrderBuilder lunchOrder2 = new LunchOrderBuilder.Builder()
                .withPatty("Chicken")
                .withSauce("Mustard")
                .build();
        lunchOrder2.print();

        // demerit of static inner class
        // if we use same builder for construction then stale data may exist
        LunchOrderBuilder.Builder builder = new LunchOrderBuilder.Builder();
        builder.withBread("wheat").withPatty("Chicken");
        LunchOrderBuilder lunchOrder3 = builder.build();
        lunchOrder3.print();
        builder.withBread("Garlic").withSauce("Imli");
        LunchOrderBuilder lunchOrder4 = builder.build();
        lunchOrder4.print();
    }
}
