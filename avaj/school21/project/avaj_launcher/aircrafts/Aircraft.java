package school21.project.avaj_launcher.aircrafts;

public abstract class Aircraft {
    protected long id;

    protected String name;

    protected Coordinates coordinates;

    private static long idCounter;

    public Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        return ++idCounter;
    }
}
