class ReverseInteger {
    public int reverse(int x) {
        int rev = 0; // Reversed number

        while (x != 0) {
            int ld = x % 10; // Last digit extraction

            // Correct overflow check before updating rev
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && ld > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && ld < -8))
                return 0;

            rev = rev * 10 + ld; // Append last digit
            x /= 10; // Remove last digit
        }

        return rev;
    }
}