public class TurnOffFanCommand implements ICommand {
    private FanDevice fan;

    public TurnOffFanCommand(FanDevice fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOff();
    }
}