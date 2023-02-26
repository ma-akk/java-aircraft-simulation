package school21.project.avaj_launcher;

import school21.project.avaj_launcher.interfaces.Flyable;

import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Tower {
    private final CopyOnWriteArrayList<Flyable> observers = new CopyOnWriteArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for(Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }

}
