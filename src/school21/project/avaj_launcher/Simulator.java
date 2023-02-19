package school21.project.avaj_launcher;

import school21.project.avaj_launcher.aircrafts.AircraftFactory;
import school21.project.avaj_launcher.interfaces.Flyable;

import java.util.ArrayList;

public class Simulator {

    private WeatherTower weatherTower ;

    private ArrayList<Flyable> aircraftList;

    private String scenarioFileName;

    public Simulator(String scenarioFileName) {
        this.weatherTower = new WeatherTower();
        this.scenarioFileName = scenarioFileName;
        this.aircraftList = new ArrayList<>();
    }

    public void simulate() {
        try {
            if (Validator.validateInputFile(scenarioFileName)) {
                for (int i = 0; i < Validator.getAircraftsString().size(); i++) {
                    String[] aircraftStr = Validator.getAircraftsString().get(i);
                    aircraftList.add(AircraftFactory.newAircraft(
                            aircraftStr[0], aircraftStr[1],
                            Integer.parseInt(aircraftStr[2]),
                            Integer.parseInt(aircraftStr[3]),
                            Integer.parseInt(aircraftStr[4])));
                    aircraftList.get(i).registerTower(weatherTower);
                }
                int numberOfSimulations = Validator.getNumberOfSimulations();
                for (int i = 0; i < numberOfSimulations; i++) {
                    System.out.println("Simulation #" + (i + 1));
                    weatherTower.changeWeather();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
