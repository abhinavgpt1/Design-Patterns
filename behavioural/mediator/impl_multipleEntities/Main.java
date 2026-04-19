public class Main {
    public static void main(String[] args) {
        // Setup code: can be part of HomeMediator
        HomeMediator homeMediator = new HomeMediator();

        LightDevice light = new LightDevice();
        homeMediator.register(Action.LIGHT_ON, new TurnOnLightCommand(light));
        homeMediator.register(Action.LIGHT_OFF, new TurnOffLightCommand(light));

        FanDevice fan = new FanDevice();
        homeMediator.register(Action.FAN_ON, new TurnOnFanCommand(fan));
        homeMediator.register(Action.FAN_OFF, new TurnOffFanCommand(fan));

        // Client code
        Switch allPurposeSwitch = new Switch(homeMediator);
        allPurposeSwitch.press(Action.FAN_ON);
        allPurposeSwitch.press(Action.FAN_OFF);
        allPurposeSwitch.press(Action.LIGHT_ON);
        allPurposeSwitch.press(Action.LIGHT_OFF);

        // PTR: For real-world similarity where there's different switch for fan and
        // light, you need to make Switches command centric, or you can simply store
        // Device in Switch, but that would be anti-pattern since Entities of Mediator
        // don't know about each other, and main purpose of Mediator is to decouple.

        // Scalablity: Since switch can be singular, therefore problems like:
        // 1. Multiple devices like Ac, Speaker
        // 2. Same device multiple times like lightKitchen, lightLivingRoom
        // you need to create new set of commands and actions
    }
}
/**
 * Output:
 * -------
 * Fan turned On
 * Fan turned Off
 * Light turned On
 * Light turned Off
 */