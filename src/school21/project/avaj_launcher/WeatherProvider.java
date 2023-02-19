package school21.project.avaj_launcher;

import school21.project.avaj_launcher.aircrafts.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;

    private static String[] weather;

    private WeatherProvider() {
        weather = new String[4];
        weather[0] = "RAIN";
        weather[1] = "FOG";
        weather[2] = "SUN";
        weather[3] = "SNOW";
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int randomNum = coordinates.getHeight() +
                coordinates.getLatitude() * 3 +
                coordinates.getLongitude() * 5;
        return weather[randomNum % 4];
    }
}
