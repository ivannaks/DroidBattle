package game.back.droids;

public class DroidKiller extends Droid {

    public DroidKiller(String name) {
        droidName = name;
        droidDamage = 35;
        criticalDamage = 90;
        criticalEnergy = 30;
        currentEnergy = 0;
        droidCurHealth = droidMaxHealth = 250;
        droidAccuracy = 90;
    }

    @Override
    public int criticalAttack(Droid droid) {
        if (super.criticalAttack(droid) == 0) {
            return 0;
        }
        int energyPoints = droid.criticalEnergy / 5;
        droid.currentEnergy -= energyPoints;
        System.out.println(droid.droidName + " \u001B[33m-" + energyPoints + "eP \u001B[0m");

        if (droid.currentEnergy < 0){
            droid.currentEnergy = 0;
        }
        return energyPoints;
    }
}
