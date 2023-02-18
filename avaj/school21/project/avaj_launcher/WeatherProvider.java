package school21.project.avaj_launcher;

import school21.project.avaj_launcher.aircrafts.Coordinates;

public class WeatherProvider {
    //what means relation with itself?
    private static WeatherProvider weatherProvider;

    private static String[] weather;

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return null;
    }

}
