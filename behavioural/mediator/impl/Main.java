public class Main {
    public static void main(String[] args) {
        // just like Command pattern, here we handle commands, but the entity doing it is the mediator and not the command
        // the code is simpler and easier to manage - just register lights with mediator and execute commands on mediator. No need to manage each light individually

        Light light1 = new Light("Living Room");
        Light light2 = new Light("Kitchen");

        Mediator mediator = new Mediator();
        mediator.registerLight(light1);
        mediator.registerLight(light2);

        TurnOnAllLightsCommand turnOnAllLightsCommand = new TurnOnAllLightsCommand(mediator);
        turnOnAllLightsCommand.execute();
        
        TurnOffAllLightsCommand turnOffAllLightsCommand = new TurnOffAllLightsCommand(mediator);
        turnOffAllLightsCommand.execute();
    }
}

/**
 * Output:
 * -------
 * Living Room light is ON
 * Kitchen light is ON
 * Living Room light is OFF
 * Kitchen light is OFF
 */