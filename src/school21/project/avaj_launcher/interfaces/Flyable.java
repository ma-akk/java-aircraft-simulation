package school21.project.avaj_launcher.interfaces;

import school21.project.avaj_launcher.weather.WeatherTower;

public interface Flyable {
    public void updateConditions();

    //in uml WeatherTower WeatherTower
    public void registerTower(WeatherTower weatherTower);
}
