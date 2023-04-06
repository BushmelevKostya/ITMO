package main.java.classes;

import main.java.abstractClasses.Humanoid;
import main.java.abstractClasses.Site;
import main.java.enumerations.State;

import java.util.ArrayList;

public class TownLocations extends Site {
    private boolean isOpened;
    public TownLocations(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
        places.add(name);
        System.out.println();
        System.out.printf("Новый объект %s успешно создан!", this.name);
    }

    public void hide(MoonMen moonMen) {
        moonMen.addState(State.ESCAPED);
        moonMen.removeState(State.PURSUER);
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public String getName() {
        return this.name;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
        if (opened){
            System.out.println("Дверь теперь открыта");
        }
        else {
            System.out.println("Дверь теперь заперта");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != getClass()) {
            return false;
        }
        var town = (TownLocations) object;
        return (this.name != town.name);
    }

    @Override
    public String toString() {
        return "В городе есть " + this.name;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + name.hashCode();
        return result;
    }
}