public class TurnOffLightCommand implements ICommand {
    private LightDevice light;

    public TurnOffLightCommand(LightDevice light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}