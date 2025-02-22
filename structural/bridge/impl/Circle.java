public class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        color.applyColor();
    }

    @Override
    public void drawShape() {
        System.out.println("Drawing Circle with color: " + color.getColor());
    }
    
}
