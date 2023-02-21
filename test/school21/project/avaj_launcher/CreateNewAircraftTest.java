package school21.project.avaj_launcher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school21.project.avaj_launcher.aircrafts.AircraftFactory;
import school21.project.avaj_launcher.aircrafts.Baloon;
import school21.project.avaj_launcher.aircrafts.Helicopter;
import school21.project.avaj_launcher.aircrafts.JetPlane;
import school21.project.avaj_launcher.interfaces.Flyable;

import static org.junit.jupiter.api.Assertions.*;

class CreateNewAircraftTest {

    String correctInputStringHelicopter = "Helicopter H1 6 90 24";

    String correctInputStringBaloon = "Baloon B1 100 10 24";

    String correctInputStringJP = "JetPlane JP1 16 30 84";

    String incorrectInputString = "SuperJet SJ1 6 90 24";

    @Test
    @DisplayName("Создание летательного объекта")
    void testNewHelicopterSuccess() {
        String[] correctArr = correctInputStringHelicopter.split("\\s+");
        Flyable aircraft = AircraftFactory.newAircraft(correctArr[0],correctArr[1],
                Integer.parseInt(correctArr[2]),
                Integer.parseInt(correctArr[3]),
                Integer.parseInt(correctArr[4]));
        assertTrue(aircraft instanceof Helicopter);
    }

    @Test
    @DisplayName("Создание летательного объекта")
    void testNewBaloonSuccess() {
        String[] correctArr = correctInputStringBaloon.split("\\s+");
        Flyable aircraft = AircraftFactory.newAircraft(correctArr[0],correctArr[1],
                Integer.parseInt(correctArr[2]),
                Integer.parseInt(correctArr[3]),
                Integer.parseInt(correctArr[4]));
        assertTrue(aircraft instanceof Baloon);
    }

    @Test
    @DisplayName("Создание летательного объекта")
    void testNewJetPlaneSuccess() {
        String[] correctArr = correctInputStringJP.split("\\s+");
        Flyable aircraft = AircraftFactory.newAircraft(correctArr[0],correctArr[1],
                Integer.parseInt(correctArr[2]),
                Integer.parseInt(correctArr[3]),
                Integer.parseInt(correctArr[4]));
        assertTrue(aircraft instanceof JetPlane);
    }

    @Test
    @DisplayName("Несуществующий тип летательного объекта")
    void testNewAircraftFail() {
        String[] incorrectArr = incorrectInputString.split("\\s+");
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            AircraftFactory.newAircraft(incorrectArr[0],incorrectArr[1],
                    Integer.parseInt(incorrectArr[2]),
                    Integer.parseInt(incorrectArr[3]),
                    Integer.parseInt(incorrectArr[4]));
        });

    }
}