package Moves;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }
    private boolean flag;
    @Override
    public void applyOppDamage(Pokemon pokemon, double damage){
        Status effect = pokemon.getCondition();
        flag = false;
        if (effect == Status.BURN || effect == Status.POISON || effect == Status.PARALYZE){
            flag = true;
            pokemon.setMod(Stat.HP, -2*(int)Math.round(damage));
        }
    }
    @Override
    public String describe() {
        if (flag){return "денсит";}
        else {return "жестко денсит";}
    }
}
