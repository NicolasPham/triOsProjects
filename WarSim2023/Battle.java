import java.util.Scanner;
import java.util.Random;

import utils.*;
import armor.*;
import warrior.*;
import weapon.*;
public class Battle{

    private static Scanner input = new Scanner(System.in);
    private static Random randNum = new Random();
    private static ConsoleColor color = new ConsoleColor();

    //Utils
    private static Printer ink = new Printer();
    private static Setup setup = new Setup();
    private static Validation validation = new Validation();
    private static Attack attack = new Attack();

    //Player setup
    private static Warrior pWarrior;
    private static int[] playerChoice = {0, 0, 0}; // [warriorClass, armorClass, weaponClass]

    //Bot setup
    private static Warrior bWarrior;
    private static int choice;
    private static int[] botChoice = {0, 0, 0}; // [warriorClass, armorClass, weaponClass]

    //General
    private static String name;
    private static Armor armor = new Armor();
    private static Weapon weapon = new Weapon();
    private static int strikeResult;
    private static boolean isOVer = false;
    private static int turns = 0;
    private static boolean isPlayerTurn = true;
    private static boolean surrender = false;

    public static void main(String[] args) {

        System.out.println("<<======================>>"); 
        ink.welcome();
        System.out.println("Please enter your name!");
        name = input.nextLine();

        //***************** Select RACE *****************/
        System.out.println("<<======================>>");
        validation.warrior();
        choice = validation.choice;

        //***************** Select CLASS *****************/
        System.out.println("<<======================>>");
        System.out.println("Please choose your class");
        switch (choice) {
            case 1:
              ink.humanOptions();
              playerChoice[0]=-1; 
              break;       
            case 2:
                ink.elfOptions();
                playerChoice[0]=1;
                break;
            case 3:
                ink.orcOptions();
                playerChoice[0]=3;
                break;
            default: {}
            } //switch

        choice = validation.valid(1,2);
        if (choice == 1) {
            playerChoice[0] += 1;
        } else {
            playerChoice[0] += 2;
        } //return playerChoice[0] = 0-5;
        pWarrior = setup.createWarrior(playerChoice[0]);
        
        
        //******Create Armor and Weapon**********/
        System.out.println("<<============Armor Select==========>>");
        ink.armorSelection();
        choice = validation.valid(1, armor.listArmor.length);
        playerChoice[1] = choice-1; //return playerChoice[1] = 0-2;
        pWarrior.setArmor(choice);
        // pArmor = setup.armorSelection(choice);
        System.out.println("<<============Weapon Select==========>>");
        ink.weaponSelection();
        choice = validation.valid(1, weapon.listWeapon.length);
        playerChoice[2] = choice - 1;//return playerChoice[2] = 0-4;
        pWarrior.setWeapon(choice);

        System.out.println("<<============Result==========>>");
        ink.intialStats(playerChoice[0],playerChoice[1], playerChoice[2] ,pWarrior, pWarrior.armor(), pWarrior.weapon());
        
        
        //****** Generating an autobot **********/
        System.out.println("<<============Bot Generating==========>>");
        setup.loading(2000, "Bot generating...");
        botChoice[0] = randNum.nextInt(ink.listCharacter.length);
        botChoice[1] = randNum.nextInt(ink.listArmor.length);
        botChoice[2] = randNum.nextInt(ink.listWeapon.length);
        bWarrior = setup.createWarrior(botChoice[0]);
        bWarrior.setArmor(botChoice[1]+1);
        bWarrior.setWeapon(botChoice[2]+1);

        ink.intialStats(botChoice[0], botChoice[1], botChoice[2], bWarrior, bWarrior.armor(), bWarrior.weapon());

        pWarrior.setStatus();
        bWarrior.setStatus();
        /*<============== Attack ==============>*/
        System.out.println("");
        setup.loading(2000, "Creating the battle...");
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
                    } else {
                        strikeResult = attack.strike(choice, pWarrior, bWarrior);
                        bWarrior.receiverUpdate(strikeResult);
                        
                        //?Printing the sult
                        ink.playerAttack(name, "Autobot",strikeResult, bWarrior.getHealth() >= 0 ? bWarrior.getHealth() : 0);
                        
                        if (bWarrior.getHealth() <= 0 ) isOVer = true;
                        isPlayerTurn = false;
                    }
                } else {
                    choice = attack.botChoose(bWarrior);
                    strikeResult = attack.strike(choice, bWarrior, pWarrior);
                    pWarrior.receiverUpdate(strikeResult);
                    ink.playerAttack("Autobot", name, strikeResult, pWarrior.getHealth() >= 0 ? pWarrior.getHealth() : 0);
                    if (pWarrior.getHealth() <= 0 ) isOVer = true;                
                    isPlayerTurn = true;
                System.out.println("<==============End Round==============>");
            }


        }//game over
        
        System.out.println(color.YELLOW_BOLD_BRIGHT + "GAME OVER!" + color.RESET);
        if (surrender) {
            System.out.println("You have raised the white flag. Battle is over!!!!");
        } else {
            if (pWarrior.getHealth() > 0) System.out.printf("You win after %d rounds!!!!!\n", turns);
            else System.out.printf(color.CYAN + "You loose after %d rounds!!!!!\n" + color.RESET, turns);
        }
        

        
    }//main
}//class
