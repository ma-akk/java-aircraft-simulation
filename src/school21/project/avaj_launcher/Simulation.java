package school21.project.avaj_launcher;

import school21.project.avaj_launcher.aircrafts.Aircraft;
import school21.project.avaj_launcher.aircrafts.AircraftFactory;
import school21.project.avaj_launcher.simulationExceptions.IncorrectCountArgsException;
import school21.project.avaj_launcher.weather.WeatherProvider;
import school21.project.avaj_launcher.weather.WeatherTower;

import java.util.ArrayList;

public class Simulation {

    private WeatherTower weatherTower;

    private ArrayList<Aircraft> aircraftList;

    public static void main(String[] args) throws IncorrectCountArgsException {
        if (args.length == 1) {


        } else {
            throw new IncorrectCountArgsException("Incorrect count of arguments!");
        }
    }


//    public void test(ArrayList<Aircraft> list) {
//        this.aircraftList = new ArrayList<>();
//        aircraftList.addAll(list);

}
