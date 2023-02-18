package school21.project.avaj_launcher.aircrafts;

public abstract class Aircraft {
    protected long id;

    protected String name;

    protected Coordinates coordinates;

    //NOT uml method
    public Coordinates getCoordinates() {
        return coordinates;
    }

    private static long idCounter = 0;

    public Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        return ++idCounter;
    }
}
