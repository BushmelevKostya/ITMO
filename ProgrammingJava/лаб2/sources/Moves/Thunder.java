package Moves;

import ru.ifmo.se.pokemon.*;

public class Thunder extends SpecialMove {
    public Thunder(){
        super(Type.ELECTRIC, 110, 70);
    }
    @Override
    public void applyOppEffects(Pokemon pokemon) {
        if (!pokemon.hasType(Type.ELECTRIC)) {
            var effect = new Effect();
            effect.condition(Status.PARALYZE).attack(0.75).chance(0.3).turns(-1);
            effect.stat(Stat.SPEED, -2);
            pokemon.setCondition(effect);
        }
    }
    @Override
    public String describe() {
        return "применяет раскаты грома!";
    }
}
