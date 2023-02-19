package school21.project.avaj_launcher;

import school21.project.avaj_launcher.aircrafts.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionsChanged();
    }

    //NOT uml method
    public void writeLogMsg(String uniqueMsg) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("filename"));
//            writer.write(uniqueMsg);
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println(uniqueMsg);
    }
}
