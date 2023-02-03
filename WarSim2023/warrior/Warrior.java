package warrior;
import java.util.Random;
import weapon.*;
import armor.*;

public abstract class Warrior {

    protected Random randNum = new Random();
    private int health;
    private int defend;
    private int damage;
    private int staminia;
    private int speed;
    private String ability;

    protected int buffAmount;
    public int roundBuff;

    // Composition
    private Weapon weapon; //getWeapon return [damage, speed, defend]
    private Armor armor; //getArmor return [defend, speed]

    public Warrior() {

    }

     //getter:

    public int getHealth() {
        return this.health;
    }
    public int getDefend() {
        return this.defend;
    }
    public int getDamage() {
        return this.damage;
    }
    public int getStaminia() {
        return this.staminia;
    }
    public int getSpeed() {
        return this.speed;
    }
    public String getAbility() {
        return this.ability;
    }

    public Armor armor() {
        return this.armor;
    }
    public Weapon weapon() {
        return this.weapon;
    }

    //setter
    protected void setHealth(int health) {
        this.health = health;
    }
    protected void setDefend(int defend) {
        this.defend = defend;
    }
    protected void setDamage(int damage) {
        this.damage = damage;
    }
    protected void setStaminia(int staminia) {
        this.staminia = staminia;
    }
    protected void setSpeed(int speed) {
        this.speed = speed;
    }
    protected void setAbility(String ability) {
        this.ability = ability;
    }

    //polymorphic
    public void setArmor(int choice) {
        switch(choice) {
            case 1:
                armor = new Leather();
                break;
            case 2:
                armor = new ChainShirt();
                break;
            case 3:
                armor = new BreastPlate();
                break;
            default: {}
        }

    } //setArmor

    public void setWeapon(int choice) {
        switch(choice) {
            case 1:
                weapon = new Axe();
                break;
            case 2:
                weapon = new Sword();
                break;
            case 3:
                weapon = new Bow();
                break;
            case 4:
                weapon = new Dagger();
                break;
            case 5:
                weapon = new Riftmaker();
                break;
            default: {}
        }

    } //setWeapon


    public void setStatus() {
        this.damage += weapon.getWeapon()[0];
        this.speed += armor.getArmor()[1] + weapon.getWeapon()[1];
        this.defend += armor.getArmor()[0] + weapon.getWeapon()[2];
    }
    public void receiverUpdate(int damamge, int gain) {
        this.health -= damamge;
        this.staminia += gain;
    }
    public void strikerUpdate(int cost) {
        this.staminia -=cost;
    }

    public abstract void specialSkill();
    public abstract void removeBuff();
    
}
