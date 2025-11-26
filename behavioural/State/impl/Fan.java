// Context - contains multiple states. Each state knows its next state + handles the request without even knowing about other states.
public class Fan {
    public static final FanState OFF_STATE = new FanOffState("OFF");
    public static final FanState LOW_STATE = new FanLowState("LOW");
    public static final FanState MED_STATE = new FanMedState("MED");

    FanState currentState;
    public Fan() {
        // this was the initialization by Bryan Hansen without making these fields static / final. I think these states should be static final as they are shared across all Fan instances.
        // offState = new FanOffState();
        // lowState = new FanLowState();
        // medState = new FanMedState();

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
