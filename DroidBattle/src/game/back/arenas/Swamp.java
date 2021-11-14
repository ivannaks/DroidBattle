package game.back.arenas;

import game.back.droids.Droid;

import java.util.List;

public class Swamp extends Arena{

    @Override
    public void specialConditions(Droid attacker, Droid defender) {
        attacker.setDroidAccuracy(attacker.getDroidAccuracy() - 15);
        defender.setDroidAccuracy(defender.getDroidAccuracy() - 15);
    }

    @Override
    public void specialConditions(List<Droid> team1, List<Droid> team2) {
        for (Droid droid : team1) {
            droid.setDroidAccuracy(droid.getDroidAccuracy() - 15);
        }
        for (Droid droid : team2) {
            droid.setDroidAccuracy(droid.getDroidAccuracy() - 15);
        }
    }
}
