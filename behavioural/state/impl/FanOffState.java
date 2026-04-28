public class FanOffState implements FanState {
    private String stateName;

    public FanOffState(String stateName) {
        this.stateName = stateName;
    }

    public String toString() {
        return this.stateName;
    }

    // Fan fan;
    // - if more context is needed, you may link fan object.
    // - Inside Fan(), set states as `offState = new FanOffState(this);`

    // Handle request separately under states makes it easier to change business logic in future.
    // Also, debugging is easier since each state has its own class and logic, but
    // Pitfall: if there are too many states, it's difficult to debug and understand the flow of system.
    @Override
    public void handleRequest(Fan fan) {
        // Business logic says transition to Low State
        // This is a State-driven transition example, hence the next state is hardcoded here.
        // It's tightly coupled tough, eg. if OFF -> LOW1 -> LOW2 -> MED in future, then it violates the Open-Closed Principle.

        // For context-driven transition, create a map, or a conditional if-else inside a sepaarte function in Fan class.
        // eg. public FanState getNextState(Fan fan)
        // This way no state would know where to transition.

        FanState nextState = Fan.LOW_STATE;
        fan.setState(nextState);
        System.out.println("pullChain(): Fan turned to " + nextState);
    }
}