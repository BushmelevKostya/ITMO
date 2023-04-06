package main.java.abstractClasses;

import main.java.classes.Item;

import java.util.ArrayList;

public abstract class Furniture extends Item {
    protected Site location;
    protected ArrayList<Item> items;

    public Item getItem(Item item){
        if (items.contains(item)){
            return item;
        }
        else {
            System.out.println("Такого предмета не существует!");
            return null;
        }
    }
}
