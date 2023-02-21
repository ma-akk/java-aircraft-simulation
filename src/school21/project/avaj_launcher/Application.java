package school21.project.avaj_launcher;

import school21.project.avaj_launcher.simulationExceptions.IncorrectCountArgsException;

public class Application {
    public static void main(String[] args) throws Exception {
        if (args.length == 1) {
            Simulator simulator = new Simulator(args[0]);
            simulator.simulate();
        } else {
            throw new IncorrectCountArgsException("Incorrect count of arguments!");
        }
    }
}
