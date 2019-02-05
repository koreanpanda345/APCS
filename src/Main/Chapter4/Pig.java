package Main.Chapter4;

import java.util.Random;
import java.util.Scanner;

/**
 * This program is called Pig, its a luck base game, where you try to get to 100 points. if you roll one 1,
 * you lose the points from that round, if your roll two 1s(Snake Eyes) you lose all of your points.
 */

public class Pig {
    public static void main(String[] args){
        int num1, num2, num3, num4;

        final int score = 100;
        int playerScore = 0;
        int computerScore = 0;

        int computerOptions = 2;

        boolean playerTurn, computerTurn;

        String whosTurn;
        Random generator = new Random();

        PairOfDice die1 = new PairOfDice();
        PairOfDice die2 = new PairOfDice();

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the game of Pig, Ready to Start: ");
        String ready = scan.nextLine();
        while(ready.equalsIgnoreCase("y")){
            Turn(true,false);
            System.out.println("Your Turn.");
            System.out.println("Would you like to roll or pass the dice to the next player?");
            String action = scan.nextLine();
            while (action.equalsIgnoreCase("roll") || !(action.equalsIgnoreCase("TurnOver")) ||!(playerScore == 100 || computerScore == 100)) {
                num1 = die1.roll();
                System.out.println(num1);
                num2 = die2.roll();
                System.out.println(num2);
                if(num1 == 1 || num2 == 1){
                    System.out.println("You rolled a one, you lost the points for this round.");
                    System.out.println("Your Score: " + playerScore);
                    System.out.println("Other Player Score: " + computerScore);
                    System.out.println("Other Players Turn");
                    action = "TurnOver";
                }
                else if(num1 == 1 && num2 == 1){
                    System.out.println("You rolled Snake Eyes, you lost all your points.");
                    playerScore = 0;
                    System.out.println("Your Score: " + playerScore);
                    System.out.println("Other Player Score: " + computerScore);
                    System.out.println("Other Players Turn");
                    action = "TurnOver";
                }
                else if(!(num1 == 1 || num2 == 1) || !(action.equalsIgnoreCase("TurnOver"))) {
                    playerScore += num1 + num2;
                    computerScore = 0;
                    System.out.println("Your Score: " + playerScore);
                    System.out.println("Other Player Score: " + computerScore);
                    System.out.println("Would you like to be a pig and roll again, or do you want to pass the dice to the other player?");
                    action = scan.nextLine();

                    }
                }
                if (action.equalsIgnoreCase("pass")) {
                    action = "TurnOver";
                    System.out.println("You ended your turn");
                    System.out.println("Other Players Turn");

                }
                if(action.equalsIgnoreCase("TurnOver")){
                        Turn(false, true);
                    }
                    if(action.equalsIgnoreCase("roll")){
                        Turn(true, false);
                    }

            }

        }
    public static String Turn(boolean playerTurn, boolean computerTurn){
        String whosTurn;
        if(!playerTurn){
            whosTurn = "computer";
        }
        if(!computerTurn){
            whosTurn = "player";
        }
        else whosTurn = "";
        return whosTurn;
    }
}
