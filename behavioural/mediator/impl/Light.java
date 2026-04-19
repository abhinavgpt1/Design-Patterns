public class Light {
    private boolean isOn = false; // default light is Off
    private final String name;

    public Light(String name) {
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
            System.out.println(name + " light is already On");
            return;
        }
        System.out.println(name + " light turned On");
        isOn = true;
    }

    public void turnOff() {
        if (!isOn) {
            System.out.println(name + " light is already Off");
            return;
        }
        System.out.println(name + " light turned Off");
        isOn = false;
    }
}