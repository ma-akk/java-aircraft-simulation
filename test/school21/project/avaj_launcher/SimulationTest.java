package school21.project.avaj_launcher;

import org.junit.After;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    String filename = "test/resources/scenario_50.txt";

    Simulator simulator;

    @Test
    void simulateTest() throws IOException {
        Runtime.getRuntime().exec("chmod a+wr simulation.txt");
        simulator = new Simulator(filename);
        simulator.simulate();
        int strCount = 0;
        int countRegisterMsg = 0;
        BufferedReader reader = new BufferedReader(new FileReader("simulation.txt"));
        String line = reader.readLine();
        while (line != null) {
            strCount++;
            if (line.contains("Tower says:") && line.contains("registered to weather tower."))
                countRegisterMsg++;
            line = reader.readLine();
        }
        assertEquals(15, countRegisterMsg);
        assertTrue(strCount > 100);
        reader.close();
    }

    @Test
    void writeReadExceptionTest() throws IOException {
        Runtime.getRuntime().exec("chmod a-wr simulation.txt");
        assertThrows(RuntimeException.class, () -> simulator = new Simulator(filename));
    }
}