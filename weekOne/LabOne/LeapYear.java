package weekOne.LabOne;

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);

        System.out.println("What kind of year is it: (leapYear or regularYear)");

        int year = scr.nextInt();

        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
          System.out.println(year + " is a leap year.");}
        else {
          System.out.println(year + " is not a leap year.");
        }
    }

 }
