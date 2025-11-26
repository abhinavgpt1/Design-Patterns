import java.util.List;

// objective is not to turn off what already is off. cater only to lights that are ON.
public class AllLightsCommand implements Command {
    private List<Light> lights;

    public AllLightsCommand(List<Light> lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        // we want to shut all lights OFF using this command class
        for (Light light : lights) {
            if (light.isOn()) {
                light.toggle(); // or simply light.turnOff();
            }
        }
    }
}
