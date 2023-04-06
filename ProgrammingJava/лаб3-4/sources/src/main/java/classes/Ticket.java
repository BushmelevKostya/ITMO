package main.java.classes;

public class Ticket extends Item{
    private final int numberCarriage;
    private final Train train;
    private final MoonMen human;

    public Ticket(String name, int numberCarriage, Train train, MoonMen human){
        this.numberCarriage = numberCarriage;
        this.train = train;
        this.human = human;
        this.name = name;
        this.amount = 1;
    }

    public int getNumberCarriage() {
        return numberCarriage;
    }

    public Train getTrain() {
        return train;
    }

    public MoonMen getHuman() {
        return human;
    }
}
