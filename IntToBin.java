/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("Binary representation of " + x + " is: " + toBinary(x));
    }

    /** Returns the binary representation of the given integer, as a string of 0's and 1's.  */
    public static String toBinary(int x) {
        // base cases: 1, 0 (both binary)
        if (x == 0) {
            return "0";
        }

        if (x == 1) {
            return "1";
        }

        // divide the int by 2 to remove the last binary digit 
        // add last binary digit (1 or 0) to the binary String
        return toBinary(x / 2) + (x % 2);
    }    
 }
