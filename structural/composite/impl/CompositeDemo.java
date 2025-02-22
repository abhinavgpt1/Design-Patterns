public class CompositeDemo {
    public static void main(String[] args) {
        DrawingItem cone = new DrawingItem("cone");
        DrawingItem circle = new DrawingItem("circle");
        Drawing iceCream = new Drawing("Ice cream");
        iceCream.add(cone);
        iceCream.add(circle);
        iceCream.draw("white");

        DrawingItem frame = new DrawingItem("Frame around drawing");
        DrawingItem person = new DrawingItem("Person eating icecream");
        Drawing personEatingIceCream = new Drawing("Person eating ice cream and framing it");
        personEatingIceCream.add(iceCream);
        personEatingIceCream.add(person);
        personEatingIceCream.add(frame);
        personEatingIceCream.draw("white");

        try {
            DrawingItem cherryOnCircle = new DrawingItem("cherryOnCircle");
            circle.add(cherryOnCircle);
        } catch (UnsupportedOperationException ex) {
            System.out.println("operation add/remove not applicable on Leaf node");
        }
    }
    // this code can be improved by introducing Color.java and storing drawingComponents as Map<DrawingComponent, Color>
}

/**
 * Drawing Ice cream ...
 * Drawing cone with color white
 * Drawing circle with color white
 * --------completed--------
 * 
 * Drawing Person eating ice cream and framing it ...
 * Drawing Ice cream ...
 * Drawing cone with color white
 * Drawing circle with color white
 * --------completed--------
 * 
 * Drawing Person eating icecream with color white
 * Drawing Frame around drawing with color white
 * --------completed--------
 * 
 * operation add/remove not applicable on Leaf node
 */