package main.java.classes;

import main.java.interfaces.Lockable;
import main.java.abstractClasses.Site;
import main.java.abstractClasses.Furniture;

import java.util.ArrayList;

public class Chest extends Furniture implements Lockable {
    Lock lock = new Lock("Замок", 1);
    private boolean isOpened;

    public Chest(String name, int amount, Site location) {
        this.location = location;
        this.name = name;
        this.amount = amount;
        try {
            this.price = Item.priceMap.get(name);
        } catch (Exception e) {
            System.out.println("Такого предмета не существует!");
        }
        this.isOpened = false;
        this.items = new ArrayList<Item>();
    }

    public void putItem(Item item) {
        this.items.add(item);
    }

    public void open(int code) {
        System.out.println("У этого предмета нет кода!");
    }

    public void open(Item item){
        if (item.getName() == "Ключ"){
            this.isOpened = true;
        }
        else {
            System.out.println("У вас нет ключа!");
        }
    }
    public void crash(){
        this.isOpened = true;
        lock.crash();
    }
}
