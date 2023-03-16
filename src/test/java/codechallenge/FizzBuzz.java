package codechallenge;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);

        for (int i = 1; i <= n; i ++) {
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;

            String value = "";

            if (divisibleBy3) value += "Fizz";
            if (divisibleBy5) value += "Buzz";
            if (value.isEmpty()) value = String.valueOf(i);

            result.add(value);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> result = fizzBuzz(20);
        System.out.println(result);
    }
}
