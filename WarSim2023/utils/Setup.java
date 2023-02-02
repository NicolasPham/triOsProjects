package utils;
import warrior.*;
import armor.*;
import weapon.*;

public class Setup {

    
    
    private Warrior warrior;
    private Armor armor;
    private Weapon weapon;
    public Setup() {

    }

    public Warrior createWarrior(int characterChoice) {
        switch (characterChoice) {
            case 0:
                warrior = new Knight();
                break;
            case 1:
                warrior = new Priest();
                break;
            case 2:
                warrior = new Assasin();
                break;
            case 3:
                warrior = new Archer();
                break;
            case 4:
                warrior = new Barbarian();
                break;
            case 5:
                warrior = new Witcher();
                break;
            default: {}
        }
        return warrior;
    } // createWarrior()

    public Armor armorSelection(int choice) {
        switch(choice) {
            case 1:
                armor = new Leather();
                break;
            case 2:
                armor = new ChainShirt();
                break;
            case 3:
                armor = new BreastPlate();
                break;
            default: {}
        }
        return armor;
    }

    public Weapon weaponSelection(int choice) {
        switch(choice) {
            case 1:
                weapon = new Axe();
                break;
            case 2:
                weapon = new Sword();
                break;
            case 3:
                weapon = new Bow();
                break;
            case 4:
                weapon = new Dagger();
                break;
            case 5:
                weapon = new Riftmaker();
                break;
            default: {}

        }
        return weapon;
    }
}
