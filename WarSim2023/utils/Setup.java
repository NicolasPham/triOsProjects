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
    private int speedFactor;
    private int hitChance;
    private int cost;
    private int gain;
    
    private int[] strikeResult = {0, 0, 0}; //[total damage, staminia cost, staminia gain]


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

    public int[] strike(int choice, Warrior striker ,Warrior receiver) {
        int totalDamage = 0;
        gain = 0;
        cost = 0;
        if (choice == 1) { //* basic attack
            luck = randNum.nextInt(100); 
        } else if (choice == 2) { //* */ swing attack
            cost = 7; //cost 7 staminia for swing attack
            luck = randNum.nextInt(60);
            addtionalDamage += randNum.nextInt(30) + 20;
        } else {//! special skill
            luck = 100;
        }

        speedDiff = striker.getSpeed() - receiver.getSpeed();
        if (speedDiff > 0) {
            speedFactor = randNum.nextInt(speedDiff);
            luck += speedFactor;
            addtionalDamage += speedFactor;
        };
        
        //? decide:
        if (luck <= 40) {
            totalDamage = 0;
        } else if (luck > 40 && luck <= 80) {
            totalDamage += striker.getDamage() + addtionalDamage;
        } else {
            addtionalDamage += 20;
            totalDamage += striker.getDamage() + addtionalDamage;
        }

        if(totalDamage > receiver.getDefend()) totalDamage -= receiver.getDefend();
        
        if (totalDamage > 0) gain = 5;
        
        //add to strike result
        strikeResult[0] = totalDamage;
        strikeResult[1] = cost;
        strikeResult[2] = gain;
        
        
        addtionalDamage = 0;
        return strikeResult;
    }
}
