public class Switch {
    IMediator mediator;

    public Switch(IMediator mediator) {
        this.mediator = mediator;
    }

    public void press(Action action) {
        mediator.notify(action);
    }
}