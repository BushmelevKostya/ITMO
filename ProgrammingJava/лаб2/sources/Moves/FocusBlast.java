package Moves;

import ru.ifmo.se.pokemon.*;

public class FocusBlast extends SpecialMove {
    public FocusBlast(){
        super(Type.FIGHTING, 120, 70);
    }
    public void applyOppEffects(Pokemon pokemon) {
        var effect = new Effect();
        effect.stat(Stat.SPECIAL_DEFENSE, -1).chance(0.1).turns(-1);
        pokemon.setCondition(effect);
    }
    @Override
    public String describe() {
        return "Применяет силу";
    }
}
