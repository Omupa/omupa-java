package codechallenge;


import mock.ListMock;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {

    /**
     * Complexity Time/CPU: O(n²)
     * Complexity Memory: O(1)
     *
     * @param integers Input array
     * @param d        How much index to left rotate
     * @return integers
     */
    public List<Integer> rotLeftA(List<Integer> integers, int d) {
        if (d == 0) {
            return integers;
        }

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < integers.size(); j++) {
                Integer temp = integers.get(j);

                if (j < integers.size() - 1) {
                    integers.set(j, integers.get(j + 1));
                    integers.set(j + 1, temp);
                }
            }
        }

        return integers;
    }

    /**
     * Complexity Time/CPU: O(n)
     * Complexity Memory: O(n log(n))
     *
     * @param integers Input array
     * @param d        How much index to left rotate
     * @return integers
     */
    public List<Integer> rotLeftB(List<Integer> integers, int d) {
        if (d == 0) {
            return integers;
        }

        final List<Integer> elementsRotation = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            elementsRotation.add(integers.get(i));
        }

        for (int i = d; i < integers.size(); i++) {
            integers.set(i - d, integers.get(i));
        }

        for (int i = integers.size() - d; i < integers.size(); i++) {
            integers.set(i, elementsRotation.get(i - (integers.size() - d)));
        }

        return integers;
    }

    /**
     * Complexity Time/CPU: O(n)
     * Complexity Memory: O(1)
     *
     * @param integers Input array
     * @param d        How much index to left rotate
     * @return integers
     */
    public List<Integer> rotLeftC(List<Integer> integers, int d) {
        if (d == 0) {
            return integers;
        }

        this.reverse(integers, 0, d - 1);
        this.reverse(integers, d, integers.size() - 1);
        this.reverse(integers, 0, integers.size() - 1);

        return integers;
    }

    public List<Integer> reverse(List<Integer> integers, int low, int high) {
        for (int i = low, j = high; i < j; i++, j--) {
            Integer aux = integers.get(i);
            integers.set(i, integers.get(j));
            integers.set(j, aux);
        }

        return integers;
    }

    public static void main(String[] args) {
        final var leftRotation = new LeftRotation();

        System.out.println(leftRotation.rotLeftC(ListMock.integerList(10), 50));
    }

}
