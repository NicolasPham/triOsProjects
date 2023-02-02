package warrior;

public class Assasin extends Warrior {
    private int minHealth = 400;
    private int maxHealth = 500;
    private int defend = 100;
    private int damage = 160;
    private int staminia = 70;
    private int speed = 100;
    private String ability = "Critical Strike";


    public Assasin() {
        super();
        super.setHealth(super.randNum.nextInt(minHealth, maxHealth));
        super.setDamage(damage);
        super.setDefend(defend);
        super.setStaminia(staminia);
        super.setSpeed(speed);
        super.setAbility(ability);
    }
}
