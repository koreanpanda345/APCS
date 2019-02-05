package Main.Chapter4;

public class BoxCar {
    public static void main(String[] args){
        final int ROLLS = 1000;
        int boxCars = 0, num1, num2;
        PairOfDice die1 = new PairOfDice();
        PairOfDice die2 = new PairOfDice();
        for(int roll = 1; roll <= ROLLS;++roll) {
            num1 = die1.roll();
            num2 = die2.roll();

            if (num1 == 6 && num2 == 6)
                ++boxCars;
        }
            System.out.println("Number of rolls: " + ROLLS);
            System.out.println("Number of Box Cars: " + boxCars);
            System.out.println("Ratio: " + (double)boxCars/ROLLS);

    }
}
