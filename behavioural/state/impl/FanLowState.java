public class FanLowState implements FanState {
    String name;
    public FanLowState(String name) {
        this.name = name;
    }
    public String toString() {
        return this.name;
    }

    @Override
    public void handleRequest(Fan fan) {
        // Business logic says transition to MED State
        FanState nextState = Fan.MED_STATE;
        fan.setState(nextState);
        System.out.println("pullChain(): Fan turned to " + nextState);
    }
}
