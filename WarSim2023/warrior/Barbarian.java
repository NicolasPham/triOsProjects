package warrior;

public class Barbarian extends Warrior {
    private int minHealth = 900;
    private int maxHealth = 1100;
    private int defend = 85;
    private int damage = 65;
    private int staminia = 10;
    private int speed = 20;
    private String ability = "Smash";


    public Barbarian() {
        super();
        super.setHealth(super.randNum.nextInt(minHealth, maxHealth));
        super.setDamage(damage);
        super.setDefend(defend);
        super.setStaminia(staminia);
        super.setSpeed(speed);
        super.setAbility(ability);
    }
}
