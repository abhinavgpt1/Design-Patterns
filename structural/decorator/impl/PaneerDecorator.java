public class PaneerDecorator extends SandwichDecorator {

    public PaneerDecorator(ISandwich sandwich) {
        super(sandwich);
    }

    @Override
    public void make() {
        // Since SandwichDecorator is an abstract class, there can't be more decorator/inheritance.
        // But since this abstract class may override & define make(), it is
        // beneficial to do a super.make(); instead of re-writing logic in subclasses,
        // for example here. Check TomatoSauceDecorator for such impl.

        sandwich.make(); // sandwich without paneer
        addPaneer();
    }

    // Add-on functionality/recipe can be private
    private void addPaneer() {
        System.out.println("Adding paneer");
    }
}
