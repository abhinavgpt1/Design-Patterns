/**
 * Problem statement:
 * Say, we have Shape interface, Square and Circle extend Shape.
 * We want to create BlueCircle, BlueSquare, GreenCircle, GreenSquare, etc.
 * How to proceed? Should we create concrete classes? What if in future there is
 * a demand for RedTriangle?
 * 
 * Solution: Separate Shape and Cicle as two different hierarchies/interfaces.
 * Composition (of color) aka "has-a" relationship is the key here not inheritance.
 * 
 * qq: Why isn't Shape an interface like Color? Weren't we supposed to make 2 interfaces in bridge pattern?
 * ans: We need instance-specific color for every shape. Having Shape as interface will have following disavdantages:
 * - Having color as a property in Shape would make it public-static-final.
 *  - It is generally recommended to avoid such interfaces
 *  - https://stackoverflow.com/questions/9446893/fields-in-interfaces#:~:text=All%20fields%20in,avoid%20such%20interfaces
 * - If we don't have color property in Shape, then we need to define this property is every implementation of Shape which is tedious.
 * 
 * Having Shape as an abstracted class with Color as protected member would let subclasses access it internally, not externally.
 */


public class Main {
    public static void main(String[] args) {
        Color blue = new Blue();
        Shape blueCircle = new Circle(blue);
        blueCircle.applyColor();
        blueCircle.drawShape();
        
        System.out.println();

        Shape blueSquare = new Square(blue);
        blueSquare.applyColor();
        blueSquare.drawShape();
    }
}
/**
 * Output:
 * Applying Blue color
 * Drawing Circle with color: Blue
 * 
 * Applying Blue color
 * Drawing Square with color: Blue
 */