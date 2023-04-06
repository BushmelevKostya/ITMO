package Pokemons;

import Moves.DefenseCurl;

public class Porygon2 extends Porygon {
    public Porygon2(String name, int level){
        super(name, level);
        setStats(85, 80, 90, 105, 95, 60);
        var defensecurl = new DefenseCurl();
        addMove(defensecurl);
    }
}