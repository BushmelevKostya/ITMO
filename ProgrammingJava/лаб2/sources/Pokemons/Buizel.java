package Pokemons;

import Moves.AquaTail;
import Moves.Facade;
import Moves.Growl;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Buizel extends Pokemon{
    public Buizel(String name, int ...level){
        super(name, level[0]);
        setStats(55, 65, 35, 60, 30, 85);
        setType(Type.WATER);
        var aquatail = new AquaTail();
        var facade = new Facade();
        var growl = new Growl();
        setMove(aquatail, facade, growl);
    }
}
