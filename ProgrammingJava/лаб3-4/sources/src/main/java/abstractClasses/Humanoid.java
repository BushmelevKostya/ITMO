package main.java.abstractClasses;

import main.java.classes.Item;
import main.java.classes.TownLocations;
import main.java.enumerations.State;

import java.util.ArrayList;

public abstract class Humanoid {
    protected String profession;
    protected ArrayList<State> states;
    protected Site site;

    public abstract void walk(TownLocations townLocation, String time);
    public abstract void sleep();
    public abstract void read(Item item);
    public abstract Item write(String name, int amount);
    public abstract void search(TownLocations townLocation);
    public void addState(State state){
        this.states.add(state);
    }
    public void removeState(State state) {this.states.remove(state);}
}