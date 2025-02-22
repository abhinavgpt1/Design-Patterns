public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        color.applyColor();
    }

    @Override
    public void drawShape() {
        System.out.println("Drawing Square with color: " + color.getColor());
    }
    
}
