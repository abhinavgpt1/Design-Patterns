import java.util.ArrayList;
import java.util.List;

class WeatherStationSubject implements ISubject {
    private List<IObserver> observers = new ArrayList<>();
    private String weatherUpdate;

    @Override
    public void subscribe(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer: observers) {
            observer.update(weatherUpdate);
        }
    }

    public void setWeather(String weatherUpdate) {
        this.weatherUpdate = weatherUpdate;
        notifyObservers();
    }
}