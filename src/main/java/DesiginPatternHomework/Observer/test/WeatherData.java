package DesiginPatternHomework.Observer.test;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
    private float temperature;
    private float humidity;
    private float pressure;
    private List<Observrer> observers;

    public WeatherData(float temperature, float humidity, float pressure){
        observers = new ArrayList<>();
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    @Override
    public void registerObserver(Observrer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observrer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observrer observer : observers){
            observer.update(this);
        }
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
        notifyObservers();
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
        notifyObservers();
    }

}
