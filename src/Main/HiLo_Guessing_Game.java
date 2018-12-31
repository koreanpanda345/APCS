package Main;

import java.util.Random;
import java.util.Scanner;

public class HiLo_Guessing_Game {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
        System.out.println("Welcome to the game of Hi-Lo guessing game. The rules are simply. try and guess my number. thats it, easy right? Well lets make it a challenge. I will give you 5 lives. Now is it easy?");
        System.out.println("Are you ready?(0 = y/ 1 = n): ");
        int ready = scan.nextInt();
        if(ready == 0){
            int answer = generator.nextInt(100) + 1;
            System.out.println("What is your first guess?(1 to 100)(0 to quit): ");
            int guess = scan.nextInt();
            while(guess != 0){
                if(guess > answer){
                    System.out.println("High");
                    System.out.println("What is your next guess?(1 to 100)(0 to quit): ");
                    guess = scan.nextInt();
                } else if(guess < answer){
                    System.out.println("Low");
                    System.out.println("What is your next guess?(1 to 100)(0 to quit): ");
                    guess = scan.nextInt();
                }else if(guess == answer){
                    System.out.println("You got it.Answer was " + answer);
                    System.out.println("Enter 0 to exit");
                    guess = scan.nextInt();

                }
            }
        }
    }
}
