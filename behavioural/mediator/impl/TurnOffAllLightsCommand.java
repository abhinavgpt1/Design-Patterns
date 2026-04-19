public class TurnOffAllLightsCommand {
    private Mediator mediator;

    public TurnOffAllLightsCommand(Mediator mediator) {
        this.mediator = mediator;
    }

    public void execute() {
        mediator.turnOffAll();
    }
}