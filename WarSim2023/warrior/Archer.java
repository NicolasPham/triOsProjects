package warrior;

public class Archer extends Warrior {
    private int minHealth = 450;
    private int maxHealth = 650;
    private int defend = 80;
    private int damage = 160;
    private int staminia = 70;
    private int speed = 120;
    private String ability = "Fireball";


    public Archer() {
        super();
        super.setHealth(super.randNum.nextInt(minHealth, maxHealth));
        super.setDamage(damage);
        super.setDefend(defend);
        super.setStaminia(staminia);
        super.setSpeed(speed);
        super.setAbility(ability);
    }
}
