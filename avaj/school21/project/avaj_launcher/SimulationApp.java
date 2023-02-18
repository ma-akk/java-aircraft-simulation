package school21.project.avaj_launcher;

import school21.project.avaj_launcher.SimulationExceptions.IncorrectCountArgsException;

public class SimulationApp {
    public static void main(String[] args) throws IncorrectCountArgsException {
//        if (args.length == 1) {
//
//
//
//        } else {
//            throw new IncorrectCountArgsException("Incorrect count of arguments!");
//        }
        String test = "fsdfds fd    df                     fdf dsd s";
        String[] arr = test.split("\\s+");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
    }
}
