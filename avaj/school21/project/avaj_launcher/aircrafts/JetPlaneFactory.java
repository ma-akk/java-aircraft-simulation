package school21.project.avaj_launcher.aircrafts;

import school21.project.avaj_launcher.Flyable;

public class JetPlaneFactory extends AircraftFactory {
    @Override
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        return new JetPlane(name, new Coordinates(longitude, latitude, height));
    }
}
