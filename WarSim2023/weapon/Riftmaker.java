package weapon;

public class Riftmaker extends Weapon {
    private int[] weapon = {damage[4], speed[4], defend[4]}; //[damage, speed, defend]

    public Riftmaker() {
        super();
        super.setWeapon(weapon);
    }
}
