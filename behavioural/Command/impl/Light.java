// Receiver class
public class Light {
    private boolean isOn = false; // state of receiver is not known to command. Command can just toggle it.

    public boolean isOn() {
        return isOn;
    }
    
    public void toggle() {
        if (isOn) {
            turnOff();
        } else {
            turnOn();
        }
        isOn = !isOn;
    }
    public void turnOn() {
        System.out.println("The light is on");
    }
    
    public void turnOff() {
        System.out.println("The light is off");
    }
}
