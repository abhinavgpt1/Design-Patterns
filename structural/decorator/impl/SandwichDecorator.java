public abstract class SandwichDecorator implements ISandwich {

    protected ISandwich sandwich;

    public SandwichDecorator(ISandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public void make() {
        sandwich.make();
    }
}