public class Main {
    public static void main(String[] args) {
        PartsOrder order = new PartsOrder();
        order.addPart(new EngineOil());
        order.addPart(new Wheel());
        order.addPart(new Headlight());

        order.accept(new ShippingCostPartVisitor());

        System.out.println();
        
        // All we need to do is create a new visitor. No change in other code anywhere.
        // More vistors could be HolidaysAndDiscountVisitor, BlackFridayVisitor
        order.accept(new DisplayPartsVisitor());

        // PTR:
        // - Visitor interface needs to know all pieces it can visit / elements it supports.
        // - Visitor pattern needs to be implemented right from inception of class hierarchy. It doesn't work like Adapter.
    }
}

/**
 * Output:
 * -------
 * ShippingCostPartVisitor: Calculating shipping cost for EngineOil (10). Current shipping cost: 10.00
 * ShippingCostPartVisitor: Calculating shipping cost for Wheel (20). Current shipping cost: 30.00
 * ShippingCostPartVisitor: Calculating shipping cost for Headlight (30). Current shipping cost: 60.00
 * ShippingCostPartVisitor: Total shipping cost for PartOrder: 60.0
 * 
 * We have EngineOil
 * We have Wheel
 * We have Headlight
 * We have PartsOrder
 */