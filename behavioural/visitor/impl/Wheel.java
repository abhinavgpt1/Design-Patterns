// Recall pitfall: Every element is forced to implement accept()
public class Wheel implements Part {
    @Override
    public void accept(PartVisitor visitor) {
        visitor.visit(this);
    }
}