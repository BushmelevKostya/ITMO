package Pokemons;
import Moves.Blizzard;
import Moves.PowderSnow;
import Moves.Thunder;
import Moves.CosmicPower;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Castform extends Pokemon{
    public Castform(String name, int level){
        super(name, level);
        setStats(70, 70, 70, 70, 70, 70);
        setType(Type.NORMAL);
        var thunder = new Thunder();
        var blizzard = new Blizzard();
        var powdersnow = new PowderSnow();
        var cosmicpower = new CosmicPower();
        setMove(thunder, blizzard, powdersnow, cosmicpower);
    }
}
