package weapon;

public class Bow extends Weapon {
    private int[] weapon = {damage[2], speed[2], defend[2]}; //[damage, speed, defend]

    public Bow() {
        super();
        super.setWeapon(weapon);
    }
}
