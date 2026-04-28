// Context - contains multiple states. Each state knows its next state + handles the request without even knowing about other states.
public class Fan {
    public static final FanState OFF_STATE = new FanOffState("OFF");
    public static final FanState LOW_STATE = new FanLowState("LOW");
    public static final FanState MED_STATE = new FanMedState("MED");

    private FanState currentState;

    public Fan() {
        // Bryan Hansen did following intialization without making states static final.
        // offState = new FanOffState();
        // lowState = new FanLowState();
        // medState = new FanMedState();
        // My reason for static final: Since they are shared across all Fan instances, 
        // it's good to have reusable singleton states.

        // In future, if states require more context, then maybe we can initalise like
        // offState = new FanOffState(this);
        currentState = OFF_STATE;
    }

    public void pullChain() {
        currentState.handleRequest(this);
    }

    public void setState(FanState state) {
        this.currentState = state;
    }

    public String toString() {
        return "toString(): Fan is " + currentState; // will call currentState.toString()
    }
}
