package school21.project.avaj_launcher;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}
