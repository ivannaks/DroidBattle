package game.back.arenas;

import game.back.droids.Droid;
import java.util.List;

public class Storm extends Arena {

    @Override
    public void specialConditions(Droid attacker, Droid defender) {
        attacker.setCriticalEnergy(attacker.getCriticalEnergy() - 10);
        defender.setCriticalEnergy(defender.getCriticalEnergy() - 10);
    }

    @Override
    public void specialConditions(List<Droid> team1, List<Droid> team2) {
        for (Droid droid : team1) {
            droid.setCriticalEnergy(droid.getCriticalEnergy() - 10);
        }
        for (Droid droid : team2) {
            droid.setCriticalEnergy(droid.getCriticalEnergy() - 10);
        }
    }
}