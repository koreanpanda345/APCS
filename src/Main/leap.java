package Main;

import java.util.Scanner;

public class leap {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome. Please enter a year that you want to know if it's a leap year: ");
        int year = scan.nextInt();
        while(year < 1582){
            System.out.println("Please pick another year that is above 1582(Reason is the Gregorian Calendar was adopted in 1582)");
            System.out.println("Please enter a year that you want to know if it's a leap year: ");
            year = scan.nextInt();
        }if(year >= 1582){
            if(year % 400 == 0){
                System.out.println(year + " is a leap year.");
            }else{
                System.out.println(year + " isn't a leap year.");
            }
        }
    }
}
