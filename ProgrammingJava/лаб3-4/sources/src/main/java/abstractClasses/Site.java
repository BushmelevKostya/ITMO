package main.java.abstractClasses;


import main.java.classes.Item;
import main.java.classes.MoonMen;

import java.util.ArrayList;

public abstract class Site {
    protected String name;
    public static ArrayList<String> places = new ArrayList<String>();
    protected ArrayList<Item> items = new ArrayList<Item>();
    public abstract String getName();
    public abstract void hide(MoonMen moonMen);
    public abstract boolean equals(Object object);
    public abstract int hashCode();
    public abstract String toString();
}