import ru.ifmo.se.pokemon.Battle;
import Pokemons.Castform;
import Pokemons.Buizel;
import Pokemons.Floatzel;
import Pokemons.Porygon;
import Pokemons.Porygon2;
import Pokemons.PorygonZ;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        var castform = new Castform("R2-D2", 10);
        var buizel = new Buizel("Чубакка", 10);
        var floatzel = new Floatzel("Йода", 10);
        var porygon = new Porygon("Дарт Мол", 10);
        var porygon2 = new Porygon2("Дарт Вейдер", 10);
        var porygonZ = new PorygonZ("Палпатин", 10);
        b.addAlly(castform);
        b.addAlly(buizel);
        b.addAlly(floatzel);
        b.addFoe(porygon);
        b.addFoe(porygon2);
        b.addFoe(porygonZ);
        b.go();

    }
}