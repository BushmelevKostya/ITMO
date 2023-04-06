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
        var castform = new Castform("Мотылек", 10);
        var buizel = new Buizel("Дейл", 10);
        var floatzel = new Floatzel("Чип", 10);
        var porygon = new Porygon("Доктор Стрэндж", 10);
        var porygon2 = new Porygon2("Доктор Кто", 10);
        var porygonZ = new PorygonZ("Доктор Ливси", 10);
        b.addAlly(castform);
        b.addAlly(buizel);
        b.addAlly(floatzel);
        b.addFoe(porygon);
        b.addFoe(porygon2);
        b.addFoe(porygonZ);
        b.go();
    }
}