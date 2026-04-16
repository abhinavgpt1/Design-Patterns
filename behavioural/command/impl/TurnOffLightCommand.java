public class TurnOffLightCommand implements Command {
    private Light_Receiver light;

    public TurnOffLightCommand(Light_Receiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}