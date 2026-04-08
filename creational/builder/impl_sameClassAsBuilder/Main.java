public class Main {
    public static void main(String args[]) {
        LunchOrder_SelfBuilder lunchOrder1 = new LunchOrder_SelfBuilder()
                .withBread("Wheat")
                .withSauce("Tomato")
                .withPatty("Aloo");
        lunchOrder1.printOrder();
        
        drawline(15);

        LunchOrder_SelfBuilder lunchOrder2 = new LunchOrder_SelfBuilder()
                .withPatty("Chicken")
                .withSauce("Mustard");
        lunchOrder2.printOrder();
    }

    public static void drawline(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}

/**
 * Output:
 * -------
 * Your order:
 * Bread: Wheat
 * Patty: Aloo
 * Sauce: Tomato
 * ---------------
 * Your order:
 * Patty: Chicken
 * Sauce: Mustard
 */