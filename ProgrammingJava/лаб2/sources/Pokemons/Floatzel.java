package Pokemons;

import Moves.FocusBlast;

public class Floatzel extends Buizel {
    public Floatzel(String name, int level){
        super(name, level);
        setStats(85, 105, 55, 85, 50, 115);
        var focusblast = new FocusBlast();
        addMove(focusblast);
    }
}