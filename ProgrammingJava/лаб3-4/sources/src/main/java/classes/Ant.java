package main.java.classes;

import main.java.abstractClasses.Animal;
import main.java.abstractClasses.Site;
import main.java.enumerations.State;

public class Ant extends Animal {
    private boolean isAngry;
    private boolean isHomeSiteBroken;

    public Ant(String name, Site homeSite){
        this.name = name;
        this.homeSite = homeSite;
        this.isHomeSiteBroken = false;
        this.isAngry = false;
    }

    public void defend(MoonMen agressor){
        this.isAngry = true;
        bite(agressor);
    }
    public void build(){
        if (!isHomeSiteBroken){
            System.out.println("Муравейник становится все выше!");
        }
        else {
            isHomeSiteBroken = false;
        }
    }
    public void bite(MoonMen agressor){
        agressor.addState(State.INJURED);
    }
}
