package game.front;

public class Interface {
    public static void menu(){
        System.out.println("\n\t-------------------MENU----------------------");
        System.out.println("\t┎─────────────┰─────────────────────────────┒");
        System.out.println("\t┃ Action code ┃           Actions           ┃");
        System.out.println("\t┠─────────────╂─────────────────────────────┨");
        System.out.println("\t┃     1       ┃       create droids         ┃");
        System.out.println("\t┃     2       ┃show list of available droids┃");
        System.out.println("\t┃     3       ┃           duel              ┃");
        System.out.println("\t┃     4       ┃        team battle          ┃");
        System.out.println("\t┃     5       ┃ write the battle to a file  ┃");
        System.out.println("\t┃     6       ┃ play last battle from file  ┃");
        System.out.println("\t┃     7       ┃      exit the program       ┃");
        System.out.println("\t┖─────────────┸─────────────────────────────┚");
    }

    public static void droidMenu(){
        System.out.println("\n\t-----------------------------------------DROIDS-------------------------------------------");
        System.out.println("\t┎──────┰──────────┰─────────────────────────┰────────────────────────────────┰───────────┒");
        System.out.println("\t┃ Code ┃  Droid   ┃   Characteristics       ┃   Specify of critical attack   ┃   Skill   ┃");
        System.out.println("\t┠──────╂──────────╂─────────────────────────╂────────────────────────────────╂───────────┨");
        System.out.println("\t┃  1   ┃  Killer  ┃hP=250 dP=35 cd=90  ac=90┃ -20% of energy points of enemy ┃     -     ┃");
        System.out.println("\t┃  2   ┃  Healer  ┃hP=400 dP=25 cd=50  ac=80┃   increases it`s health on dP  ┃    heal   ┃");
        System.out.println("\t┃  3   ┃  Bomber  ┃hP=200 dP=60 cd=100 ac=65┃    -10% of damage of enemy     ┃  energize ┃");
        System.out.println("\t┃  4   ┃  Sniper  ┃hP=150 dP=55 cd=100 ac=97┃   -10% of accuracy of enemy    ┃     -     ┃");
        System.out.println("\t┖──────┸──────────┸─────────────────────────┸────────────────────────────────┸───────────┚");
    }


    public static void arenaMenu(){
        System.out.println("\n\t-----------------ARENA------------------");
        System.out.println("\t┎──────┰──────────┰────────────────────┒");
        System.out.println("\t┃ Code ┃  Arena   ┃   Characteristics  ┃");
        System.out.println("\t┠──────╂──────────╂────────────────────┨");
        System.out.println("\t┃  1   ┃  Simple  ┃          -         ┃");
        System.out.println("\t┃  2   ┃  Field   ┃    accuracy +15    ┃");
        System.out.println("\t┃  3   ┃  Swamp   ┃    accuracy -15    ┃");
        System.out.println("\t┃  4   ┃  Storm   ┃ critical energy -10┃");
        System.out.println("\t┃  5   ┃ Hospital ┃    85% max health  ┃");
        System.out.println("\t┖──────┸──────────┸────────────────────┚");

    }
}
