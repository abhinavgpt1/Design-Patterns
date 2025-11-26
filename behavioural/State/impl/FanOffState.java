public class FanOffState implements FanState {
    String name;
    public FanOffState(String name) {
        this.name = name;
    }
    public String toString() {
        return this.name;
    }

    // Fan fan; // can initalize in its constructor if needed. 

    // In future, changing business logic is easier i.e. to transition.
    // Also, debugging is easier since each state has its own class and logic.
    @Override
    public void handleRequest(Fan fan) {
        // Business logic says transition to Low State
        FanState nextState = Fan.LOW_STATE; // to hide this, implement a method getNextState() in Fan and pass it below. This way no state would know where to transition.
        fan.setState(nextState);
        System.out.println("pullChain(): Fan turned to " + nextState);
    }
}