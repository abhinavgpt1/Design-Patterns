public class TomatoSauceDecorator extends SandwichDecorator {

    public TomatoSauceDecorator(ISandwich sandwich) {
        super(sandwich);
    }

    @Override
    public void make() {
        // Since SandwichDecorator is an abstract class, there can't be more decorator/inheritance.
        // But since this abstract class may override & define make(), it is
        // beneficial to do a super.make(); instead of re-writing logic in subclasses.

        super.make(); // sandwich without tomato sauce
        addTomatoSauce();
    }

    private void addTomatoSauce() {
        System.out.println("Adding tomato sauce");
    }
}