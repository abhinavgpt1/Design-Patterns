public class Main {
    public static void main(String[] args) {
        // Just like Command pattern, here we handle commands, but the entity doing it
        // is the mediator and not the commands.
        // The code is simpler and easier to manage 
        // - just register lights with mediator and execute commands on mediator.
        // - No need to manage each light individually

        Light light1 = new Light("Living Room");
        Light light2 = new Light("Kitchen");

        Mediator mediator = new Mediator();
        mediator.registerLight(light1);
        mediator.registerLight(light2);

        TurnOnAllLightsCommand turnOnAllLightsCommand = new TurnOnAllLightsCommand(mediator);
        turnOnAllLightsCommand.execute();
        System.out.println();

        TurnOffAllLightsCommand turnOffAllLightsCommand = new TurnOffAllLightsCommand(mediator);
        turnOffAllLightsCommand.execute();

        // There shouldn't be a need of Commands anymore in Client. 
        // Instead, mediator should be encapsulating these commands.
        // Ideally, it should be the real-world objects notifying mediator to handle a
        // task by itself based on event (enum).

        // This would be a good example of Mediator if there was a collection of
        // Commands centralised in one place.
        // eg. A switch can have 2 commands (On/Off) which can be internally stored, the
        // client / Main would look like Switch.executeOnCommand(), Switch.executeOffCommand().
        // Now the downside of this can be what if there's a new command? 
        // You can add it into the Switch class, np, but the class file will become big. 
        // Also, the command isn't shareable if it's composed inside a Switch. 
        // What if Alexa/MCB is the one turning on light? Hence we need a mediator.

        // PTR: Commands shouldn't refer mediator. It should be the opposite way.
        // Mediator mediates and doesn't execute. It's the job of command to do it.
    }
}

/**
 * Output:
 * -------
 * Living Room light turned On
 * Kitchen light turned On
 * 
 * Living Room light turned Off
 * Kitchen light turned Off
 */