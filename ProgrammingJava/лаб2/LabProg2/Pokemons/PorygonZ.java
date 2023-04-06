package Pokemons;

import Moves.Swagger;


public class PorygonZ extends Porygon2 {
    public PorygonZ(String name, int level){
        super(name, level);
        setStats(85, 80, 70, 135, 75, 90);
        var swagger = new Swagger();
        addMove(swagger);
    }
}