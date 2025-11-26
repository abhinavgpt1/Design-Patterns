public class Main {
    public static void main(String[] args) {
        VisitorExample.compileClasses(); // this is just so we have Main and other classes in separate files.
        PartsOrder order = new PartsOrder();
        order.addPart(new EngineOil());
        order.addPart(new Wheel());
        order.addPart(new Headlight());
        
        order.accept(new ShippingCostPartVisitor());

        // PTR: Visitor interface needs to know all pieces it can visit.
        // PTR: Visitor pattern needs to be implemented right from inception of class hierarchy. It doesn't work like Adapter.

        // Other types of Vistors can be HolidaysAndDiscountVisitor, BlackFridayVisitor, etc.
        System.out.println();
        order.accept(new DisplayPartsVisitor()); // all we need to do is create a new visitor. No change in other code anywhere.
    }
}

/**
 * Output:
 * -------
 * ShippingCostPartVisitor: Calculating shipping cost for EngineOil (10). Current shipping cost: 10.0
 * ShippingCostPartVisitor: Calculating shipping cost for Wheel (20). Current shipping cost: 30.0
 * ShippingCostPartVisitor: Calculating shipping cost for Headlight (30). Current shipping cost: 60.0
 * ShippingCostPartVisitor: Total shipping cost for PartOrder: 60.0
 * 
 * We have EngineOil
 * We have Wheel
 * We have Headlight
 * We have PartsOrder
 */