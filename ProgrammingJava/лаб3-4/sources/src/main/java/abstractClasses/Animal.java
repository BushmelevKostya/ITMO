package main.java.abstractClasses;

import main.java.classes.MoonMen;

public abstract class Animal {
    protected String name;
    protected Site homeSite;

    public abstract void defend(MoonMen agressor);
}
