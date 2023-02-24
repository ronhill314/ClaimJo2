package weekOne.Practice;

import java.util.Scanner;

public class EvenIndex {

    public static void main(String[] args) {
        
        System.out.println("What is the string");

        Scanner scr = new Scanner(System.in);

        String myString = scr.nextLine();
        
        // reverseString(myString);
        // evenCharacter(myString);
        palindrome(myString);

    }

    public static void palindrome(String myString){
        // print word, print it backwards, see if they are equal
        if(myString.equals(reverseString(myString))) {
            System.out.println( "Its a palidrome");
        }
        else {
            System.out.println(" Its not a Palidrome");
        }


    }

    public static String reverseString(String myString) {

        String backwardsMyString = "";
        for(int i = myString.length() -1; i>=0; i--) {
            // add each lettter to backwardsMyString
            backwardsMyString = backwardsMyString.concat(
                Character.toString(myString.charAt(i))
            );

        }

        return backwardsMyString;

}
    public static void evenCharacter(String myString) {

        for(int i = 0; i < myString.length(); i+=2) {
            System.out.println(myString.charAt(i));
        }
    }
        
        
}
