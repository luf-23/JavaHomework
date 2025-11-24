package DesiginPatternHomework.Observer.test;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData(30.0f, 40.0f, 80.0f);
        CurrentWeather currentWeather = CurrentWeather.getInstance();
        TemperatureHistory temperatureHistory = TemperatureHistory.getInstance();
        weatherData.registerObserver(currentWeather);
        weatherData.registerObserver(temperatureHistory);
        weatherData.setTemperature(25.0f);
        System.out.println(temperatureHistory);
        weatherData.setTemperature(35.0f);
        System.out.println(temperatureHistory);
        weatherData.removeObserver(temperatureHistory);
        weatherData.setTemperature(45.0f);
        System.out.println(temperatureHistory);
        System.out.println(currentWeather);
    }
}
