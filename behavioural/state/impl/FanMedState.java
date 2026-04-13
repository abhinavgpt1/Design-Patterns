public class FanMedState implements FanState {
    String name;
    public FanMedState(String name) {
        this.name = name;
    }
    public String toString() {
        return this.name;
    }

    @Override
    public void handleRequest(Fan fan) {
        // Business logic says transition to OFF State
        FanState nextState = Fan.OFF_STATE;
        fan.setState(nextState);
        System.out.println("pullChain():Fan turned to " + nextState);
    }
}