package warrior;
import java.util.Random;
import weapon.*;
import armor.*;

public class Warrior {

    protected Random randNum = new Random();
    private int health;
    private int defend;
    private int damage;
    private int staminia;
    private int speed;
    private String ability;

    // Composition
    private Weapon weapon;


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

    
}
