package Main;

import java.util.Scanner;

public class program2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("How many gallons of gas do you have?: ");
        //this is telling the program the amount of gas the person already has.
        double gas = scan.nextDouble();
        System.out.println("What is the starting distance your going?: ");
        //this is telling the computer what was the starting distance of the trip.
        int start = scan.nextInt();
        System.out.println("What is you ending distance?: ");
        //this is telling the computer the ending distance of the trip.
        int end = scan.nextInt();

        int total = start + end;

        double mpg = total / gas;

        System.out.println("Your mpg is: " + mpg + "!");
    }
}

