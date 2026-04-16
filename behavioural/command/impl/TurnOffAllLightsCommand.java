import java.util.List;

public class TurnOffAllLightsCommand implements Command {
    private List<Light_Receiver> lights;

    public TurnOffAllLightsCommand(List<Light_Receiver> lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        // We could have used light.off() for all lights in List.
        // But, objective is not to turn off a light which is already Off.
        // Cater only to the lights which are On.
        for (Light_Receiver light : lights) {
            // System.out.println(light);
            if (light.isOn()) {
                light.toggle(); // or simply light.turnOff();
            }
        }
    }
}
