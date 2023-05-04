package WeekTwo;

public class PracticeTwo {

    
public static boolean main(String[] args) {
    
       
        
        

    }

    public static boolean findPalindrome(String inputString) {
        String palindrome = inputString;
        String reverseString = " ";

        for(int i = palindrome.length()-1; i >= 0; i--) {

            reverseString = reverseString.concat(Character.toString(inputString.charAt(i)));

        }
        
        if (reverseString.equals(inputString)) {
            System.out.println("It is a Palidrome");
            return false;
        }
    }
    
}
