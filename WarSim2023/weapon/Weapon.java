package weapon;

public class Weapon {
    public String[] listWeapon = {"Axe", "Sword", "Bow", "Dagger", "Riftmaker"}; //{0, 1, 2, 3, 4}
    public int[] damage = {70, 40, 90, 25, 90};
    public int[] speed = {-20, 20, 30, 50, -20};
    public int[] defend = {20, 40, -10, -10, -20};

    private int[] weapon;

    public int[] getWeapon() {
        return this.weapon;
    }

    public void setWeapon(int[] weapon) {
        this.weapon = weapon;
    }
    
}
