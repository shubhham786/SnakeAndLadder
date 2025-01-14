import java.util.Random;

public class Dice {

    int countOfDice;

    private int MIN_VALUE=1;
    private int MAX_VALUE=6;

    public Dice(int countOfDice, int MIN_VALUE, int MAX_VALUE) {
        this.countOfDice = countOfDice;
        this.MIN_VALUE = MIN_VALUE;
        this.MAX_VALUE = MAX_VALUE;
    }

    public Dice(int countOfDice) {
        this.countOfDice = countOfDice;
    }

    public int rollDice() {

            int finalLocation=0;

             int count=1;

              while(count<=countOfDice)
              {
                  Random rand = new Random();
                   int roll=rand.nextInt((MAX_VALUE-MIN_VALUE)+1)+MIN_VALUE;
                   finalLocation+=roll;
                   count++;
              }
              return finalLocation;
    }
}
