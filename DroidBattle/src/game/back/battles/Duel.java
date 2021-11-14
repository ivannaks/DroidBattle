package game.back.battles;

import game.back.arenas.Arena;
import game.back.droids.Droid;

import java.util.Random;

public class Duel extends Fighting {
    private Droid attacker;
    private Droid defender;

    public Duel(Droid droid1, Droid droid2, Arena arena) {
        Random random = new Random();
        if (random.nextBoolean()) {
            this.attacker = droid1;
            this.defender = droid2;
        } else {
            this.attacker = droid2;
            this.defender = droid1;
        }
        this.arena = arena;
    }

    public String droidOnDroid() {
        arena.specialConditions(attacker, defender);
        while (attacker.isAlive()) {
            fight(attacker, defender);
            swap();
        }
        return defender.getDroidName();
    }

    private void swap() {
        Droid tmp = attacker;
        attacker = defender;
        defender = tmp;
    }
}

