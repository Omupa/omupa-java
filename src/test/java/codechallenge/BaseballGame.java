package codechallenge;

import java.security.InvalidParameterException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * Value D : n * 2
 * Value C : remove
 * Value + : Sum last two values
 */
public class BaseballGame {

    /**
     * Complexity TIME/CPU: O(N)
     * Complexity MEMORY: O(N)
     *
     * @param ops String array
     * @return sum of values in array after calculate operation
     */
    public int calPointsA(String[] ops) {
        validateSize(ops.length);

        final Deque<String> stack = new ArrayDeque<>();

        for (String op : ops) {
            if ("C".equals(op)) {
                removeLastValue(stack);

            } else if (Objects.equals(op, "D")) {
                multiplyByTwoLastValue(stack);

            } else if (Objects.equals(op, "+")) {
                sumLastTwoValues(stack);

            } else {
                stack.push(op);
            }
        }

        return stack.stream()
                .map(Integer::valueOf)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private void validateSize(int length) {
        if (length < 1 || length > 1000) {
            throw new InvalidParameterException();
        }
    }

    private void removeLastValue(Deque<String> stack) {
        stack.pop();
    }

    private void multiplyByTwoLastValue(Deque<String> stack) {
        final String element = stack.element();
        final int lastValue = Integer.parseInt(element);
        stack.push(String.valueOf(lastValue * 2));
    }

    private void sumLastTwoValues(Deque<String> stack) {
        final int lastValue = Integer.parseInt(stack.pop());
        final int penultimateValue = Integer.parseInt(stack.pop());

        final String newValue = String.valueOf(lastValue + penultimateValue);

        stack.push(String.valueOf(lastValue));
        stack.push(String.valueOf(penultimateValue));
        stack.push(newValue);
    }

    public static void main(String[] args) {
        final var baseballGame = new BaseballGame();
        int result = baseballGame.calPointsA(caseA());
        System.out.println(result);
    }

    private static String[] caseA() {
        return new String[]{"5", "10", "15", "C", "D", "20", "+"};
    }

    private static String[] caseB() {
        return new String[]{"1", "2", "C", "C"};
    }

    private static void caseC() {

    }

    private static String[] caseD() {
        return new String[]{"5", "2", "C", "D", "+"};
    }
}
