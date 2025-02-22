public abstract class Shape {
    protected Color color; //protected (and not private) so that it can be accessed by the concrete classes

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();
    public abstract void drawShape();
    
}
