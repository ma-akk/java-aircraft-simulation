package school21.project.avaj_launcher.aircrafts;

import school21.project.avaj_launcher.interfaces.Flyable;
import school21.project.avaj_launcher.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        writeLogMsg(weatherTower.getWeather(coordinates));
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    //NOT uml method
    private void writeLogMsg(String weather) {
        System.out.print("BALOON#" + this.name + "(" + this.id + "): ");
        switch (weather) {
            case ("SUN") -> System.out.println("It's sunny");
            case ("RAIN") -> System.out.println("It's rainy");
            case ("SNOW") -> System.out.println("It's snowy");
            case ("FOG") -> System.out.println("It's foggy");
        }
    }
}
