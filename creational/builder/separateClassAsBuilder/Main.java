public class Main {
    public static void main(String[] args) {
        LunchOrder lunchOrder1 = new LunchOrder.LunchOrderBuilder()
                .withBread("Wheat")
                .withSauce("Tomato")
                .withPatty("Aloo")
                .build();
        lunchOrder1.printOrder();

        drawline(20);
        
        LunchOrder lunchOrder2 = new LunchOrder.LunchOrderBuilder()
                .withPatty("Chicken")
                .withSauce("Mustard")
                .build();
        lunchOrder2.printOrder();
        
        System.out.println();
        System.out.println("-----------Problem due to same builder for multiple objects-----------");
        System.out.println();
        // PTR: Don't use same builder for creation of multiple objects. 
        // If we use same LunchOrderBuilder for another LunchOrder, then stale data may appear.
        LunchOrder.LunchOrderBuilder LunchOrderbuilder = new LunchOrder.LunchOrderBuilder();
        LunchOrderbuilder.withBread("Wheat").withPatty("Chicken").withSauce("Tomato");
        
        LunchOrder nonVegLunchOrder = LunchOrderbuilder.build();
        nonVegLunchOrder.printOrder(); // bread: wheat, patty: Chicken, sauce: Tomato

        drawline(20);

        LunchOrderbuilder.withBread("Garlic").withSauce("Imli");
        LunchOrder vegLunchOrder = LunchOrderbuilder.build();
        vegLunchOrder.printOrder(); // bread: Garlic, patty: Chicken, sauce: Imli
        
        // Veg order didn't order any patty, but prev. order had patty set which appeared due to use of same builder.
    }
    
    public static void drawline(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
/**
 * Your order:
 * Bread: Wheat
 * Patty: Aloo
 * Sauce: Tomato
 * --------------------
 * Your order:
 * Patty: Chicken
 * Sauce: Mustard
 * 
 * -----------Problem due to same builder for multiple objects-----------
 * 
 * Your order:
 * Bread: Wheat
 * Patty: Chicken
 * Sauce: Tomato
 * --------------------
 * Your order:
 * Bread: Garlic
 * Patty: Chicken [WRONG]
 * Sauce: Imli
 */