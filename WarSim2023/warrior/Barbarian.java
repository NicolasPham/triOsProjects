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

    @Override
    public void specialSkill() {
        this.costSkill = 5;
        int amount = 60;
        
        buffAmount = amount;
        roundBuff = 1;

        super.setDamage(super.getDamage() + amount);
        super.setStaminia(super.getStaminia()-costSkill);
    }

    @Override
    public void removeBuff() {
        super.setDamage((super.getDamage() - buffAmount));
        System.out.println("You have no more buff");
    }
}
