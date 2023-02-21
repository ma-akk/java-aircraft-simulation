package school21.project.avaj_launcher;

import org.junit.jupiter.api.Test;
import school21.project.avaj_launcher.aircrafts.AircraftFactory;
import school21.project.avaj_launcher.interfaces.Flyable;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class SimulatorTest {

    String filename = "test/resources/scenario_25.txt";

    WeatherTower weatherTower = new WeatherTower();

    Flyable jp = AircraftFactory.newAircraft("JetPlane", "JPTest", 21, 42, 50);

    Flyable jpCopy = AircraftFactory.newAircraft("JetPlane", "JPTest", 21, 42, 50);


    Simulator simulator = new Simulator(filename);

    @Test
    void simulateTest() throws Exception {
        jp.registerTower(weatherTower);
        jp.updateConditions();
        jp.updateConditions();

        jpCopy.registerTower(weatherTower);
        jpCopy.updateConditions();
        jpCopy.updateConditions();

        BufferedReader reader = new BufferedReader(new FileReader("simulation.txt"));
        reader.readLine();
        String strFstUpload = reader.readLine();
        String strSecUpload = reader.readLine();
        reader.readLine();
        String strFstUploadCopy = reader.readLine();
        String strSecUploadCopy = reader.readLine();
        reader.close();
        System.out.println(strFstUpload);
        System.out.println(strFstUploadCopy);
        System.out.println(strSecUpload);
        System.out.println(strSecUploadCopy);
//
//        assertNotEquals(strFstUpload, strFstUploadCopy);
//        assertNotEquals(strSecUpload, strSecUploadCopy);


    }
}