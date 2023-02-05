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
    private boolean strikeValid;
    public int botChoice;
    
    private int totalDamage;
    


    public Attack() {

    }   

    private void strikeValidation(int staminia, int cost) {
        if (staminia >= cost) strikeValid = true;
        else {
            strikeValid = false;
        };
    }
    
    public int strike(int choice, Warrior striker ,Warrior receiver) {
        totalDamage = 0;
        gain = 0;
        cost = 0;

        if (choice == 1) { //* basic attack
            luck = randNum.nextInt(100); 

        } else if (choice == 2) { //* */ swing attack
            cost = 3; //cost 3 staminia for swing attack
            strikeValidation(striker.getStaminia(), cost);

            if (!strikeValid) {
                System.out.println("You cannot perform this action");
            } else {
                luck = randNum.nextInt(60);
                addtionalDamage += randNum.nextInt(30) + 20;
                striker.staminiaUpdate(cost,0);
            }
            

        } else if (choice == 3) {//! special skill, 100% will hit
            strikeValidation(striker.getStaminia(), striker.costSkill);
            if (striker.isBuff || !strikeValid) {
                System.out.println("Not allowed, you perform the regular attack");
                striker.isBuff = false;
            } else {
                luck = randNum.nextInt(50) + 50; //bound from 50 - 100%
                striker.specialSkill();
                striker.isBuff = true;
                striker.staminiaUpdate(striker.costSkill, 0);
            }
        } //if statement

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
        
        if (totalDamage > 0) {
            gain = 5;
            receiver.staminiaUpdate(0,gain);
        }
        
        
        //add to strike result

        
        if (striker.isBuff) {
            if (striker.roundBuff > 1) {
                striker.roundBuff -= 1;
            } else {
                striker.removeBuff();
                striker.isBuff = false;
            }
        }

        addtionalDamage = 0;
        return totalDamage;
    }// striker


    public int botChoose(Warrior bot) {
        int botStaminia = bot.getStaminia();
        int skillRandom = randNum.nextInt(100);
        int SwingRandom = randNum.nextInt(100);

        if (botStaminia > bot.costSkill && skillRandom > 50 && !bot.isBuff) {
            botChoice = 3;
            System.out.println("Bot cast skill");
        }  else if (botStaminia > 3l && SwingRandom > 50) {
            botChoice = 2;
        } else botChoice = 1;

        return botChoice;
    }//botchoice
}
