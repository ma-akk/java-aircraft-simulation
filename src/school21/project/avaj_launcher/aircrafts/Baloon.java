package school21.project.avaj_launcher.aircrafts;

import school21.project.avaj_launcher.interfaces.Flyable;
import school21.project.avaj_launcher.simulationExceptions.WeatherTypeNotFoundException;
import school21.project.avaj_launcher.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        String uniqueMsg = "";
        StringBuilder builder = new StringBuilder();
        builder.append("Ballon#").append(this.name).append("(").append(this.id).append("): ");
        switch (weather) {
            case ("SUN"):
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 2,
                        coordinates.getLatitude(),
                        coordinates.getHeight() + 4);
                uniqueMsg = builder.append("Radiant sun likes to gallop").toString();
                break;
            case ("RAIN"):
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 5);
                uniqueMsg = builder.append("Damn you rain! You messed up my baloon").toString();
                break;
            case ("SNOW"):
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 15);
                uniqueMsg = builder.append("Baloons aren't created for snow!").toString();
                break;
            case ("FOG"):
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 3);
                uniqueMsg = builder.append("Where am I?").toString();
                break;
            default:
                throw new WeatherTypeNotFoundException("Unexpected weather: " + weather);
        }

        if (this.coordinates.getHeight() < 1) {
            weatherTower.unregister(this);
            uniqueMsg = "Tower says: Baloon#" +
                    this.name + "(" + this.id + ") unregistered from weather tower.";
        }
        weatherTower.writeLogMsg(uniqueMsg);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        weatherTower.writeLogMsg("Tower says: Baloon#" +
                this.name + "(" + this.id + ") registered to weather tower.");
    }


}
