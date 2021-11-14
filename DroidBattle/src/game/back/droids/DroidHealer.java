package game.back.droids;

import game.back.battles.Fighting;
import game.back.battles.Duel;
import game.back.battles.TeamBattle;

import java.util.Random;

public class DroidHealer extends Droid {

    public DroidHealer(String name) {
        droidName = name;
        droidDamage = 25;
        criticalDamage = 50;
        criticalEnergy = 20;
        currentEnergy = 0;
        droidCurHealth = droidMaxHealth = 400;
        droidAccuracy = 80;
    }

    @Override
    public int criticalAttack(Droid droid) {
        int healPoints = super.criticalAttack(droid);
        if (healPoints == 0) {
            return 0;
        }
        droidCurHealth += healPoints;
        if (droidCurHealth > droidMaxHealth) {
            droidCurHealth = droidMaxHealth;
        }
        System.out.println(droidName + "\u001B[32m +" + healPoints + "hP\u001B[0m");
        return healPoints;
    }

    public void heal(Fighting battle) {
        if (battle instanceof Duel) {
            droidCurHealth += 0.05 * droidCurHealth;
            System.out.println(droidName + " heal itself \u001B[32m+" + (int) (0.05 * droidCurHealth) + "hP \u001B[0m");

            if (droidCurHealth > droidMaxHealth) {
                droidCurHealth = droidMaxHealth;
            }
        }
        if (battle instanceof TeamBattle) {
            Random random = new Random();
            int id = random.nextInt(((TeamBattle) battle).getAttackers().size());
            Droid droid = ((TeamBattle) battle).getAttackers().get(id);

            droid.droidCurHealth += 0.05 * droidCurHealth;
            System.out.println(droidName + " heal " + droid.droidName + "\u001B[32m +" + (int) (0.05 * droidCurHealth) + "hP \u001B[0m");

            if (droid.droidCurHealth > droid.droidMaxHealth) {
                droid.droidCurHealth = droid.droidMaxHealth;
            }
        }
    }
}
