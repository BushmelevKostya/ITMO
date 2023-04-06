package Moves;

import ru.ifmo.se.pokemon.*;

public class PowderSnow extends SpecialMove {
    public PowderSnow(){
        super(Type.ICE, 40, 100);
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
        return "кидается снежками!";
    }
}