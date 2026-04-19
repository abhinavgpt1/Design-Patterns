public class TurnOnFanCommand implements ICommand {
    private FanDevice fan;

    public TurnOnFanCommand(FanDevice fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.turnOn();
    }
}