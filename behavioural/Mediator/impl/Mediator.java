import java.util.ArrayList;
import java.util.List;

// earlier the Command used to handle lights and functionality like turnOnAll -> now the Mediator does it
public class Mediator {
    List<Light> lights;

    public Mediator() {
        lights = new ArrayList<>();
    }

    public void registerLight(Light light) {
        lights.add(light);
    }

    public void turnOnAll() {
        for (Light light : lights) {
            if(!light.isOn()) // we don't turn on an already on light
                light.toggle();
        }
    }

    public void turnOffAll() {
        for (Light light : lights) {
            if(light.isOn()) // we don't turn off an already off light
                light.toggle();
        }
    }

    public void toggleAll() {
        for (Light light : lights) {
            light.toggle();
        }
    }
}