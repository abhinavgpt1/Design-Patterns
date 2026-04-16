public class ToggleLightOnOffCommand implements Command {
    private Light_Receiver light;

    public ToggleLightOnOffCommand(Light_Receiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.toggle();
    }
}