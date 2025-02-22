public class DrawingItem extends DrawingComponent{
    public DrawingItem(String componentName){
        this.componentName = componentName;
    }
    
    @Override
    public void draw(String color) {
        System.out.println("Drawing " + componentName + " with color " + color);
    }
}
