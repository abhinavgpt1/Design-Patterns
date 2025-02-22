public class PaneerSandwich extends SandwichDecorator {

    public PaneerSandwich(Sandwich customSandwich) {
        super(customSandwich);
    }
    
    @Override
    public String make(){
        String customSandwichTask = customSandwich.make();
        String addingPaneerTask = addPaneer();
        return customSandwichTask + addingPaneerTask; 
    }

    private String addPaneer() {
        return "Adding Paneer and black pepper\n";
    }
}
