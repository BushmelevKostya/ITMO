package Moves;

import ru.ifmo.se.pokemon.*;

public class CosmicPower extends StatusMove {
    public CosmicPower(){
        super(Type.PSYCHIC, 0,0);
    }
    @Override
    public void applySelfEffects(Pokemon pokemon) {
        Effect effect = new Effect();
        effect.stat(Stat.DEFENSE, 1).stat(Stat.SPECIAL_DEFENSE, 1).turns(-1);
        pokemon.setCondition(effect);
    }
    @Override
    public String describe() {return "повышает свою защиту!";}
}