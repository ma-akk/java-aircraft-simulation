package school21.project.avaj_launcher.aircrafts;

import school21.project.avaj_launcher.interfaces.Flyable;
import school21.project.avaj_launcher.WeatherTower;
import school21.project.avaj_launcher.simulationExceptions.WeatherTypeNotFoundException;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        String uniqueMsg = "";
        StringBuilder builder = new StringBuilder();
        builder.append("JetPlane#").append(this.name).append("(").append(this.id).append("): ");
        switch (weather) {
            case ("SUN"):
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude() + 10,
                        coordinates.getHeight() + 2);
                uniqueMsg = builder.append("...and fly off in sunset").toString();
                break;
            case ("RAIN"):
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude() + 5,
                        coordinates.getHeight());
                uniqueMsg = builder.append("It's raining. Better watch out for lightings").toString();
                break;
            case ("SNOW"):
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 7);
                uniqueMsg = builder.append("OMG! Winter is coming").toString();
                break;
            case ("FOG"):
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude() + 1,
                        coordinates.getHeight());
                uniqueMsg = builder.append("Is it clouds?").toString();
                break;
            default:
                throw new WeatherTypeNotFoundException("Unexpected weather: " + weather);
        }

        if (this.coordinates.getHeight() < 1) {
            weatherTower.unregister(this);
            uniqueMsg = "Tower says: JetPlane#" +
                    this.name + "(" + this.id + ") unregistered from weather tower.";
        }
        weatherTower.writeLogMsg(uniqueMsg);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        weatherTower.writeLogMsg("Tower says: JetPlane#" +
                this.name + "(" + this.id + ") registered to weather tower.");
    }
}
