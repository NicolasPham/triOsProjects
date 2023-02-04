package utils;
import warrior.*;
import java.lang.Thread;


public class Setup extends Thread {

    private Warrior warrior;


    public Setup() {

    }

    public void loading(int miliseconds, String message) {
        try {
            System.out.println(message);
            Thread.sleep(miliseconds);
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
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
