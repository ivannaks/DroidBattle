package game.back.arenas;

import game.back.droids.Droid;

import java.util.List;

public class Field extends Arena {

    @Override
    public void specialConditions(Droid attacker, Droid defender) {
        attacker.setDroidAccuracy(attacker.getDroidAccuracy() + 15);
        if (attacker.getDroidAccuracy() > 100) attacker.setDroidAccuracy(100);

        defender.setDroidAccuracy(defender.getDroidAccuracy() + 15);
        if (defender.getDroidAccuracy() > 100) defender.setDroidAccuracy(100);
    }

    @Override
    public void specialConditions(List<Droid> team1, List<Droid> team2) {
        for (Droid droid : team1) {
            droid.setDroidAccuracy(droid.getDroidAccuracy() + 15);
            if (droid.getDroidAccuracy() > 100) droid.setDroidAccuracy(100);
        }
        for (Droid droid : team2) {
            droid.setDroidAccuracy(droid.getDroidAccuracy() + 15);
            if (droid.getDroidAccuracy() > 100) droid.setDroidAccuracy(100);
        }
    }
}
