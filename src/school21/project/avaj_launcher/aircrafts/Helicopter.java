package school21.project.avaj_launcher.aircrafts;

import school21.project.avaj_launcher.interfaces.Flyable;
import school21.project.avaj_launcher.WeatherTower;
import school21.project.avaj_launcher.simulationExceptions.WeatherTypeNotFoundException;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        String uniqueMsg = "";
        StringBuilder builder = new StringBuilder();
        builder.append("HELICOPTER#").append(this.name).append("(").append(this.id).append("): ");
        switch (weather) {
            case ("SUN"):
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 10,
                        coordinates.getLatitude(),
                        coordinates.getHeight() + 2);
                uniqueMsg = builder.append("Where are my tinted glasses?").toString();
                break;
            case ("RAIN"):
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 5,
                        coordinates.getLatitude(),
                        coordinates.getHeight());
                uniqueMsg = builder.append("I'm not crying, it's only rain").toString();
                break;
            case ("SNOW"):
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 12);
                uniqueMsg = builder.append("My rotor is going to freeze!").toString();
                break;
            case ("FOG"):
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 1,
                        coordinates.getLatitude(),
                        coordinates.getHeight());
                uniqueMsg = builder.append("I see a ground! Oh, no, it seemed").toString();
                break;
            default:
                throw new WeatherTypeNotFoundException("Unexpected weather: " + weather);
        }

        if (this.coordinates.getHeight() < 1) {
            weatherTower.unregister(this);
            uniqueMsg = "Tower says: Helicopter#" +
                    this.name + "(" + this.id + ") unregistered from weather tower.";
        }
        weatherTower.writeLogMsg(uniqueMsg);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        weatherTower.writeLogMsg("Tower says: Helicopter#" +
                this.name + "(" + this.id + ") registered to weather tower.");
    }
}
