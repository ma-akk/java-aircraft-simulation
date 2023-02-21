package school21.project.avaj_launcher;

import school21.project.avaj_launcher.aircrafts.Coordinates;
import school21.project.avaj_launcher.simulationExceptions.WriteReadFileException;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionsChanged();
    }

    public void writeLogMsg(String uniqueMsg) {
        String filename = "simulation.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(uniqueMsg + "\n");
            writer.close();
        } catch (Exception e) {
            throw new WriteReadFileException(e.toString());
        }
    }
}
