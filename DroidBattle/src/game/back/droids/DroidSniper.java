package game.back.droids;

public class DroidSniper extends Droid {

    public DroidSniper(String name) {
        droidName = name;
        droidDamage = 55;
        criticalDamage = 100;
        criticalEnergy = 35;
        currentEnergy = 0;
        droidCurHealth = droidMaxHealth = 150;
        droidAccuracy = 97;
    }

    @Override
    public int criticalAttack(Droid droid) {
        if (super.criticalAttack(droid) == 0) {
            return 0;
        }
        int accuracyPoints = (int) Math.ceil(droid.droidAccuracy * 0.1);
        droid.droidAccuracy -= accuracyPoints;
        System.out.println(droid.droidName + " \u001B[35m-" + accuracyPoints + "ac \u001B[0m");
        return accuracyPoints;
    }
}