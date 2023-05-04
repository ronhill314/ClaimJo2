package WeekTwo;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice5 {

    public static void main(String[] args) {
        
        int[] intArr = new int[10];

        //nonprimitive array 
        ArrayList<Integer> intList = new ArrayList<Integer>();

        int num = intArr[5];

        // size works the same way as length
        // get method gets you the index at an int
        int num2 = intList.get(5);
        int length = intList.size();
        //can be added to and remoced from dynamically
        intList.add(null);
        intList.remove(2);
    }
    
}
