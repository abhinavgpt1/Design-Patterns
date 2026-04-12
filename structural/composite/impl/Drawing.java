import java.util.List;
import java.util.ArrayList;

public class Drawing extends DrawingComponent {
    private List<DrawingComponent> drawingComponents = new ArrayList<DrawingComponent>();

    public Drawing(String componentName) {
        this.componentName = componentName;
        this.color = null;
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + componentName + "...");
        for (DrawingComponent dc : drawingComponents) {
            dc.draw();
        }
    }

    @Override
    public void add(DrawingComponent drawingComponent) {
        drawingComponents.add(drawingComponent);
    }

    @Override
    public void remove(DrawingComponent drawingComponent) {
        drawingComponents.remove(drawingComponent);
    }
}
