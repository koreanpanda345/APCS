package Main;

import java.util.Scanner;

public class program4 {
    public static void main(String[] args){
        int sum = 0, value, count = 0;
        double average;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer(0 to quit)");
        value = scan.nextInt();
        while(value != 0){
            count++;
            sum += value;
            System.out.println("The sum so far is " + sum );

            System.out.print("Enter an integer (0 to quite)");
            value = scan.nextInt();
        }
    }
}
