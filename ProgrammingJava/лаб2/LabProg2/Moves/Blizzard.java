package Moves;

import ru.ifmo.se.pokemon.*;

public class Blizzard extends SpecialMove {
    public Blizzard(){
        super(Type.ICE, 110, 70);
    }
    @Override
    public void applyOppEffects(Pokemon pokemon) {
        if (!pokemon.hasType(Type.ICE)) {
            var effect = new Effect();
            effect.condition(Status.FREEZE).attack(0.0).chance(0.1).turns(-1);
            pokemon.setCondition(effect);
        }
    }
    @Override
    public String describe() {
        return "призывает ледяной ветер!";
    }
}

