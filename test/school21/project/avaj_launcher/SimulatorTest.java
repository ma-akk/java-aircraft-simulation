package school21.project.avaj_launcher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulatorTest {

    String filename = "test/resources/test10.txt";

    Simulator simulator = new Simulator(filename);

    @Test
    void simulateTest() {
        simulator.simulate();
    }
}