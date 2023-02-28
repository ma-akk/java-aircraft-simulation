package school21.project.avaj_launcher;

import org.junit.jupiter.api.Test;
import school21.project.avaj_launcher.aircrafts.AircraftFactory;
import school21.project.avaj_launcher.interfaces.Flyable;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class RangeOfHeightTest {

    WeatherTower weatherTower = new WeatherTower();

    Flyable b1 = AircraftFactory.newAircraft("Baloon", "BTest", 21, 42, 1);

    public void clearFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("simulation.txt"));
            writer.write("");
            writer.close();
        } catch (Exception ignore) {}
    }

    @Test
    void updateConditions() throws IOException {
        clearFile();
        b1.registerTower(weatherTower);
        b1.updateConditions();
        b1.updateConditions();
        b1.updateConditions();

        BufferedReader reader = new BufferedReader(new FileReader("simulation.txt"));
        String line = reader.readLine();
        while (line != null && !line.equals("Tower says: Baloon#BTest(1) unregistered from weather tower.")) {
            line = reader.readLine();
        }
        assertEquals(line, "Tower says: Baloon#BTest(1) unregistered from weather tower.");
    }
}