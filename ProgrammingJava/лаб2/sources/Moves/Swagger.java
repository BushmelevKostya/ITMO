package Moves;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger(){
        super(Type.NORMAL, 0,85);
    }
    @Override
    public void applyOppEffects(Pokemon pokemon) {
        pokemon.confuse();
        Effect effect = new Effect();
        effect.stat(Stat.ATTACK, 2);
        pokemon.setCondition(effect);
    }
    @Override
    public String describe() {
        return "использует секретную технику \"тысячелетия боли\".";
    }
}