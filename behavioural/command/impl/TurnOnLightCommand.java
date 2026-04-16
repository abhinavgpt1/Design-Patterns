public class TurnOnLightCommand implements Command {
    private Light_Receiver light;

    public TurnOnLightCommand(Light_Receiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}