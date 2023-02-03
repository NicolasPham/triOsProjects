package utils;
import java.util.Random;
import warrior.*;
import armor.*;
import weapon.*;

public class Setup {

    private Random randNum = new Random();
    
    private Warrior warrior;

    //strike affect:
    private int addtionalDamage;
    private int luck;
    private int speedDiff;
    private int hitChance;
    private int cost;
    



    public Setup() {

    }

    public Warrior createWarrior(int characterChoice) {
        switch (characterChoice) {
            case 0:
                warrior = new Knight();
                break;
            case 1:
                warrior = new Priest();
                break;
            case 2:
                warrior = new Assasin();
                break;
            case 3:
                warrior = new Archer();
                break;
            case 4:
                warrior = new Barbarian();
                break;
            case 5:
                warrior = new Witcher();
                break;
            default: {}
        }
        return warrior;
    } // createWarrior()

    public int strike(int choice, Warrior striker ,Warrior receiver) {
        int totalDamage = 0;
        if (choice == 1) {
            luck = randNum.nextInt(50); //bound of 100%
        } else if (choice == 2) {
            cost = 7; //cost 7 staminia for swing attack
            luck = randNum.nextInt(25); //bound of 50%
            addtionalDamage += 30;
        } else {
            luck = 100;
        }

        speedDiff = striker.getSpeed() - receiver.getSpeed();
        hitChance = luck + speedDiff;
        
        if (hitChance <= 0) {
            totalDamage = 0;
        } else if (hitChance > 0 && hitChance <=50) {
            totalDamage += striker.getDamage() + addtionalDamage + hitChance;
        } else {
            addtionalDamage += 20;
            totalDamage += striker.getDamage() + addtionalDamage + hitChance;
        }


        addtionalDamage = 0;
        return totalDamage;
    }
}
