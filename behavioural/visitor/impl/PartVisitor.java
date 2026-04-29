// Recall pitfall: 
// - Visitor needs to handle every element it supports. 
// - Adding a new visitor is easy, but adding a new element requires updating all visitors which want to handle it.
interface PartVisitor {
    void visit(EngineOil engineOil);

    void visit(Wheel wheel);

    void visit(Headlight headlight);

    void visit(PartsOrder partOrder);
}