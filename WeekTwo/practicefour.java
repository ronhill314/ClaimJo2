package WeekTwo;

public class practicefour {

    public static void main(String[] args) {
        
    }

    public int[] twoSum(int[] nums, int target) {

        int iIndex = 0;
        int jIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i+1;j < nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    iIndex = i;
                    jIndex = j;
                }
                
            }
            
        }

        int[] ans = new int []{iIndex, jIndex};
        return ans;


    }


 }
    

