package game.back.droids;

import java.util.Random;

public abstract class Droid {

    protected String droidName;
    protected int droidMaxHealth;
    protected int droidCurHealth;
    protected int droidDamage;
    protected int droidAccuracy;
    protected int criticalDamage;
    protected int criticalEnergy;
    protected int currentEnergy;
    protected boolean alive = true;

    public int attack(Droid droid) {
        Random random = new Random();
        int damagePoints = 0;

        if (this.currentEnergy >= this.criticalEnergy) {
            this.criticalAttack(droid);
        } else {

            if (random.nextInt(100) <= this.droidAccuracy) {
                damagePoints = random.nextInt(10) + this.droidDamage - 10;
                droid.droidCurHealth -= damagePoints;
                System.out.println(this.toString() + " damaged " + droid.toString() + " \u001B[31m-" + damagePoints + "hP \u001B[0m");

                currentEnergy += Math.ceil(damagePoints * 0.2);
                if (droid.droidCurHealth <= 0) {
                    droid.droidCurHealth = 0;
                    droid.alive = false;
                    System.out.println("\u001B[35m"+droid.droidName + " failed :(\u001B[0m");
                }
            } else {
                System.out.println("\u001B[34m"+this.droidName + " missed -_-\u001B[0m");
            }
        }
        return damagePoints;
    }

    public int criticalAttack(Droid droid) {
        Random random = new Random();
        int damagePoints = 0;

        if (random.nextInt(100) <= this.droidAccuracy) {
            damagePoints = random.nextInt(8) + this.criticalDamage - 7;
            droid.droidCurHealth -= damagePoints;
            System.out.println(this.toString() + " critically damaged " + droid.toString() + " \u001B[31m-" + damagePoints + "hP \u001B[0m");

            if (droid.droidCurHealth <= 0) {
                droid.droidCurHealth = 0;
                droid.alive = false;
                System.out.println("\u001B[35m"+droid.droidName + " failed :(\u001B[0m");
            }
        } else {
            System.out.println("\u001B[34m"+this.droidName + " missed -_-\u001B[0m");
        }
        currentEnergy = 0;
        return damagePoints;
    }

    @Override
    public String toString() {
        return droidName + "(" + droidCurHealth + "hP, " + currentEnergy + "eP)";
    }

    public String getDroidName() {
        return droidName;
    }

    public int getDroidMaxHealth() {
        return droidMaxHealth;
    }

    public void setDroidMaxHealth(int droidMaxHealth) {
        this.droidMaxHealth = droidMaxHealth;
    }

    public void setDroidCurHealth(int droidCurHealth) {
        this.droidCurHealth = droidCurHealth;
    }

    public int getCriticalEnergy() {
        return criticalEnergy;
    }

    public void setCriticalEnergy(int criticalEnergy) {
        this.criticalEnergy = criticalEnergy;
    }

    public int getDroidAccuracy() {
        return droidAccuracy;
    }

    public void setDroidAccuracy(int droidAccuracy) {
        this.droidAccuracy = droidAccuracy;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getDroidCurHealth() {
        return droidCurHealth;
    }
}
