package GroupProjects;

import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {

        System.out.println("1 GhanaianCedi");
        System.out.println("2 SwissFranc");
        System.out.println("3 PhillipinePeso");
        
        Scanner scr = new Scanner(System.in);
            System.out.println("Chose the Currency");
            int choice = scr.nextInt();
            
            
            System.out.println("Enter Value of Currency (USD): ");
            
            double amount = scr.nextDouble();

            switch (choice) {

                case 1:
                    USD_to_GhanianCedi(amount);
                    break;
                case 2:
                    USD_to_SwissFranc(amount);
                    break;
                case 3:
                    USD_to_PhillipinePeso(amount);
                    break;
                    default:
                    System.out.println("choose from 1 to 3");

            }

        scr.close();


            
        }

    private static void USD_to_PhillipinePeso(double amount) {
        System.out.println("1 GhanianCedi = " + (amount*12.85));
    }

    private static void USD_to_SwissFranc(double amount) {
        System.out.println("2 SwissFranc = " + (amount*.93));
    }

    private static void USD_to_GhanianCedi(double amount) {
        System.out.println("3 PhillipinePeso = " + (amount*55.10));
    
    }



}
