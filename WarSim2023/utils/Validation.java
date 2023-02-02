package utils;
import java.util.Scanner;

public class Validation {

    private Scanner input = new Scanner(System.in);
    private ConsoleColor color = new ConsoleColor();
    private Printer ink = new Printer();


    private boolean isValid = false;

    public int choice;
    
    public Validation() {

    }

    public int warrior() {
        while (!isValid) {
            ink.characterOptions();
            choice = input.nextInt();
            try {
                if (choice >=1 && choice <=3) isValid = true;
            } catch (Exception e) {
                isValid = false;
            }
        }
        isValid = false;
        return choice;
    } // warriror Validation

    public int valid(int bottom, int top) {
        while (!isValid) {
            choice = input.nextInt();
            try {
                if (choice >=bottom && choice <= top) isValid = true;
                else System.out.println(color.RED + "NOT A CORRECT SELECTION, PLEASE CHOOSE AGAIN" + color.RESET);
            } catch (Exception e) {
                isValid = false;
            }
        }
        isValid = false;
        return choice;
    } //classVal

}//class
