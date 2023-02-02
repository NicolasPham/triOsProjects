package warrior;

public class Witcher extends Warrior {
    private int minHealth = 900;
    private int maxHealth = 1100;
    private int defend = 60;
    private int damage = 120;
    private int staminia = 10;
    private int speed = 60;
    private String ability = "Poisoned Gas";


    public Witcher() {
        super();
        super.setHealth(super.randNum.nextInt(minHealth, maxHealth));
        super.setDamage(damage);
        super.setDefend(defend);
        super.setStaminia(staminia);
        super.setSpeed(speed);
        super.setAbility(ability);
    }
}
