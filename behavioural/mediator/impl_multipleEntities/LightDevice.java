public class LightDevice extends Device {

    @Override
    public void toggle() {
        if (isOn) {
            turnOff();
        } else {
            turnOn();
        }
    }

    @Override
    public void turnOn() {
        if (isOn) {
            System.out.println("Light is already On");
            return;
        }
        System.out.println("Light turned On");
        isOn = true;
    }

    @Override
    public void turnOff() {
        if (!isOn) {
            System.out.println("Light is already Off");
            return;
        }
        System.out.println("Light turned Off");
        isOn = false;
    }

}
