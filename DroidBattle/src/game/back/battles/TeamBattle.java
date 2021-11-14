package game.back.battles;

import game.back.arenas.Arena;
import game.back.droids.Droid;

import java.util.List;
import java.util.Random;

public class TeamBattle extends Fighting {
    private String attackName;
    private List<Droid> attackers;
    private String defendName;
    private List<Droid> defenders;

    public TeamBattle(String nameTeam1, String nameTeam2, List<Droid> team1, List<Droid> team2, Arena arena) {
        Random random = new Random();
        if (random.nextBoolean()) {
            this.attackers = team1;
            attackName = nameTeam1;
            this.defenders = team2;
            defendName = nameTeam2;
        } else {
            this.attackers = team2;
            attackName = nameTeam2;
            this.defenders = team1;
            defendName = nameTeam1;
        }
        this.arena = arena;
    }

    public String teamOnTeam() {
        arena.specialConditions(attackers, defenders);
        while (attackers.size() != 0) {
            fighting();
            swap();
        }
        return attackName;
    }

    private void fighting() {
        Random random = new Random();
        fight(attackers.get(random.nextInt(attackers.size())), defenders.get(random.nextInt(defenders.size())));
        defenders.removeIf(droid -> !droid.isAlive());
    }

    private void swap() {
        List<Droid> tmp = attackers;
        attackers = defenders;
        defenders = tmp;
        String tmpStr = attackName;
        attackName = defendName;
        defendName = tmpStr;
    }

    public List<Droid> getAttackers() {
        return attackers;
    }
}
