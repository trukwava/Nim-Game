/*****************************************
 * Solutions to Big Java P6.6: Human Nim player
 * 
 * @author Carol Jung (sj2674)

 ****************************************/ 
import java.util.Scanner;

public class Human {
   
    private int choice;
    private Scanner input;
    

    public Human() {
        input = new Scanner(System.in);
        choice = -1;
    }

    public void move() {
        System.out.print("How many marbles would you like to take? ");
        choice = input.nextInt();
    }
    
    public int getChoice() {
        return choice;
    }
    
}
