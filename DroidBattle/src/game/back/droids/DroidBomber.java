package game.back.droids;

import game.back.battles.Fighting;
import game.back.battles.Duel;
import game.back.battles.TeamBattle;

import java.util.Random;

public class DroidBomber extends Droid {

    public DroidBomber(String name) {
        droidName = name;
        droidDamage = 60;
        criticalDamage = 100;
        criticalEnergy = 45;
        currentEnergy = 0;
        droidCurHealth = droidMaxHealth = 200;
        droidAccuracy = 65;
    }

    @Override
    public int criticalAttack(Droid droid) {
        if (super.criticalAttack(droid) == 0) {
            return 0;
        }
        int damagePoints = (int) Math.ceil(droid.droidDamage * 0.1);
        droid.droidDamage -= damagePoints;
        System.out.println(droid.droidName + "\u001B[34m -" + damagePoints + "dP\u001B[0m.  ");
        return damagePoints;
    }

    public void energize(Fighting battle) {
        if (battle instanceof Duel) {
            currentEnergy += 0.25 * criticalEnergy;
            System.out.println(droidName + " energize itself \u001B[33m+" + (int) (0.25 * criticalEnergy) + "eP \u001B[0m");
        }
        if (battle instanceof TeamBattle) {
            Random random = new Random();
            int id = random.nextInt(((TeamBattle) battle).getAttackers().size());
            Droid droid = ((TeamBattle) battle).getAttackers().get(id);

            droid.currentEnergy += 0.25 * criticalEnergy;
            System.out.println(droidName + " energize " + droid.droidName + " \u001B[33m+" + (int) (0.25 * criticalEnergy) + "eP \u001B[0m");
        }
    }
}
