package warrior;

public class Assasin extends Warrior {
    private int minHealth = 400;
    private int maxHealth = 500;
    private int defend = 50;
    private int damage = 80;
    private int staminia = 70;
    private int speed = 70;
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

    @Override
    public void specialSkill() {
        this.costSkill = 8;
        int amount = 70;
        
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
