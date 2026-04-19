public class FanDevice extends Device {

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
            System.out.println("Fan is already On");
            return;
        }
        System.out.println("Fan turned On");
        isOn = true;
    }

    @Override
    public void turnOff() {
        if (!isOn) {
            System.out.println("Fan is already Off");
            return;
        }
        System.out.println("Fan turned Off");
        isOn = false;
    }
    
}
