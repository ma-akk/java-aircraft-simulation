package school21.project.avaj_launcher.interfaces;

import school21.project.avaj_launcher.WeatherTower;

public interface Flyable {
    void updateConditions();

    void registerTower(WeatherTower weatherTower);
}
