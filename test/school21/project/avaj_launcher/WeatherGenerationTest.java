package school21.project.avaj_launcher;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school21.project.avaj_launcher.aircrafts.AircraftFactory;
import school21.project.avaj_launcher.interfaces.Flyable;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class WeatherGenerationTest {

    WeatherTower weatherTower = new WeatherTower();

    Flyable jp = AircraftFactory.newAircraft("JetPlane", "JPTest", 21, 42, 50);

    Flyable jpCopy = AircraftFactory.newAircraft("JetPlane", "JPTest", 21, 42, 50);

    public void clearFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("simulation.txt"));
            writer.write("");
            writer.close();
        } catch (Exception ignore) {}
    }

    @Test
    @DisplayName("При одних и тех же координатах, генерируется разная погода => " +
            "выводятся разные сообщения")
    void generateWeatherTest() throws Exception {
        clearFile();
        jp.registerTower(weatherTower);
        jp.updateConditions();
        jp.updateConditions();
        jp.updateConditions();

        jpCopy.registerTower(weatherTower);
        jpCopy.updateConditions();
        jpCopy.updateConditions();
        jpCopy.updateConditions();

        BufferedReader reader = new BufferedReader(new FileReader("simulation.txt"));
        reader.readLine();
        String strFstUpload = reader.readLine();
        String strSecUpload = reader.readLine();
        String strThrUpload = reader.readLine();
        reader.readLine();
        String strFstUploadCopy = reader.readLine();
        String strSecUploadCopy = reader.readLine();
        String strThrUploadCopy = reader.readLine();
        reader.close();
        boolean compareRandom = strFstUpload.equals(strFstUploadCopy) &&
                strSecUpload.equals(strSecUploadCopy) &&
                strThrUpload.equals(strThrUploadCopy);
        assertFalse(compareRandom);
    }
}