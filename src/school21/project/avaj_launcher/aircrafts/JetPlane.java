package school21.project.avaj_launcher.aircrafts;

import school21.project.avaj_launcher.interfaces.Flyable;
import school21.project.avaj_launcher.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}