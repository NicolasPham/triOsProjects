package weapon;

public class Axe extends Weapon {
    private int[] weapon = {damage[0], speed[0], defend[0]}; //[damage, speed, defend]

    public Axe() {
        super();
        super.setWeapon(weapon);
    }
}
