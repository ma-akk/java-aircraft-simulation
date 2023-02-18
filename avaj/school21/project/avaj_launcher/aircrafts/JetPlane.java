package school21.project.avaj_launcher.aircrafts;

import school21.project.avaj_launcher.Flyable;
import school21.project.avaj_launcher.WeatherTower;
import school21.project.avaj_launcher.aircrafts.Aircraft;
import school21.project.avaj_launcher.aircrafts.Coordinates;

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
