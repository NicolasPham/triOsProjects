import java.util.Scanner;
import java.util.Random;

import utils.*;
import warrior.*;
public class Battle{

    private static Scanner input = new Scanner(System.in);
    private static ConsoleColor color = new ConsoleColor();
    private static Game game = new Game();  

    //Utils
    private static Printer ink = new Printer();
    private static Setup setup = new Setup();
    private static Attack attack = new Attack();

    //Player setup
    private static Warrior pWarrior;

    //Bot setup
    private static Warrior bWarrior;
    private static int choice;

    //General
    private static String name;

    private static int strikeResult;
    private static int totalPlayerDamage = 0;;
    private static int totalBotDamage = 0;
    private static boolean isOVer = false;
    private static int turns = 0;
    private static boolean isPlayerTurn = true;
    private static boolean surrender = false;
    private static boolean reset = false;

    public static void main(String[] args) {

        System.out.println("<<======================>>"); 
        ink.welcome();

        //new game or saved game????
        game.newGame();
        pWarrior = game.player;
        name = game.playerName;
        bWarrior = game.autobot;

        /*<============== Attack ==============>*/
        while (!reset) {
            isOVer = false;
            turns = 0;

            System.out.println("");
            setup.loading(3000, "Creating the battle...");
            ink.deleteLine(1);

            System.out.println(color.BLUE_BACKGROUND_BRIGHT + "<<============ LET'S GO ==========>>" + color.RESET);
            while (!isOVer) {
                if (isPlayerTurn) {

                    //Player turn:
                        turns += 1;

                        System.out.printf(color.PURPLE + "Round %d\n " + color.RESET, turns);
                        ink.strikeOptions(pWarrior);
                        choice = input.nextInt();

                        if (choice == 0 ) {
                            surrender = true;
                            isOVer = true;
                            reset = true;
                        } else if (choice == 2023) {
                            pWarrior = game.savedPlayer;
                            name =game.savedName;
                            bWarrior = game.savedBot;

                            ink.resetGame();

                            isOVer = true;
                        } 
                        else if (choice >=1 && choice <=3) {
                            strikeResult = attack.strike(choice, pWarrior, bWarrior);
                            bWarrior.receiverUpdate(strikeResult);
                            
                            //?Printing the sult
                            ink.playerAttack(name, "Autobot",strikeResult, bWarrior.getHealth() >= 0 ? bWarrior.getHealth() : 0);
                            
                            if (bWarrior.getHealth() <= 0 ) {
                                isOVer = true;
                                reset = true;
                            }
                            isPlayerTurn = false;
                            totalPlayerDamage += strikeResult;
                        } else {
                            System.out.println("Please choose options above");
                        }
                    } else {
                        choice = attack.botChoose(bWarrior);
                        strikeResult = attack.strike(choice, bWarrior, pWarrior);
                        pWarrior.receiverUpdate(strikeResult);
                        ink.playerAttack("Autobot", name, strikeResult, pWarrior.getHealth() >= 0 ? pWarrior.getHealth() : 0);
                        if (pWarrior.getHealth() <= 0 ) {
                            isOVer = true;
                            reset = true;
                        }                
                        isPlayerTurn = true;
                        totalBotDamage += strikeResult;
                    System.out.println("<==============End Round==============>");
                }
            }//game over
        } //reset
        
        System.out.println(color.YELLOW_BOLD_BRIGHT + "GAME OVER!" + color.RESET);
        if (surrender) {
            System.out.println("You have raised the white flag. Battle is over!!!!");
        } else {
            if (pWarrior.getHealth() > 0) System.out.printf("You made %d damages in total and win after %d rounds!!!!!\n", totalPlayerDamage, turns);
            else System.out.printf(color.CYAN + "You loose after %d rounds and %d damages!!!!!\n" + color.RESET, turns, totalBotDamage);
        }
        

        
    }//main
}//class
