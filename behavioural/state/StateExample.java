class Fan_Bad { // named this way to avoid conflict with Fan.java
    public static final String LOW_STATE = null;
    private final int OFF = 0;
    private final int LOW = 1;
    private final int MEDIUM = 2;

    private int state;
    public Fan_Bad() {
        state = OFF;
    }

    public void pullChain() {
        if(state == OFF) {
            state = LOW;
            System.out.println("Fan turned to LOW");
        } else if(state == LOW) {
            state = MEDIUM;
            System.out.println("Fan turned to MEDIUM");
        } else if(state == MEDIUM) {
            state = OFF;
            System.out.println("Fan turned to OFF");
        }
    }

    public String toString() {
        if(state == OFF) return "Fan: OFF";
        else if(state == LOW) return "Fan: LOW";
        else return "Fan: MEDIUM";
    }
}

// This is a bad implementation of Fan and its states. Imagine adding and handling another state HIGH. Better use the State Pattern.
public class StateExample {
    public static void main(String[] args) {
        Fan_Bad fan = new Fan_Bad();
        System.out.println(fan); // OFF
        fan.pullChain();
        System.out.println(fan); // LOW
        fan.pullChain();
        System.out.println(fan); // MEDIUM
        fan.pullChain();
        System.out.println(fan); // OFF
        fan.pullChain();
        System.out.println(fan); // LOW
    }
}

/**
 * Output:
 * -------
 * Fan: OFF
 * Fan turned to LOW
 * Fan: LOW
 * Fan turned to MEDIUM
 * Fan: MEDIUM
 * Fan turned to OFF
 * Fan: OFF
 * Fan turned to LOW
 * Fan: LOW
 */