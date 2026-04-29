public class ShippingCostPartVisitor implements PartVisitor {

    private double shippingCost = 0.0;
    private final String BASE_VISIT_MSG = "ShippingCostPartVisitor: Calculating shipping cost for %s. Current shipping cost: %.2f";

    // Note: visit(this) is not just for type resolution - it gives you the actual object to operate on.
    // It's a simple example where object's behavior isn't utilised,
    // which you ideally can & should enabling behavior based on object type.
    // eg. shippingCost += wheel.getWeight() * 20.
    @Override
    public void visit(EngineOil engineOil) {
        shippingCost += 10;
        System.out.println(BASE_VISIT_MSG.formatted("EngineOil (10)", shippingCost));
    }

    @Override
    public void visit(Wheel wheel) {
        shippingCost += 20;
        System.out.println(BASE_VISIT_MSG.formatted("Wheel (20)", shippingCost));
    }

    @Override
    public void visit(Headlight headlight) {
        shippingCost += 30;
        System.out.println(BASE_VISIT_MSG.formatted("Headlight (30)", shippingCost));
    }

    @Override
    public void visit(PartsOrder partOrder) {
        // can add logic to give discount
        System.out.println("ShippingCostPartVisitor: Total shipping cost for PartOrder: " + shippingCost);
    }
}