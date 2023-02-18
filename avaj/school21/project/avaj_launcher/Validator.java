package school21.project.avaj_launcher;

import school21.project.avaj_launcher.SimulationExceptions.InvalidScenarioFileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Validator {

    private static Validator instance;

    private Validator() {}

    public static Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    private static Integer numberOfSimulations = 0;

    private static ArrayList<String[]> aircraftsString;

    public static Integer getNumberOfSimulations() {
        return numberOfSimulations;
    }

    public static ArrayList<String[]> getAircraftsString() {
        return aircraftsString;
    }

    public boolean validateFile(String fileName) throws InvalidScenarioFileException {
        //файл существует
        //.txt
        //читаем построчно, первая строка - положительное число
        //вторая и далее соответствует формату
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            numberOfSimulations = Integer.parseInt(line);
            if (numberOfSimulations < 1) {
                throw new InvalidScenarioFileException("The number of times the simulation must be a positive integer number!");
            }

            while ((line = reader.readLine()) != null) {
                String[] object = line.split("\\s+");
                validateLine(object);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    private boolean validateLine(String[] line) {
        if (line.length == 5) {
//            if (line[0].equals(Enum<Aircraft>))
            return Integer.parseInt(line[2]) > 0 &&
                    Integer.parseInt(line[3]) > 0 &&
                    Integer.parseInt(line[4]) > 0 && Integer.parseInt(line[3]) < 100;
        }
        return false;
    }


}
