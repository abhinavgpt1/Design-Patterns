public abstract class Device {
    protected boolean isOn = false;

    public boolean isOn() {
        return isOn;
    }

    public abstract void toggle();
    public abstract void turnOn();
    public abstract void turnOff();
}
