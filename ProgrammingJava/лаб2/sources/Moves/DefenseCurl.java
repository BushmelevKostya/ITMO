package Moves;

import ru.ifmo.se.pokemon.*;

public class DefenseCurl extends StatusMove {
    public DefenseCurl(){
        super(Type.NORMAL, 0,0);
    }
    @Override
    public void applySelfEffects(Pokemon pokemon) {
        Effect effect = new Effect();
        effect.stat(Stat.DEFENSE, 1).turns(-1);
        pokemon.setCondition(effect);
    }
    @Override
    public String describe() {
        return "прячет голову в песок.";
    }
}