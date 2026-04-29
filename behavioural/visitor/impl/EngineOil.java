// Recall pitfall: Every element is forced to implement accept()
public class EngineOil implements Part {
    @Override
    public void accept(PartVisitor visitor) {
        visitor.visit(this);
    }
}