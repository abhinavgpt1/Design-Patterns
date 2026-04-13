// GFG example - https://www.geeksforgeeks.org/system-design/observer-pattern-set-1-introduction/
public class Main {
    public static void main(String[] args) {
        WeatherStation_Subject weatherStation = new WeatherStation_Subject();

        Observer phoneObserver = new Phone_Observer();
        Observer tvObserver = new Tv_Observer();

        // Register observers
        weatherStation.addObserver(phoneObserver);
        weatherStation.addObserver(tvObserver);

        // Simulating weather changes
        weatherStation.setWeather("Sunny");
        weatherStation.setWeather("Cloudy");

        // Remove one observer
        weatherStation.removeObserver(tvObserver);

        // Notify remaining observer
        weatherStation.setWeather("Windy");
    }
}

/**
 * Output:
 * -------
 * Phone Display: Weather updated - Sunny
 * TV Display: Weather updated - Sunny
 * Phone Display: Weather updated - Cloudy
 * TV Display: Weather updated - Cloudy
 * Phone Display: Weather updated - Windy
 */