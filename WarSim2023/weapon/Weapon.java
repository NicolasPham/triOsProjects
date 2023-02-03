package weapon;

public class Weapon {
    public String[] listWeapon = {"Axe", "Sword", "Bow", "Dagger", "Riftmaker"}; //{0, 1, 2, 3, 4}
    public int[] damage = {100, 85, 105, 70, 120};
    public int[] speed = {-20, 10, 15, 40, 0};
    public int[] defend = {20, 5, -20, -10, -20};

    private int[] weapon; //[damge, speed, defend]

    public int[] getWeapon() {
        return this.weapon;
    }

    public void setWeapon(int[] weapon) {
        this.weapon = weapon;
    }
    
}
