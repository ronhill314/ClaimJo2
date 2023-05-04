package WeekTwo;

public class Lab4 {

    public static void main(String[] args) {

        // sumLimit(8, 3);
        // squirrelPlay(95, true);
        // lotteryTicket(2,2,2);
        // countXX("xxx");
        stringersCount("hi", 3);

    }

    public static int sumLimit(int a, int b) {

        int sum = a + b;

        int aLength = String.valueOf(a).length();
        int sumLength = String.valueOf(sum).length();

        if (sumLength == aLength) {
            System.out.println(sum);
            return sum;
        } else {
            System.out.println(a);
            return a;
        }

    }

    public static boolean squirrelPlay(int temp, boolean summer) {

        if (summer || 60 <= temp && temp <= 90) {
            System.out.println("The Squirrels Play");

            return true;
        }
        if (summer && 60 <= temp && temp <= 100) {
            System.out.println("The Squirrels Play");

            return true;
        } else {
            System.out.println("The Don't Squirrels Play");
            return false;
        }

    }

    public static void lotteryTicket(int a, int b, int c) {

        if (a == b && b == c) {
            System.out.println("The result is 20");
        } else if (a != b && b != c && a != c) {
            System.out.println("The result is 0");
        } else {
            System.out.println("The result is 10");
        }

    }

    public static void countXX(String givenString) {

        char trackingLetter = 'x';
        char[] chararrayString = givenString.toCharArray();

        int count = 0;

        for (int i = 0; i < givenString.length(); i++) {

            if (chararrayString[i] == 'x' && chararrayString[i] == trackingLetter) {
                count++;

            }
        }

        System.out.println(count);

    }

    public static String stringersCount(String str, int r) {

        String s = "";

        for (int i = 0; i < r; i++) {
            s = s + str;
            
        }

        System.out.println(s);
        
        return s;

        

    }
    

}
