package armor;

public class Leather extends Armor {
    private int[] armor = {defend[0], speed[0]};

    public Leather() {
        super();
        super.setArmor(armor);
    }
}
