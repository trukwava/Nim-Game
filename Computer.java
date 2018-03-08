/*****************************************
 * Solutions to Big Java P6.6: Computer player
 * 
 * @author Carol Jung (sj2674)

 ****************************************/ 

public class Computer {
    
    private int mode; // 1 = stupid, 2 = smart
    private int choice;
    
    public Computer(int m) {
        mode = m;
        choice = -1;
    }
    
    public void move(int marblesLeft) { 
        // If stupid mode, or number of marbles plus one is a power of 2, 
        // pick a random number in [1, n/2]
        if (mode == 1 || isPowerOf2(marblesLeft + 1)) {
            choice = (int) ((Math.random() * (marblesLeft / 2)) + 1);

        } else {
            // Else calculate the difference between marblesLeft
            // and closest power of two minus one.

            // Exponent that yields the closest power of two
            int exp = (int) (Math.log(marblesLeft) / Math.log(2));
            choice = marblesLeft - ((int) Math.pow(2, exp) - 1);
        }

        System.out.printf("The computer took %d marble(s).\n", choice);
    }

    public int getChoice() {
        return choice;
    }

    private boolean isPowerOf2(int n) {
        /* Powers of 2 has only one bit of 1, and the rest are 0's.
        To check this characteristic, we can bitwise-AND the right-hand 
        complement of the given integer n, such that if n = 001000..., 
        then its right-hand complement is (n - 1) = 000111... .

        Since n and (n - 1) are complements, bitwise-AND should return 0
        if n is truly a power of 2. */
        return (n & (n - 1)) == 0;
    }
    
}
