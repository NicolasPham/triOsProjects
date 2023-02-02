import java.util.Scanner;
import java.util.Random;

import utils.*;
import armor.*;
import warrior.*;
import weapon.*;
public class Battle {

    private static Scanner input = new Scanner(System.in);
    private static Random randNum = new Random();

    //Utils
    private static Printer ink = new Printer();
    private static Setup setup = new Setup();
    private static Validation validation = new Validation();

    //Player setup
    private static Armor pArmor;
    private static Warrior pWarrior;
    private static Weapon pWeapon;
    private static int[] playerChoice = {0, 0, 0}; // [warriorClass, armorClass, weaponClass]

    //Bot setup
    private static Armor bArmor;
    private static Warrior bWarrior;
    private static Weapon bWeapon;
    private static int choice;
    private static int[] botChoice = {0, 0, 0}; // [warriorClass, armorClass, weaponClass]

    //General
    private static Armor armor = new Armor();
    private static Weapon weapon = new Weapon();
    

    public static void main(String[] args) {
        System.out.println("<<======================>>"); 
        ink.welcome();

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
        pArmor = setup.armorSelection(choice);
        System.out.println("<<============Weapon Select==========>>");
        ink.weaponSelection();
        choice = validation.valid(1, weapon.listWeapon.length);
        playerChoice[2] = choice - 1;//return playerChoice[2] = 0-4;
        pWeapon = setup.weaponSelection(choice);

        System.out.println("<<============Result==========>>");
        ink.intialStats(playerChoice[0],playerChoice[1], playerChoice[2] ,pWarrior, pArmor, pWeapon);
        
        
        //****** Generating an autobot **********/
        System.out.println("<<============Bot Generating ...==========>>");
        botChoice[0] = randNum.nextInt(ink.listCharacter.length);
        botChoice[1] = randNum.nextInt(ink.armor.listArmor.length);
        botChoice[2] = randNum.nextInt(ink.weapon.listWeapon.length);
        bWarrior = setup.createWarrior(botChoice[0]);
        bArmor = setup.armorSelection(botChoice[1]);
        bWeapon = setup.weaponSelection(botChoice[2]);

        ink.intialStats(botChoice[0], botChoice[1], botChoice[2], bWarrior, bArmor, bWeapon);


        
        
    }//main
}//class
