import java.util.ArrayList;
import java.util.List;

// Earlier individual command holded functionality like turnOnLight, turnOffLight, toggleLight, turnOnAllLights, etc. 
// now all the functionalities are centralised in Mediator. Commands reference this mediator 
public class Mediator {
    private List<Light> lights = new ArrayList<>();

    public void registerLight(Light light) {
        lights.add(light);
    }

    public void turnOnAll() {
        for (Light light : lights) {
            if (!light.isOn()) // we don't turn on a light which is already on
                light.toggle(); // or simply, light.turnOff()
        }
    }

    public void turnOffAll() {
        for (Light light : lights) {
            if (light.isOn())
                light.toggle();
        }
    }

    public void toggleAll() {
        for (Light light : lights) {
            light.toggle();
        }
    }
}