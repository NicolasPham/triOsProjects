package utils;
import java.util.Scanner;
import java.util.Random;
import utils.*;
import warrior.*;

public class Game {

    private Random randNum = new Random();
    private Scanner input = new Scanner(System.in);

    private Printer ink = new Printer();
    private Validation validation = new Validation();
    private Setup setup = new Setup();
    
    public Warrior player;
    public Warrior autobot;
    public String playerName;

    public Warrior savedPlayer;
    public Warrior savedBot;
    public String savedName;

    private int[] playerChoice = {0,0,0}; //{warrior, armor, weapon};
    private int[] botChoice ={0,0,0}; //{warrior, armor, weapon};
    private int choice;
    

    public Game() {

    }

    //constructor
    public void newGame() {
        System.out.println("Please enter your name!");
        playerName = input.nextLine();
        newWarrior();
        newArmor();
        newWeapon();
        result();
        generateBot();
        //update status after add all numbers from weapon and armor
        player.setStatus();
        autobot.setStatus();
        save();
    }

    public void newWarrior() {
        ink.characterOptions();

        try {
            this.choice = validation.checkValid(1,3);
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
                default: {
                    System.out.println("Not a correct number");
                }
                } //switch
        } catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG");
        }
        
        //SELECT WARRIOR CLASS
        try {
            this.choice = validation.checkValid(1,2);
            if (choice == 1) {
                playerChoice[0] += 1;
            } else {
                playerChoice[0] += 2;
            } //return playerChoice[0] = 0-5;
            player = setup.createWarrior(playerChoice[0]);
        } catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG");
        }
    } //newWarrior
    
    public void newArmor() {
        System.out.println("<<============Armor Select==========>>");
        ink.armorSelection();
        this.choice = validation.checkValid(1, ink.listArmor.length);
        playerChoice[1] = choice-1;
        player.setArmor(choice);
    }

    public void newWeapon() {
        System.out.println("<<============Weapon Select==========>>");
        ink.weaponSelection();
        this.choice = validation.checkValid(1, ink.listWeapon.length);
        playerChoice[2] = choice - 1;//return playerChoice[2] = 0-4;
        player.setWeapon(choice);
    }

    public void result() {
        System.out.println("<<============Result==========>>");
        ink.intialStats(playerName,playerChoice[0],playerChoice[1], playerChoice[2] ,player, player.armor(), player.weapon());
    }

    public void generateBot() {
        System.out.println(""); //flush
        setup.loading(2000, "Bot generating...");
        ink.deleteLine(1);
        System.out.println("");
        botChoice[0] = randNum.nextInt(ink.listCharacter.length);
        botChoice[1] = randNum.nextInt(ink.listArmor.length);
        botChoice[2] = randNum.nextInt(ink.listWeapon.length);
        autobot = setup.createWarrior(botChoice[0]);
        autobot.setArmor(botChoice[1]+1);
        autobot.setWeapon(botChoice[2]+1);

        ink.intialStats("Autobot",botChoice[0], botChoice[1], botChoice[2], autobot, autobot.armor(), autobot.weapon());
    }

    public void save() {
        this.savedPlayer = player;
        this.savedBot = autobot;
        this.savedName = playerName;

        ink.saveGame();
    }
} //class
