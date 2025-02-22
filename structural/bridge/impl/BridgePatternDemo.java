/**
 * Problem statement:
 * Say, we have Shape interface, Square and Circle extend Shape. We want to create BlueCircle, BlueSquare, GreenCircle, GreenSquare, etc.
 * -> We can't have concrete class for our use cases. What if in future there is a demand for RedTriangle
 * 
 * Solution: Separate Shape and Cicle as two different hierarchies/interfaces. Composition is the key here not inheritance.
 * 
 * qq: Why not both Shape and Circle as interface
 * ans: We need reference to color in Shape, it can't be public.
 *      All fields in interface are public static final, i.e. they are constants. It is generally recommended to avoid such interfaces
 * https://stackoverflow.com/questions/9446893/fields-in-interfaces#:~:text=All%20fields%20in,avoid%20such%20interfaces
 */

public class BridgePatternDemo {
    public static void main(String[] args) {
        Color blue = new Blue();
        Shape blueCircle = new Circle(blue);
        blueCircle.applyColor();
        blueCircle.drawShape();
        Shape blueSquare = new Square(blue);
        blueSquare.applyColor();
        blueSquare.drawShape();
    }
}
