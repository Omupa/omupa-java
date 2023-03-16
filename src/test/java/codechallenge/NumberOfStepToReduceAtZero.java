package codechallenge;

public class NumberOfStepToReduceAtZero {

    /**
     * time complexity O(log n)
     * space complexity O(1)
     */
    public static int numberOfSteps(int num) {
        int steps = 0;

        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }

            steps++;
        }

        return steps;
    }

    public static int numberOfStepsBitwise(int num) {
        int steps = 0;

        while (num != 0) {
            if ((num & 1) == 0) {
                num = num >> 1;
            } else {
                num--;
            }

            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(1_000_000));
    }
}
