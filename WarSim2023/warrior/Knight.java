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
    } //constructor

    @Override
    public void specialSkill() {
        this.costSkill = 10;
        int amount = 60;
        
        buffAmount = amount;
        roundBuff = 2;

        super.setDefend(super.getDefend() + amount);
        super.setStaminia(super.getStaminia()-costSkill);
    }

    @Override
    public void removeBuff() {
        super.setDefend((super.getDefend() - buffAmount));
        System.out.println("You have no more buff");
        roundBuff = 0;
    }


}//clas
