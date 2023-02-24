package weekOne.LabOne;

import java.util.Scanner;

public class Triangle {
    
    public static void main(String[] args) {
        
        Scanner scr = new Scanner(System.in);

        System.out.println("Enter the base: ");
        int base = scr.nextInt();
        System.out.println("Enter the width: ");
        int width = scr.nextInt();

        double area = .5 * (base * width);

        System.out.println("Area of Triangle: " + area);



    }
    
}
