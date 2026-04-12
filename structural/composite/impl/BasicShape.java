public class BasicShape extends DrawingComponent {
    public BasicShape(String componentName, String color) {
        this.componentName = componentName;
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + componentName + " with color " + color);
    }
}
