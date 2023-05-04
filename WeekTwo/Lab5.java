package WeekTwo;

import java.util.Arrays;

public class Lab5 {

    public static void main(String[] args) {
        
        // count("alpha");
        // whiteSpaces("P o w e r");
        findDuplicates("anaconda");
        // reverseWord("How are you");
        

    } 
    
    public static void count (String a) {


        int numberOfA = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == 'a')
                numberOfA++;
            
            }
            System.out.println("Number of a's: " + numberOfA);

        }

    public static void whiteSpaces (String r){

        char[] charArray = r.toCharArray();
        char[] copy = new char[charArray.length];
        int counter = 0;

        for(char c : charArray) {
            if (c != ' ')
            copy[counter] = c;
            counter++;
        }

        char[] result = Arrays.copyOf(copy, counter);
        System.out.println(new String(result));
    }

    public static void findDuplicates( String f){

        String dupeIndexes = "";
        boolean first = true;

        for (int i = 0; i < f.length()-1; i++) {
            for (int j = i+1; j < f.length(); j++) {
                if(dupeIndexes.contains(Integer.toString(i))){
                    break;
                }
                if(f.charAt(i) == f.charAt(j)){
                    if(first) {
                        first=false;
                        dupeIndexes = dupeIndexes.concat(Integer.toString(i));
                    }
                    dupeIndexes = dupeIndexes.concat(Integer.toString(j));
                }
                
            }
            first=true;
            
        }

        char[] newWord = new char[f.length()];
        for (int i = 0; i < f.length(); i++) {
            if(!dupeIndexes.contains(Integer.toString(i))){
                newWord[i] = f.charAt(i);
            }
            
        }

        System.out.println(newWord);

    }


    public static void reverseWord (String solo){

        String[] strArr = solo.split(" ", 0);

        String reverse = "";

        for (int i = 0; i < strArr.length; i++) {
            
            reverse = strArr[i] + " " + reverse;
            
        }
        System.out.println(reverse);

    }
            

}


