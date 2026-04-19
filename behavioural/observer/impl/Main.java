// ref: https://www.geeksforgeeks.org/system-design/observer-pattern-set-1-introduction/
public class Main {
    public static void main(String[] args) {
        WeatherStationSubject weatherStation = new WeatherStationSubject();

        IObserver phoneObserver = new PhoneObserver();
        IObserver tvObserver = new TVObserver();

        // Register observers
        weatherStation.subscribe(phoneObserver);
        weatherStation.subscribe(tvObserver);

        // Simulating weather broadcast
        weatherStation.setWeather("Delhi has a sunny weather");
        System.out.println();
        weatherStation.setWeather("Banglaore has a cloudy weather");
        System.out.println();

        // Remove one observer
        weatherStation.unsubscribe(tvObserver);

        // Notify remaining observer
        System.out.println("---------After removing one observer---------");
        weatherStation.setWeather("It's windy in Mumbai");

        /**
         * Check Bryan Hansen's impl. of Observer (in .zip), 
         * and I feel these are some problems / anti-pattern:
         * 1. Observer shouldn't know anything about the subject they observe.
         * 2. For update you're using subject's state.
         * 3. Observer is modifying subject.
         * 4. Observer is getting initialised with subject as param seems like
         * hardwiring and tight-coupling.
         * - although it's an interface ref we're passing but still direct reference are
         * stored which seems like an anti-pattern.
         * 
         * His approach to problem that observer shouldn't be sitting still and be
         * bombarded with all types of notifications feels right, but we can leverage
         * topics / message type for observers using Map in Subject.
         * 
         * Giving observer freedom to subscribe/unsubscribe can be handled by user input
         * inside Client code / UI.
         * About type of notification, observer can subscribe to personlised notifications.
         */
    }
}

/**
 * Output:
 * -------
 * Phone notification: Delhi has a sunny weather
 * TV displays: Delhi has a sunny weather
 * 
 * Phone notification: Banglaore has a cloudy weather
 * TV displays: Banglaore has a cloudy weather
 * 
 * ---------After removing one observer---------
 * Phone notification: It's windy in Mumbai
 */