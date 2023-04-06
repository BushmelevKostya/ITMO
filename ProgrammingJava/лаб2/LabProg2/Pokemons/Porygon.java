package Pokemons;

import Moves.Blizzard;
import Moves.IceBeam;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Porygon extends Pokemon {
    public Porygon(String name, int level){
        super(name, level);
        setStats(65, 60, 70, 85, 75, 40);
        setType(Type.NORMAL);
        var icebeam = new IceBeam();
        var blizzard = new Blizzard();
        setMove(icebeam, blizzard);
    }
}