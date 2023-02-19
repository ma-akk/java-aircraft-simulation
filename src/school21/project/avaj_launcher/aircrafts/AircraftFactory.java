package school21.project.avaj_launcher.aircrafts;

import school21.project.avaj_launcher.interfaces.Flyable;
import school21.project.avaj_launcher.simulationExceptions.AircraftTypeNotFoundException;

public abstract class AircraftFactory {
    private enum typeAircraft {

        BALOON,
        HELICOPTER,
        JETPLANE,
    }
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws AircraftTypeNotFoundException {

        typeAircraft test;
        try {
            test = typeAircraft.valueOf(type.toUpperCase());
            switch (test) {
                case BALOON:
                    return new Baloon(name, new Coordinates(longitude, latitude, height));
                case HELICOPTER:
                    return new Helicopter(name, new Coordinates(longitude, latitude, height));
                case JETPLANE:
                    return new JetPlane(name, new Coordinates(longitude, latitude, height));
            }
        } catch (Exception ignored) {}
        throw new AircraftTypeNotFoundException("aircraft type: " + type + " not found");
    }
}
