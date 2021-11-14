package game.back.arenas;

import game.back.droids.Droid;

import java.util.List;

public class Hospital extends Arena {

    @Override
    public void specialConditions(Droid attacker, Droid defender) {
        attacker.setDroidMaxHealth((int) (0.85 * attacker.getDroidMaxHealth()));
        attacker.setDroidCurHealth(attacker.getDroidMaxHealth());

        defender.setDroidMaxHealth((int) (0.85 * defender.getDroidMaxHealth()));
        defender.setDroidCurHealth(defender.getDroidMaxHealth());
    }

    @Override
    public void specialConditions(List<Droid> team1, List<Droid> team2) {
        for (Droid droid : team1) {
            droid.setDroidMaxHealth((int) (0.85 * droid.getDroidMaxHealth()));
        }
        for (Droid droid : team2) {
            droid.setDroidMaxHealth((int) (0.85 * droid.getDroidMaxHealth()));
        }
    }
}