public class DressingDecorator extends SandwichDecorator {

    public DressingDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }
    @Override
    public String make(){
        String customSandwichTask = customSandwich.make();
        String addingDressingTask = addDressing();
        return customSandwichTask + addingDressingTask; 
    }

    private String addDressing() {
        return "Adding tomato sauce\n";
    }
}
