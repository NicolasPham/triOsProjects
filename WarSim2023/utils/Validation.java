package utils;
import java.util.Scanner;
public class Validation {
    private ConsoleColor color = new ConsoleColor();
    private Scanner input = new Scanner(System.in);

    private boolean isValid = false;

    public int choice;
    
    public Validation() {

    }

    public int checkValid(int bottom, int top) {
        while (!isValid) {
            choice = input.nextInt();
            try {
                if (choice >=bottom && choice <= top) isValid = true;
                else {
                    isValid = false;
                    System.out.println(color.RED + "NOT A CORRECT SELECTION, PLEASE CHOOSE AGAIN" + color.RESET);
                }
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }
        isValid = false;

        return choice;
    } //classVal

}//class
