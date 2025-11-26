// A simple change in Part interface needs to be reflected in all its sub-classes. Also, the PartOrder needs to be updated accordingly. 
// Basically it ripples throughout, hence a problem.
// What if the calculation logic / algo gets abstracted without changing Part_Bad, its subclasses and PartOrder class? -> comes Visitor Pattern

import java.util.ArrayList;
import java.util.List;

interface Part_Bad {
    double getCost();
}

class Wheel_Bad implements Part_Bad {
    @Override
    public double getCost() {
        return 10;
    }
}

class Headlight_Bad implements Part_Bad {
    @Override
    public double getCost() {
        return 20;
    }
}

class EngineOil_Bad implements Part_Bad {
    @Override
    public double getCost() {
        return 30;
    }
}

class PartOrder {
    private List<Part_Bad> parts = new ArrayList<>();
    public void addPart(Part_Bad part) {
        parts.add(part);
    }
    public double calculateShippingCost() {
        double totalCost = 0;
        for (Part_Bad part : parts) {
            totalCost += part.getCost();
        }
        return totalCost;
    }
}
public class VisitorExample_Bad {
    public static void main(String[] args) {
        PartOrder order = new PartOrder();
        order.addPart(new Wheel_Bad());
        order.addPart(new Headlight_Bad());
        order.addPart(new EngineOil_Bad());
        System.out.println("Total Shipping Cost: " + order.calculateShippingCost());
    }
}

/**
 * Output:
 * -------
 * Total Shipping Cost: 60.0
 */