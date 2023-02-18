package school21.project.avaj_launcher.weather;

import school21.project.avaj_launcher.aircrafts.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionsChanged();

    }
}
