package weekOne.LabOne;

import java.util.Scanner;

public class RoundNumber {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        
        System.out.println("Enter Number Value: ");
        double userNum = scr.nextDouble();

        int userRound = (int) Math.round(userNum);

        System.out.println("Your number is " + userNum +  " Your value is "  + userRound + ".");

    }
    
}
