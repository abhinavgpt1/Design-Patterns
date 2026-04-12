public class Main {
    public static void main(String[] args) {
        ISandwich normalSandwich = new SimpleSandwich();
        normalSandwich.make();
        System.out.println();

        ISandwich paneerSandwich = new PaneerDecorator(normalSandwich);
        paneerSandwich.make();
        System.out.println();

        ISandwich paneerSandwichWithSauce = new TomatoSauceDecorator(paneerSandwich);
        paneerSandwichWithSauce.make();
        System.out.println();

        ISandwich normalSandwichWithSauce = new TomatoSauceDecorator(normalSandwich);
        normalSandwichWithSauce.make();
        System.out.println();
        // TomatoSauceDecorator and PaneerDecorator are independent.
        // FYI, a subclass decorator can extend only one abstract decorator. And since
        // this abstract decorator can override and define make(), it is beneficial to
        // do a super.make(); instead of re-writing logic in subclasses.
    }
}
/*
 * Simple coleslaw sandwich
 * 
 * Simple coleslaw sandwich
 * Adding paneer
 * 
 * Simple coleslaw sandwich
 * Adding paneer
 * Adding tomato sauce
 * 
 * Simple coleslaw sandwich
 * Adding tomato sauce
 */
