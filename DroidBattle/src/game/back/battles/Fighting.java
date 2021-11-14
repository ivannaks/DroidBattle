package game.back.battles;

import game.back.arenas.Arena;
import game.back.droids.*;

public abstract class Fighting {
    protected Arena arena;

    public void fight(Droid attacker, Droid defender) {
        if (attacker.attack(defender) != 0) {
            if (attacker instanceof DroidHealer) {
                ((DroidHealer) attacker).heal(this);
            }
            if (attacker instanceof DroidBomber) {
                ((DroidBomber) attacker).energize(this);
            }
        }
    }
}
