package main.java.classes;

import main.java.abstractClasses.Humanoid;
import main.java.abstractClasses.Site;
import main.java.enumerations.State;
import main.java.exceptions.NotExistSiteException;

import java.util.ArrayList;
import java.util.function.Consumer;

public class GroupOfMoonMen extends Humanoid{
    private ArrayList<MoonMen> moonMens;

    public GroupOfMoonMen(String profession, Site site) {
        this.profession = profession;
        this.site = site;
        this.states = new ArrayList<State>();
        this.moonMens = new ArrayList<MoonMen>();
        System.out.println();
        System.out.printf("Новый объект classes.MoonMen %s успешно создан!", this.profession);
    }

    public void read(Item item) {
        System.out.println();
        System.out.printf("%s читает предмет: %s", this.profession, item.getName());
    }

    public Item write(String name, int amount) {
        System.out.println();
        System.out.printf("%s пишет объект %s", this.profession, name);
        return new Item(name, amount);
    }

    public void walk(TownLocations town, String time) {
        System.out.println();
        System.out.printf("%s болтается в месте: %s до времени: %s", this.profession, town.getName(), time);
    }

    public void search(TownLocations town) {
        System.out.println();
        System.out.printf("%s ищет место: %s", this.profession, town.getName());
    }

    public void sleep() {
        System.out.println();
        System.out.printf("%s устал и спит", this.profession);
    }

    public void moveOutOfPlace(TownLocations town) {
        System.out.println();
        System.out.printf("%s покидает место: %s", this.profession, town.getName());
    }

    public void moveToPlace(TownLocations town){
        if(!TownLocations.places.contains(town.getName())){
            throw new NotExistSiteException("Такого места не существует!", town);
        }
        else{
            this.site = town;
        }
        System.out.println();
        System.out.printf("%s приходит в место: %s", this.profession, town.getName());
    }
    public void open(TownLocations location) {
        location.setOpened(true);
        System.out.printf("%s вышибли дверь!", this.profession);
        System.out.println();
    }

    public void destroy(Item item){
        System.out.printf("%s уничтожили %s!", this.profession, item.getName());
        System.out.println();
    }
}
