public class Light {
    private boolean isOn;
    private final String name;
    public Light(String name) {
        this.name = name;
        this.isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " light is ON");
    }
    public void turnOff() {
        isOn = false;
        System.out.println(name + " light is OFF");
    }
    public void toggle() {
        if (isOn) {
            turnOff();
        } else {
            turnOn();
        }
    }
}
