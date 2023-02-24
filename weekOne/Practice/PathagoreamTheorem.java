package weekOne.Practice;

import java.util.Scanner;

public class PathagoreamTheorem {

    public static void main(String[] args) {
        
        Scanner scr = new Scanner(System.in);

        System.out.print( "What is the a side: ");
        int a = scr.nextInt();
        System.out.print( "What is the b side: ");
        int b = scr.nextInt();

        double answer = pathagoreanTheorem(a, b);

        System.out.println(answer);
    }

    public static double pathagoreanTheorem(int a, int b) {

         double c = Math.sqrt((a*a) + (b*b));

         System.out.println(c);
        
        }
    
}
