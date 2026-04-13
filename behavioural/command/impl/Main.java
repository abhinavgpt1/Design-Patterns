import java.util.List;

public class Main {
    public static void main(String[] args) {
        Light light1 = new Light(); // Receiver
        Command onCommand = new OnCommand(light1); // Command
        
        Switch mySwitch = new Switch(); // Invoker
        mySwitch.storeAndExecute(onCommand); // Execute command to turn ON the light1

        System.out.println("---------------");
        
        Light light2 = new Light(); // Receiver
        Command toggleCommand = new ToggleCommand(light2); // Command
        mySwitch.storeAndExecute(toggleCommand); // Execute command to toggle the light
        mySwitch.storeAndExecute(toggleCommand); // Execute command to toggle the light again
        mySwitch.storeAndExecute(toggleCommand); // Execute command to toggle the light again

        System.out.println("---------------");

        Command allLightsCommand = new AllLightsCommand(List.of(light1, light2)); // Command to turn off all lights
        mySwitch.storeAndExecute(allLightsCommand); // Execute command to turn OFF all lights
    }
}
