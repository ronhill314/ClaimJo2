package WeekTwo;

public class Practicetwothree {

    public static void main(String[] args) {
        
        // write a java program to find the second element in an int array.

        findSecondLargestNumbah(new int[] {1,322,453,34,12,54,2,1,3344,1});

    }

    public static void findSecondLargestNumbah(int[] numbahs) {

        // Array.sort(numbahs);
        //for (int i = 0; i < numbahs.length; i++) {
         //   System.out.println(numbahs+1);
            
        //}

        // compare the numbers in the array
        // find the largest
        // take the largest number again
        // find the largest number again

        int greatestNumbahIndex = 0;
        int greatestNumbah = numbahs[0];
        int secondGreatest = numbahs[0];

        for (int i = 0; i < numbahs.length; i++) {
                if(greatestNumbah < numbahs[i]) {
                    greatestNumbahIndex = i;
                    greatestNumbah = numbahs[i];
                }


            }
            
            numbahs[greatestNumbahIndex]= 0;

            
        for (int i = 0; i < numbahs.length; i++) {

            if(secondGreatest < numbahs[i]) {
                secondGreatest = numbahs[i];

        }

        System.out.println(secondGreatest);

    }
    
}

}
