package utils;
import warrior.*;


public class Setup {

    private Warrior warrior;


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

    
}
