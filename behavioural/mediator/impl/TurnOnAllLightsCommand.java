public class TurnOnAllLightsCommand {
    Mediator mediator;

    public TurnOnAllLightsCommand(Mediator mediator) {
        this.mediator = mediator;
    }

    public void execute() {
        mediator.turnOnAll();
    }
}