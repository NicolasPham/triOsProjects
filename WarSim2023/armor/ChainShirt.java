package armor;

public class ChainShirt extends Armor {

    private int[] armor = {defend[1], speed[1]};

    public ChainShirt() {
        super();
        super.setArmor(armor);
    }
}
