package DesiginPatternHomework.Observer.test;

public class CurrentWeather implements Observrer{

    private static volatile CurrentWeather instance;
    private static final Object lockObject = new Object();

    private float temperature;
    private float humidity;
    private float pressure;

    private CurrentWeather(){}

    public static CurrentWeather getInstance(){
        if (instance==null){
            synchronized (lockObject){
                if (instance==null){
                    instance = new CurrentWeather();
                }
            }
        }
        return instance;
    }

    @Override
    public void update(WeatherData weatherData) {
        temperature = weatherData.getTemperature();
        humidity = weatherData.getHumidity();
        pressure = weatherData.getPressure();
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }
}
