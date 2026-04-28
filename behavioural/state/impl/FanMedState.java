public class FanMedState implements FanState {
    private String stateName;

    public FanMedState(String stateName) {
        this.stateName = stateName;
    }

    public String toString() {
        return this.stateName;
    }

    @Override
    public void handleRequest(Fan fan) {
        // Business logic says transition to OFF State
        // This is a State-driven transition example, hence the next state is hardcoded here.
        // It's tightly coupled tough, eg. if MED -> HIGH & HIGH -> OFF in future, then it violates the Open-Closed Principle.

        FanState nextState = Fan.OFF_STATE;
        fan.setState(nextState);
        System.out.println("pullChain(): Fan turned to " + nextState);
    }
}