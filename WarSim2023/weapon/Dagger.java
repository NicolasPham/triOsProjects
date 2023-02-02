package weapon;

public class Dagger extends Weapon {
    private int[] weapon = {damage[3], speed[3], defend[3]}; //[damage, speed, defend]

    public Dagger() {
        super();
        super.setWeapon(weapon);
    }
}
