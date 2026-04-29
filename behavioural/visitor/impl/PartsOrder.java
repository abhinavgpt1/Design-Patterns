// qq: PartsOrder isn't a part, then why implement it?
// ans: This is added to support externalization of part order calculation given any PartVisitor. 
// This becomes more like Composite where "has parts" becomes "is a Part". It's a design trade-off, not literal truth.
// eg. ShippingCostPartVisitor, DisplayPartsVisitor
// tldr; not implementing Part also works. 
// You can have a simple `public double calculate(Visitor)` function to perform task on each part and sum the shipping cost.

import java.util.ArrayList;
import java.util.List;

// Recall pitfall: Every element is forced to implement accept()
public class PartsOrder implements Part {
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