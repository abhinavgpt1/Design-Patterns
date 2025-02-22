public class DecoratorDemo {
    public static void main(String[] args) {
        Sandwich normalSandwich = new SimpleSandwich();
        System.out.println(normalSandwich.make());
        
        Sandwich paneerSandwich = new PaneerSandwich(normalSandwich);
        System.out.println(paneerSandwich.make());
        
        Sandwich paneerSandwichWithSauce = new DressingDecorator(paneerSandwich);
        System.out.println(paneerSandwichWithSauce.make());

        Sandwich normalSandwichWithSauce = new DressingDecorator(normalSandwich);
        System.out.println(normalSandwichWithSauce.make());
        //DressingDecorator and PaneerDecorator are independent
    }
}
/*
 * Sandwich containing mayo, cabbage and bread

 * Sandwich containing mayo, cabbage and bread
 * Adding Paneer and black pepper
 * 
 * Sandwich containing mayo, cabbage and bread
 * Adding Paneer and black pepper
 * Adding tomato sauce
 * 
 * Sandwich containing mayo, cabbage and bread
 * Adding tomato sauce
 */
