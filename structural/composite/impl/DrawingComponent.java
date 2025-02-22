public abstract class DrawingComponent {
    String componentName;
    public String getComponentName() {
        return componentName;
    }
    public void draw(String color){}

    // Not really necessary, but adds a contract layer
    // These functions are added here to restrict operations at this level 
    // (i.e. by ref of DrawingComponent or classes implementing it unless they override these methods eg. Drawing.java but not DrawingItem.java), 
    // Operations like these are not fine for leaf nodes like DrawingItem, hence it shouldn't be overrided/implemented in it
    public void add(DrawingComponent drawingComponent) {
        throw new UnsupportedOperationException("Adding item isn't allowed like this");
    }
    public void remove(DrawingComponent drawingComponent) {
        throw new UnsupportedOperationException("Adding item isn't allowed like this");
    }

}
