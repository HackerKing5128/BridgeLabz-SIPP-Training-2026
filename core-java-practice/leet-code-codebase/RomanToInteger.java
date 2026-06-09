class RomanToInteger {
    public int romanToInt(String s) {
        int sum  = 0;
        int[] roman = new int[128]; // ASCII : 0 to 127
        roman['I'] = 1;
        roman['V'] = 5;
        roman['X'] = 10;
        roman['L'] = 50;
        roman['C'] = 100;
        roman['D'] = 500;
        roman['M'] = 1000;

        // iterate the string and check the current and next character mappings
        for (int i = 1; i < s.length(); i++) {
            if (roman[s.charAt(i - 1)] < roman[s.charAt(i)]) {
                // example : XL
                sum -= roman[s.charAt(i - 1)];
            } else {
                // example : LX
                sum += roman[s.charAt(i - 1)];
            }
        }

        return sum + roman[s.charAt(s.length() - 1)];
    }
}