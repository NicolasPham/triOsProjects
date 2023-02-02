package armor;

public class Armor {
    
    private int[] armor; //[defend, speed]
    public String[] listArmor = {"Leather" ,"ChainShirt", "BreastPlate"};
    public int[] defend = {40, 60, 80};
    public int[] speed = {40, 20, 0};

    public Armor() {
    }

    //getter
    public int[] getArmor() {
        return this.armor;
    }

    //setter
    protected void setArmor(int[] armor) {
        this.armor = armor;
    }
}
