package DesiginPatternHomework.Observer.test;

import java.util.ArrayList;
import java.util.List;

public class TemperatureHistory implements Observrer{

    private static volatile TemperatureHistory instance;
    private static final Object lockObject = new Object();

    private TemperatureHistory(){}

    public static TemperatureHistory getInstance(){
        if (instance==null){
            synchronized (lockObject){
                if (instance==null){
                    instance = new TemperatureHistory();
                }
            }
        }
        return instance;
    }

    private List<Float> tempHistory = new ArrayList<>();
    @Override
    public void update(WeatherData weatherData) {
        tempHistory.add(weatherData.getTemperature());
    }

    @Override
    public String toString() {
        return "TemperatureHistory{" +
                "tempHistory=" + tempHistory +
                '}';
    }
}
