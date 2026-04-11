public abstract class Shape {
    // protected (and not private/PLA) so that it can be accessed by subclasses
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();

    public abstract void drawShape();
}
