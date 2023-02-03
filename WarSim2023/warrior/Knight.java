package warrior;

public class Knight extends Warrior{

    private int minHealth = 800;
    private int maxHealth = 880;
    private int defend = 65;
    private int damage = 60;
    private int staminia = 30;
    private int speed = 60;
    private String ability = "Unbreakable";


    public Knight() {
        super();
        super.setHealth(super.randNum.nextInt(minHealth, maxHealth));
        super.setDamage(damage);
        super.setDefend(defend);
        super.setStaminia(staminia);
        super.setSpeed(speed);
        super.setAbility(ability);
    }
}
