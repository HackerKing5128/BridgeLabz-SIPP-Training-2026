// Power of X^n using recursion

class Power {
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(power(x, n));
    }

    public static int power(int x, int n) {
        // Base case: any number to the power of 0 is 1
        if (n == 0) {
            return 1;
        }
        // Recursive case: x^n = x * x^(n-1)
        return x * power(x, n - 1);
    }
}
