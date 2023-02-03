package warrior;

public class Archer extends Warrior {
    private int minHealth = 450;
    private int maxHealth = 650;
    private int defend = 40;
    private int damage = 80;
    private int staminia = 70;
    private int speed = 70;
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
    @Override
    public void specialSkill() {
        int cost = 10;
        int amount = 60;
        
        buffAmount = amount;
        roundBuff = 2;

        super.setSpeed(super.getSpeed() + amount);
        super.setStaminia(super.getStaminia()-cost);
    }

    @Override
    public void removeBuff() {
        super.setSpeed((super.getSpeed() - buffAmount));
        System.out.println("You have no more buff");
    }
}
