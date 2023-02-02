package weapon;

public class Sword extends Weapon {
    private int[] weapon = {damage[1], speed[1], defend[1]}; //[damage, speed, defend]

    public Sword() {
        super();
        super.setWeapon(weapon);
    }
}
