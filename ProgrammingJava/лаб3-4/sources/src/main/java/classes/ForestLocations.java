package main.java.classes;

import main.java.abstractClasses.Site;
import main.java.enumerations.State;

import java.util.ArrayList;

public class ForestLocations extends Site {
    private boolean isFruitFul;
    public ForestLocations(String name, boolean isFruitFul) {
        this.name = name;
        this.isFruitFul = isFruitFul;
        places.add(name);
        this.items = new ArrayList<Item>();
        System.out.println();
        System.out.printf("Новый объект Place %s успешно создан!", this.name);
    }

    public ForestFood searchFood(ForestFood food){
        if (Math.random() < 0.1){
            return food;
        }
        return new ForestFood("трава", false);
    }
    public String getName(){
        return this.name;
    }

    public void hide(MoonMen moonMen) {
        moonMen.addState(State.ESCAPED);
        moonMen.removeState(State.PURSUER);
    }

    public static class ForestFood{
        private final String name;
        private boolean isEdibility;
        static ArrayList<String> food;

        public ForestFood(String name, boolean isEdibility){
            this.name = name;
            this.isEdibility = isEdibility;
            food.add(name);
        }

        public String getName() {
            return name;
        }

        public void setEdibility(boolean isEdibility) {
            this.isEdibility = isEdibility;
        }

        public void cook(){
            setEdibility(true);
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
        var forestLocation = (ForestLocations) object;
        return (this.name != forestLocation.name);
    }

    @Override
    public String toString() {
        return "В лесу есть " + this.name;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + name.hashCode();
        return result;
    }
}
