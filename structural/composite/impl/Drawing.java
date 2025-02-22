import java.util.List;
import java.util.ArrayList;

public class Drawing extends DrawingComponent{
    private List<DrawingComponent> drawingComponents = new ArrayList<DrawingComponent>();
    public Drawing(String componentName) {
        this.componentName = componentName;
    }
    
    @Override
    public void draw(String color) {
        System.out.println("Drawing " + componentName + " ...");
        for(DrawingComponent dc: drawingComponents) {
            dc.draw(color);
        }
        System.out.println("--------completed--------");
        System.out.println();
    }
    
    @Override
    public void add(DrawingComponent drawingComponent){
        drawingComponents.add(drawingComponent);
    }

    @Override
    public void remove(DrawingComponent drawingComponent){
        drawingComponents.remove(drawingComponent);
    }
}
