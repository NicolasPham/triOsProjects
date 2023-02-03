package utils;
import java.util.Random;
import warrior.*;


public class Attack {
    
    private Random randNum = new Random();
    

    //strike affect:
    private int addtionalDamage;
    private int luck;
    private int speedDiff;
    private int speedFactor;
    private int cost;
    private int gain;
    
    private int[] strikeResult = {0, 0, 0}; //[total damage, staminia cost, staminia gain]


    public Attack() {

    }   
    
    public int[] strike(int choice, Warrior striker ,Warrior receiver) {
        int totalDamage = 0;
        gain = 0;
        cost = 0;
        if (choice == 1) { //* basic attack
            luck = randNum.nextInt(100); 
        } else if (choice == 2) { //* */ swing attack
            cost = 3; //cost 3 staminia for swing attack
            luck = randNum.nextInt(60);
            addtionalDamage += randNum.nextInt(30) + 20;
        } else {//! special skill, 100% will hit
            luck = 100;
            striker.specialSkill();
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
        strikeResult[1] = gain;
        strikeResult[2] = cost;
        
        
        addtionalDamage = 0;
        return strikeResult;
    }// striker


}
