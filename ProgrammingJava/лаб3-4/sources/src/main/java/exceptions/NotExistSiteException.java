package main.java.exceptions;

import main.java.classes.TownLocations;

public class NotExistSiteException extends RuntimeException{
    private TownLocations townLocation;

    public NotExistSiteException(String message, TownLocations townLocation) {
        super(message);
        this.townLocation = townLocation;
    }
}