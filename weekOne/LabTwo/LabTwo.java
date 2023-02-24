package weekOne.LabTwo;

import java.util.Scanner;

public class LabTwo {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);

        // System.out.println("Enter Num1 ");
        // int num1 = scr.nextInt();
        // System.out.println("Enter Num2 ");
        // int num2 = scr.nextInt();
        // System.out.println("Enter Num3 ");
        // int num3 = scr.nextInt();

        // Max3(num1, num2, num3);
        // Min3(num1, num2, num3);
        // Middle(num1, num2,num3);
        // Xor();
        // isFactor(num1, num2);
        //isPerfect();
        isPrime();


    }


    public static void Max3(int num1, int num2, int num3){
        if (num1 > num2 && num1 > num3){
            System.out.println("The largest number is " + num1);
        }
        else if (num2 > num1 && num2 > num3){
            System.out.println("The largest number is " + num2);
        }
        else {
            System.out.println("The largest number is " + num3);

        }

    }

    public static void Min3(int num1, int num2, int num3){
        if (num1 < num2 && num1 < num3){
            System.out.println("The smallest number is " + num1);
        }
        else if (num2 < num1 && num2 < num3){
            System.out.println("The smallest number is " + num2);
        }
        else {
            System.out.println("The smallest number is " + num3);

    }


        
    }

    public static void Middle(int num1, int num2, int num3){
        if ((num2 < num1 && num1 < num3) || (num3 < num1 && num1 < num3)){
        System.out.println("The middle number is: " + num1);
        }
        else if((num1 < num2 && num2 < num3) || (num3 < num2 && num2 < num1)) {
        System.out.println("The midle number is: " + num2);
        }
        else {
            System.out.println("The middle number is: " + num3);
        }

    }

    public static void Xor(){

        boolean num1 = false;
        boolean num2 = true;
        if (num1 == num2) {
        System.out.println("The statement False");
        }
        else {
        System.out.println("The statement is true");
        
    }

    }

    public static boolean isFactor(int num1, int num2){
        if (num1 % num2 == 0){
            System.out.println("It factors");

            return true;
        }
        else{
            System.out.println("It doesnt factor");
            
            return false;
        }
    }

    public static void isPerfect(){
        Scanner scr = new Scanner(System.in);
        int totalFactors = 0;
        int number = scr.nextInt();
        for (int i=1; i < number; i++) {
            if (isFactor(number, i)){
                totalFactors += i;
                }
        }

        if (totalFactors == number){
            System.out.println("Its a perfect number");
        }
        else {
            System.out.println("Its not");
        }
    }

    public static void isPrime(){
        Scanner scr = new Scanner (System.in);
        int totalPrime = 0;
        int obviouslyOdd = scr.nextInt();
        for (int i=2; i < obviouslyOdd; i++) {
            if (isFactor(i, obviouslyOdd)){
                totalPrime += i;
                }
        }

        if (totalPrime == obviouslyOdd){
            System.out.println("Its a prime number");
        }
        else {
            System.out.println("Its not");
        }

    }

    
}
