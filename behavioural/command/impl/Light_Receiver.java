public class Light_Receiver {
    // State of receiver is unknown to the command. 
    // Command can act on the functionality of the receiver.
    private boolean isOn = false; // default light is off
    private final String name;

    public Light_Receiver(String name) {
        this.name = name;
    }

    public boolean isOn() {
        return isOn;
    }
    
    public void toggle() {
        if (isOn) {
            turnOff();
        } else {
            turnOn();
        }
    }
    public void turnOn() {
        if (isOn) {
            System.out.println(name + " is already On");
            return;
        }
        System.out.println(name + " turned On");
        isOn = true;
    }
    
    public void turnOff() {
        if (!isOn) {
            System.out.println(name + " is already Off");
            return;
        }
        System.out.println(name + " turned Off");
        isOn = false;
    }

    @Override
    public String toString() {
        return name + "{" + "isOn=" + isOn + '}';
    }
}
