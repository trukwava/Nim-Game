/*****************************************
 * Solutions to Big Java P6.6:  Nim game
 * 
 * @author Carol Jung (sj2674)

 ****************************************/ 

public class Game {
    
    private int marbles;
    private Human humanPlayer;
    private Computer computerPlayer;
    
    
    public Game(int difficulty) {
        marbles = (int) ((Math.random() * 91) + 10);
        humanPlayer = new Human();
        computerPlayer = new Computer(difficulty);
    }
     
    public void play() {
        // Determine who plays first
        // 0 for human's turn, 1 for computer's turn
        int turn = Math.round((float) Math.random());

        // Play rounds until marbles run out
        while (marbles > 0) {
            playRound(turn);
            turn = Math.abs(turn - 1);
        }

        // Display the game winner
        if (turn == 0) {
            System.out.println("\nYou win the game!!!");
        } else {
            System.out.println("\nComputer wins the game.");
        }
    }

    private void playRound(int turn) {
        System.out.printf("There are currently %d marbles.\n", marbles);

        if (turn == 0) {
            System.out.println("\n******** YOUR TURN ********");
            humanPlayer.move();

            // Make sure human takes valid number of marbles
            int maxMarbles = marbles == 1 ? 1 : marbles / 2;
            while (humanPlayer.getChoice() < 1 || 
                humanPlayer.getChoice() > maxMarbles) {
                System.out.printf("You must take at least one marble " + 
                    "and at most %d marbles!\n", maxMarbles);
                humanPlayer.move();
            }

            marbles -= humanPlayer.getChoice();

        } else {
            System.out.println("\n***** COMPUTER'S TURN *****");
            computerPlayer.move(marbles);
            marbles -= computerPlayer.getChoice();
        }
    }

}