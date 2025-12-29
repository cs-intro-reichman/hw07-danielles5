/** Checks if a given string is a palindrome. */
public class Palindrome {

	public static void main(String[]args) {
    	System.out.println(isPalindrome(args[0]));
    }
	
	/** Checks if the given string is a palindrome. */
	public static boolean isPalindrome(String s) {
		String lowerS = s.toLowerCase();

		// if the String is one letter or less, automatically a palindrome
		if (s.length() <= 1) {
			return true;
		}

		// if the first letter isn't the same as the last one, automatically not a palindrome
		if (lowerS.charAt(0) != lowerS.charAt(s.length() - 1)) {
			return false;
		}

		return isPalindrome(s.substring(1, s.length() - 1));
    }
}