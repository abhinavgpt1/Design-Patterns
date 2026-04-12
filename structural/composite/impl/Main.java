public class Main {
    public static void main(String[] args) {
        BasicShape cone = new BasicShape("Cone", "Brown");
        BasicShape scoop = new BasicShape("Scoop", "White");
        Drawing vanillaIceCream = new Drawing("Ice Cream");
        vanillaIceCream.add(cone);
        vanillaIceCream.add(scoop);
        vanillaIceCream.draw();

        System.out.println();

        BasicShape frame = new BasicShape("Frame", "Golden");
        BasicShape person = new BasicShape("Person", "Brown");
        Drawing personEatingIceCream = new Drawing("Framed drawing of a person eating ice cream");
        personEatingIceCream.add(vanillaIceCream);
        personEatingIceCream.add(person);
        personEatingIceCream.add(frame);
        personEatingIceCream.draw();

        System.out.println();

        try {
            BasicShape cherryOnScoop = new BasicShape("cherryOnScoop", "Red");
            scoop.add(cherryOnScoop);
        } catch (UnsupportedOperationException ex) {
            System.out.println("operation add/remove not applicable on BasicShape/leaf node");
        }
    }
    // This code can be improved by 
    // - introducing enum Color with hexcode
    // - storing drawingComponents as Map<DrawingComponent, Color> instead of color
    // property for each component. There has to be an overrloaded fn draw(String
    // color) in Shape. draw() alone can't help in drawing components with color.
    // Hence, this is a pitfall of Composite that it oversimplifies.
}

/**
 * Output:
 * -------
 * Drawing Ice Cream...
 * Drawing Cone with color Brown
 * Drawing Scoop with color White
 * 
 * Drawing Framed drawing of a person eating ice cream...
 * Drawing Ice Cream...
 * Drawing Cone with color Brown
 * Drawing Scoop with color White
 * Drawing Person with color Brown
 * Drawing Frame with color Golden
 * 
 * operation add/remove not applicable on leaf node
 */