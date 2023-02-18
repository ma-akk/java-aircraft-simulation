package school21.project.avaj_launcher;

import school21.project.avaj_launcher.aircrafts.AircraftFactory;
import school21.project.avaj_launcher.simulationExceptions.AircraftTypeNotFoundException;
import school21.project.avaj_launcher.simulationExceptions.IncorrectCountArgsException;

public class SimulationApp {
    public static void main(String[] args) throws Exception {
//        if (args.length == 1) {
//
//
//
//        } else {
//            throw new IncorrectCountArgsException("Incorrect count of arguments!");
//        }
        enum type {

            BALOON,
            HELICOPTER,
            JETPLANE,
        }
        String test = "baloon";

        try {
        type w = type.valueOf(test.toUpperCase());
        System.out.printf("done: " + w);
        } catch (Exception ignored) {}
            throw new AircraftTypeNotFoundException("aircraft type: " + test + " not found");
        }
}
