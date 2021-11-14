package game.front;

import game.back.battles.Duel;
import game.back.battles.TeamBattle;
import game.back.droids.Droid;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static game.front.GameActions.*;

public class Process {

    public static void main(String[] args) throws IOException {

        List<Droid> listOfDroids = new ArrayList<>();
        System.out.println("\n\t\u001B[35mHey, let`s start the game...\u001B[0m\n");
        int idAction;

        while (true) {
            Scanner scanner = new Scanner(System.in);

            Interface.menu();
            System.out.print("Please choose an option: ");
            idAction = scanner.nextInt();

            switch (idAction) {
                case 1:
                    Interface.droidMenu();
                    createDroids(listOfDroids);
                    break;
                case 2:
                    displayDroids(listOfDroids);
                    break;
                case 3:
                    Duel battle = getDuel(listOfDroids);
                    System.out.println("\n\u001B[35mThe duel starts...\u001B[0m");
                    System.out.println("\u001B[36m" + battle.droidOnDroid() + " won!\u001B[0m");
                    restoreHealth(listOfDroids);
                    break;
                case 4:
                    TeamBattle teamBattle = getTeamBattle(listOfDroids);
                    System.out.println("\n\u001B[35mThe teambattle starts...\u001B[0m");
                    System.out.println("\u001B[36m" + teamBattle.teamOnTeam() + " won!\u001B[0m");
                    restoreHealth(listOfDroids);
                    break;
                case 5:
                    System.out.print("What do want to write, duel or team battle? (d/t)   ");
                    if (scanner.hasNext("d")) {
                        saveDuelToFile(listOfDroids);
                    } else if (scanner.hasNext("t")) {
                        saveTeamBattleToFile(listOfDroids);
                    } else {
                        System.out.println("\u001B[31mWrong symbol!\u001B");
                    }
                    restoreHealth(listOfDroids);
                    break;
                case 6:
                    outputLastBattleFromFile();
                    break;
                case 7:
                    System.out.println("\n\u001B[35mThank`s for playing\u001B[0m");
                    return;
                default:
                    System.out.println("Incorrect code of action. Try again.");
                    break;
            }
        }
    }
}
