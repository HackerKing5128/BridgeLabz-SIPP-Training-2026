class NumberOfStepsToReduceToZero {
    public int numberOfSteps(int num) {
        int steps = 0;

        while (num != 0) {
          if (num % 2 == 0) {
            // if n is even, divide by 2
            num /= 2;
          } else {
            // if n is odd, subtract 1
            num--;
          }

          steps++;
        }

        return steps;
    }
}