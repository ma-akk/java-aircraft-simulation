package school21.project.avaj_launcher;

import school21.project.avaj_launcher.simulationExceptions.InvalidScenarioFileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Validator {

    private static Integer numberOfSimulations = 0;

    private static final ArrayList<String[]> aircraftsString = new ArrayList<>();

    public static Integer getNumberOfSimulations() {
        return numberOfSimulations;
    }

    public static ArrayList<String[]> getAircraftsString() {
        return aircraftsString;
    }

    public static boolean validateInputFile(String fileName) throws InvalidScenarioFileException {
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
                if (validateLine(object))
                    aircraftsString.add(object);
                else
                    return false;
            }
        } catch (Exception e) {
            throw new InvalidScenarioFileException(e.getMessage());
        }
        return true;
    }

    private static boolean validateLine(String[] line) {
        if (line.length == 5) {
            return Integer.parseInt(line[2]) > 0 &&
                    Integer.parseInt(line[3]) > 0 &&
                    Integer.parseInt(line[4]) > 0;
        }
        return false;
    }


}
