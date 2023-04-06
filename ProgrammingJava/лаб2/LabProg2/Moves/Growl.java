package Moves;

import ru.ifmo.se.pokemon.*;

public class Growl extends StatusMove {
    public Growl(){
        super(Type.NORMAL, 0,100);
    }
    @Override
    public void applyOppEffects(Pokemon pokemon) {
        Effect effect = new Effect();
        effect.stat(Stat.ATTACK, -1).turns(-1);
        pokemon.setCondition(effect);
    }
    @Override
    public String describe() {
        return "громко вопит";
    }
}