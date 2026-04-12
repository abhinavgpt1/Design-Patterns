public abstract class DrawingComponent {
    protected String componentName;
    protected String color;

    // Avoid passing String color in this function to avoid single color drawing.
    public void draw() {
    }

    // add/remove are added here so that client code can treat every node as a DrawingComponent (same type for leaves and containers). 
    // That is the usual Composite trade-off: one interface for the whole tree, even though only composites actually hold children.
    //
    // Leaf types (eg. Shape) should not implement these, as they cannot contain other components.
    // Hence they keep these defaults defintion and throw exception if called.
    public void add(DrawingComponent drawingComponent) {
        throw new UnsupportedOperationException("Adding item isn't allowed like this");
    }

    public void remove(DrawingComponent drawingComponent) {
        throw new UnsupportedOperationException("Adding item isn't allowed like this");
    }
}
