public abstract class Shape {
    // -------------This is the bridge-------------
    protected Color color; // protected (and not private/PLA) so that it can be accessed by subclasses if it was in another package.

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();

    public abstract void drawShape();
}
