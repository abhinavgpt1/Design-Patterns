public class TurnOnLightCommand implements ICommand {
    private LightDevice light;

    public TurnOnLightCommand(LightDevice light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}