package game.front;

import game.back.battles.Duel;
import game.back.battles.TeamBattle;
import game.back.arenas.*;
import game.back.droids.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameActions {

    public final static String FileDirectory = "C:\\java\\lab3.txt";

    public static void saveDuelToFile(List<Droid> listOfDroids) throws IOException {

        Duel battle = getDuel(listOfDroids);

        PrintWriter out = new PrintWriter(new FileWriter(FileDirectory));
        PrintStream console = System.out;
        console.flush();
        FileOutputStream fileOutputStream = new FileOutputStream(FileDirectory);
        PrintStream fileOut = new PrintStream(fileOutputStream, false);
        System.setOut(fileOut);
        System.out.println("\nThe duel starts...");
        System.out.println(battle.droidOnDroid() + " won!");
        fileOutputStream.flush();
        fileOut.flush();
        out.flush();
        out.close();
        System.setOut(console);
        System.out.println("The duel was successfully saved to a file.");
    }

    public static void saveTeamBattleToFile(List<Droid> listOfDroids) throws IOException {
        TeamBattle battle = getTeamBattle(listOfDroids);

        PrintStream consoleStream = System.out;
        FileOutputStream fileOutputStream = new FileOutputStream(FileDirectory);
        PrintStream stream = new PrintStream(fileOutputStream);
        System.setOut(stream);
        System.out.println("\nThe team battle starts...");
        System.out.println(battle.teamOnTeam() + " won!");
        System.setOut(consoleStream);
        fileOutputStream.close();
        stream.close();
        System.out.println("The team battle was successfully saved to a file.");
    }

    public static void outputLastBattleFromFile() throws IOException {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDirectory)));
        while (fileReader.ready()) {
            System.out.println(fileReader.readLine());
        }
        fileReader.close();
    }

    public static TeamBattle getTeamBattle(List<Droid> listOfDroids) {
        List<Droid> team1 = new ArrayList<>();
        List<Droid> team2 = new ArrayList<>();

        Arena arenaTeam = chooseArena();

        Scanner scanner = new Scanner(System.in);
        int mem;
        while (true) {
            System.out.print("Enter number of droids in each team:  ");
            mem = scanner.nextInt();
            if (mem <= listOfDroids.size() / 2) {
                break;
            }
            System.out.println("You don`t have enough droids to perform this battle.");
        }
        scanner.nextLine();
        String name1, name2;

        System.out.print("Enter name of team 1: ");
        name1 = scanner.nextLine();
        displayDroids(listOfDroids);
        System.out.println("\nNow choose droids to add to " + name1);
        int idDroid;

        int i = 1;
        while (true) {
            System.out.print("Code of droid #" + i + ": ");
            idDroid = scanner.nextInt();
            if (idDroid <= listOfDroids.size()) {
                if (team1.contains(listOfDroids.get(idDroid - 1))) {
                    System.out.println("This droid`s already added. Try again.");
                    continue;
                }
                team1.add(listOfDroids.get(idDroid - 1));
                i++;
                if (i > mem) {
                    break;
                }
                continue;
            }
            System.out.println("You don`t have any droid with this code. Try again");
        }
        scanner.nextLine();
        System.out.print("\nEnter name of team 2: ");
        name2 = scanner.nextLine();
        displayDroids(listOfDroids);
        System.out.println("\nNow choose droids to add to " + name2);
        i = 1;
        while (true) {
            System.out.print("Code of droid #" + i + ": ");
            idDroid = scanner.nextInt();
            if (idDroid <= listOfDroids.size()) {
                if (team2.contains(listOfDroids.get(idDroid - 1)) || team1.contains(listOfDroids.get(idDroid - 1))) {
                    System.out.println("This droid`s already added. Try again.");
                    continue;
                }
                team2.add(listOfDroids.get(idDroid - 1));
                i++;
                if (i > mem) {
                    break;
                }
                continue;
            }
            System.out.println("You don`t have any droid with this code. Try again");
        }
        return new TeamBattle(name1, name2, team1, team2, arenaTeam);
    }

    public static Duel getDuel(List<Droid> listOfDroids) {
        Droid droid1, droid2;
        Arena arenaDuel = chooseArena();

        displayDroids(listOfDroids);

        System.out.println("\nNow choose droids for the duel");
        Scanner scanner = new Scanner(System.in);
        int idDroid;
        while (true) {
            System.out.print("Code of droid #1: ");
            idDroid = scanner.nextInt();
            if (idDroid <= listOfDroids.size()) {
                droid1 = listOfDroids.get(idDroid - 1);
                break;
            }
            System.out.println("You don`t have any droid with this code. Try again");
        }
        while (true) {
            System.out.print("Code of droid #2: ");
            idDroid = scanner.nextInt();
            if (idDroid <= listOfDroids.size()) {
                droid2 = listOfDroids.get(idDroid - 1);
                break;
            }
            System.out.println("You don`t have any droid with this code. Try again");
        }

        return new Duel(droid1, droid2, arenaDuel);
    }

    private static Arena chooseArena() {
        int idArena;
        while (true) {
            Interface.arenaMenu();

            System.out.print("Please choose an arena for the battle:  ");
            Scanner scanner = new Scanner(System.in);
            idArena = scanner.nextInt();

            switch (idArena) {
                case 1:
                    return new Arena();
                case 2:
                    return new Field();
                case 3:
                    return new Swamp();
                case 4:
                    return new Storm();
                case 5:
                    return new Hospital();
                default:
                    System.out.println("Incorrect code of arena. Try again.");
                    break;
            }
        }
    }

    public static void createDroids(List<Droid> listOfDroids) {
        int idDroid;
        String name;
        while (true) {
            System.out.print("Please choose a droid to create: ");
            Scanner scanner = new Scanner(System.in);
            idDroid = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter the name of droid: ");
            name = scanner.nextLine();
            switch (idDroid) {
                case 1:
                    listOfDroids.add(new DroidKiller(name));
                    break;
                case 2:
                    listOfDroids.add(new DroidHealer(name));
                    break;
                case 3:
                    listOfDroids.add(new DroidBomber(name));
                    break;
                case 4:
                    listOfDroids.add(new DroidSniper(name));
                    break;
                default:
                    System.out.println("Incorrect code of droid. Try again.");
                    break;
            }
            System.out.print("One more? (yes/no)    ");
            if (scanner.nextLine().equals("no")) {
                return;
            }
            System.out.println();
        }
    }

    public static void restoreHealth(List<Droid> listOfDroids) {
        for (Droid droid : listOfDroids) {
            if (droid.getDroidCurHealth() != droid.getDroidMaxHealth()) {
                droid.setDroidCurHealth(droid.getDroidMaxHealth());
            }
        }
    }

    public static void displayDroids(List<Droid> listOfDroids) {
        if (listOfDroids.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("\n\t----------------DROIDS---------------");
        System.out.println("\t┎──────┰─────────────┰──────────────┒");
        System.out.println("\t┃ Code ┃    Name     ┃     Class    ┃");
        System.out.println("\t┖──────┸─────────────┸──────────────┚");
        for (int i = 0; i < listOfDroids.size(); i++) {
            System.out.printf("\t%4d\t%9s\t\t\t", (i + 1), listOfDroids.get(i).getDroidName());
            if (listOfDroids.get(i) instanceof DroidKiller) {
                System.out.println("killer");
                continue;
            }
            if (listOfDroids.get(i) instanceof DroidHealer) {
                System.out.println("healer");
                continue;
            }
            if (listOfDroids.get(i) instanceof DroidBomber) {
                System.out.println("bomber");
                continue;
            }
            if (listOfDroids.get(i) instanceof DroidSniper) {
                System.out.println("sniper");
            }
        }
    }
}
