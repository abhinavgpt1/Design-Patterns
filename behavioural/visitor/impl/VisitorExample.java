import java.util.ArrayList;
import java.util.List;

interface Part {
    void accept(PartVisitor visitor); // function which delegates visitor to handle business logic
}
class EngineOil implements Part {
    @Override
    public void accept(PartVisitor visitor) {
        visitor.visit(this);
    }
}
class Wheel implements Part {
    @Override
    public void accept(PartVisitor visitor) {
        visitor.visit(this);
    }
}
class Headlight implements Part {
    @Override
    public void accept(PartVisitor visitor) {
        visitor.visit(this);
    }
}

class PartsOrder implements Part { // this is added so that any PartVisitor be assigned to do computation for the part order
    private List<Part> parts = new ArrayList<>();
    public void addPart(Part part) {
        parts.add(part);
    }
    
    @Override
    public void accept(PartVisitor visitor) {
        for (Part part : parts) {
            part.accept(visitor); // delegate to each part to accept the visitor
        }
        visitor.visit(this);
    }
}

interface PartVisitor {
    void visit(EngineOil engineOil);
    void visit(Wheel wheel);
    void visit(Headlight headlight);
    void visit(PartsOrder partOrder);
}

class ShippingCostPartVisitor implements PartVisitor {

    double shippingCost = 0.0;

    @Override
    public void visit(EngineOil engineOil) {
        shippingCost += 10;
        System.out.println("ShippingCostPartVisitor: Calculating shipping cost for EngineOil (10). Current shipping cost: " + shippingCost);
    }

    @Override
    public void visit(Wheel wheel) {
        shippingCost += 20;
        System.out.println("ShippingCostPartVisitor: Calculating shipping cost for Wheel (20). Current shipping cost: " + shippingCost);
    }

    @Override
    public void visit(Headlight headlight) {
        shippingCost += 30;
        System.out.println("ShippingCostPartVisitor: Calculating shipping cost for Headlight (30). Current shipping cost: " + shippingCost);
    }

    @Override
    public void visit(PartsOrder partOrder) {
        // can add logic to give discount
        System.out.println("ShippingCostPartVisitor: Total shipping cost for PartOrder: " + shippingCost);
    }

}
public class VisitorExample {
    public static void compileClasses(){
        
    }
}
