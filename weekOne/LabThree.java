package weekOne;


public class LabThree {
    
    public static void main(String[] args) {
        
        String aPhrase = "Pickle Pepper Piper";

        char givenChar = 'p';


        // remove(aPhrase, givenChar);
        // letterCount(aPhrase);
        repeatLetters();
    }




    public static char[] remove(String str, char p) {

        char[] StringArrayOfPhrase;
        StringArrayOfPhrase = str.toCharArray();

        for (int i = 0; i < StringArrayOfPhrase.length; i++) {
            if(p == StringArrayOfPhrase[i]) {
                StringArrayOfPhrase[i] = ' ';
            }
        }
        System.out.println(StringArrayOfPhrase);
        return StringArrayOfPhrase;
        
    
    }

    public static void letterCount(String counter) {

        String momYelling = ("peter come home");

        int vowelsCount = 0;
        int contstantsCount= 0;

        for (int i = 0; i < momYelling.length(); i++) {
            if(momYelling.charAt(i) == 'a' || momYelling.charAt(i) == 'e' || momYelling.charAt(i) == 'i' || momYelling.charAt(i) == 'o' || momYelling.charAt(i) == 'u'){
                vowelsCount++;
            }
            else if(momYelling.charAt(i) >= 'a' && momYelling.charAt(i)<='z') {
                contstantsCount++;
            }

        }
            System.out.println("Number of vowels: " + vowelsCount);    
            System.out.println("Number of consonants: " + contstantsCount);  
            
        }

        public static void repeatLetters(){

            String inputLetters = "pooper stoop dave";
            int counter = 0;

            for(char i :inputLetters.toCharArray()) {
                if(inputLetters.indexOf(i) == inputLetters.lastIndexOf(i)) {
                    System.out.println("Fist nonrepeated Letter: " +i);
                    break;
                }
            char[] inputter = inputLetters.toCharArray();
            System.out.println("Duplicate letters are: " );
            for(int r = 0; r < inputLetters.length(); r++) {
              for(int j = r + 1; j<inputLetters.length(); j++) {
                if (inputter[r] == inputter[j]) {
                    System.out.println(inputter[j] + ",");
                    counter++;
                    break;
                }
              }  
            }

            }

            }
        }




