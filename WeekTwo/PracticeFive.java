package WeekTwo;

public class PracticeFive {

    public static void main(String[] args) {


    }

    public int maxArea(int[] height) {

        // area of rectangle is Base x height
        // base is (greater index +1) - (smaller index + 1)
        // height is the numbers in the height array

        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {

            for (int j = i+1; j < height.length; j++) {
                int iHeight = height[i];
                int jHeight = height[j];
                int lowerHeight = 0;
                if(iHeight < jHeight) {
                    lowerHeight = iHeight;
                }else {
                    lowerHeight = jHeight;
                }

                // base = (j+1)-(i+1)
                // height = 
                if(((j+1) - (i+1) * (lowerHeight))> maxArea){

                    maxArea = (((j+1) - (i+1) * (lowerHeight)));
                }

                
            }

        }

    }
    
}
