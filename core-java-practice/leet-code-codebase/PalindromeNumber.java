// LC9 : Palindrome Number

import java.util.*;

class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String num = Integer.toString(x);
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            if (num.charAt(left) == num.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Check Palindrome number? X = ");
		int x = sc.nextInt();
		if (isPalindrome(x)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not a Palindrome");
		}
	}
}