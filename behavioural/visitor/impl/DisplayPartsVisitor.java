public class DisplayPartsVisitor implements PartVisitor {

    @Override
    public void visit(EngineOil engineOil) {
        System.out.println("We have EngineOil");
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("We have Wheel");
    }

    @Override
    public void visit(Headlight headlight) {
        System.out.println("We have Headlight");
    }

    @Override
    public void visit(PartsOrder partOrder) {
        System.out.println("We have PartsOrder");
    }

}
