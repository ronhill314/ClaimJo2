package weekOne.LabOne;

import java.util.Scanner;

public class Circle {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);

        System.out.println("Enter Radius of Circle: ");
        int radius = scr.nextInt();
        
       double area = Math.PI * (2 * radius);
       double circumference = 2 * Math.PI * radius;
        
        System.out.println("Area of Circle : " + area);
        System.out.println("Circumference of Circle: " + circumference);
           }
        
       }