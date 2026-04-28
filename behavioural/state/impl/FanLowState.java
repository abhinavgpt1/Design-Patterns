public class FanLowState implements FanState {
    String stateName;

    public FanLowState(String stateName) {
        this.stateName = stateName;
    }

    public String toString() {
        return this.stateName;
    }

    @Override
    public void handleRequest(Fan fan) {
        // Business logic says transition to MED State
        // This is a State-driven transition example, hence the next state is hardcoded here.
        // It's tightly coupled tough, eg. if LOW -> MED1 -> MED2 -> HIGH in future, then it violates the Open-Closed Principle.

        FanState nextState = Fan.MED_STATE;
        fan.setState(nextState);
        System.out.println("pullChain(): Fan turned to " + nextState);
    }
}
