import java.util.List;

public class Main {
    public static void main(String[] args) {
        Light_Receiver light1 = new Light_Receiver("Light1");
        Command turnOnLight1 = new TurnOnLightCommand(light1);

        Switch_Invoker mySwitch = new Switch_Invoker();
        mySwitch.execute(turnOnLight1);

        System.out.println();

        Light_Receiver light2 = new Light_Receiver("Light2");
        Command toggleOnOffLight2 = new ToggleLightOnOffCommand(light2);
        mySwitch.execute(toggleOnOffLight2); // Off -> On
        mySwitch.execute(toggleOnOffLight2); // On -> Off
        mySwitch.execute(toggleOnOffLight2); // Off -> On

        System.out.println();

        Light_Receiver light3 = new Light_Receiver("Light3");
        Command toggleOnOffLight3 = new ToggleLightOnOffCommand(light3);
        mySwitch.execute(toggleOnOffLight3); // Off -> On
        mySwitch.execute(toggleOnOffLight3); // On -> Off

        System.out.println();

        // Till now, light1 = On, light2 = On, light3 = Off
        Command turnOffAllLightsCommand = new TurnOffAllLightsCommand(List.of(light1, light2, light3));
        mySwitch.execute(turnOffAllLightsCommand);
    }
}

/**
 * Output:
 * -------
 * Light1 turned On
 * 
 * Light2 turned On
 * Light2 turned Off
 * Light2 turned On
 * 
 * Light3 turned On
 * Light3 turned Off
 * 
 * Light1 turned Off
 * Light2 turned Off
 */