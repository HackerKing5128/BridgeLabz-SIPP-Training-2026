class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // if last digit is not 9
        if (digits[n-1] != 9) {
            digits[n-1] += 1;
            return digits;
        }
		
        // if last digit is 9
        digits[n-1] = 0; // set last digit to zero
        for (int i=n-2; i>=0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits; // return the result if no new array required
            } else {
                digits[i] = 0;
            }
        }

        // new array required if code execution reach this point
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}