package warrior;

public class Priest extends Warrior{

    private int minHealth = 550;
    private int maxHealth = 650;
    private int defend = 45;
    private int damage = 50;
    private int staminia = 30;
    private int speed = 60;
    private String ability = "Heal";


    public Priest() {
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
        this.costSkill = 10;
        int amount = 90;
        
        buffAmount = amount;
        roundBuff = 2;

        super.setHealth(super.getHealth() + amount);
        super.setStaminia(super.getStaminia()-costSkill);
    }

    @Override
    public void removeBuff() {
        //nothing happen here
    }
}
