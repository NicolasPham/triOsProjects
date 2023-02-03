package warrior;

public class Witcher extends Warrior {
    private int minHealth = 900;
    private int maxHealth = 1100;
    private int defend = 30;
    private int damage = 60;
    private int staminia = 10;
    private int speed = 40;
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
    @Override
    public void specialSkill() {
        int cost = 8;
        int amount = 30;
        
        buffAmount = amount;
        roundBuff = 6;

        super.setDamage(super.getDamage() + amount);
        super.setStaminia(super.getStaminia()-cost);
    }

    @Override
    public void removeBuff() {
        super.setDamage((super.getDamage() - buffAmount));
        System.out.println("You have no more buff");
    }
}
