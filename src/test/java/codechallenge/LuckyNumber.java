package codechallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value. <br>
 * Return the largest lucky integer in the array. If there is no lucky integer return -1. <br><br>
 * <p>
 * Example 1: <br>
 * Input: arr = [2,2,3,4] <br>
 * Output: 2 <br>
 * Explanation: The only lucky number in the array is 2 because frequency[2] == 2. <br><br>
 * <p>
 * Example 2: <br>
 * Input: arr = [1,2,2,3,3,3] <br>
 * Output: 3 <br>
 * Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them. <br><br>
 * <p>
 * Example 3: <br>
 * Input: arr = [2,2,2,3,3] <br>
 * Output: -1 <br>
 * Explanation: There are no lucky numbers in the array. <br><br>
 * <p>
 * Constraints: <br>
 * 1 <= arr.length <= 500 <br>
 * 1 <= arr[i] <= 500 <br>
 */
public class LuckyNumber {

    /**
     * First solution that I solve the problem <br>
     * Complexity TIME/CPU: O(n²) <br>
     * Complexity MEMORY: O(n²)
     *
     * @param array of int values
     * @return int value with the lucky number
     */
    public int getLuckyA(int[] array) {
        int luckyNumber = -1;
        final Map<Integer, Integer> map = new HashMap<>();

        for (Integer element : array) {
            if (map.containsKey(element)) {
                Integer integer = map.get(element);
                integer += 1;
                map.put(element, integer);

            } else {
                final Integer integer = 1;
                map.put(element, integer);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            final Integer key = entry.getKey();
            final Integer value = entry.getValue();

            luckyNumber = this.verifyLuckyNumber(key, value, luckyNumber);
        }

        return luckyNumber;
    }

    private int verifyLuckyNumber(final Integer key, final Integer value, int luckyNumber) {
        if (key.equals(value) && key > luckyNumber) {
            return key;
        }

        return luckyNumber;
    }

    /**
     * Second solution that I solve the problem <br>
     * Complexity TIME/CPU: O(n log(n)) <br>
     * Complexity MEMORY: O(1)
     *
     * @param array of int values
     * @return int value with the lucky number
     */
    public int getLuckyB(int[] array) {
        int luckyNumber = -1;
        Arrays.sort(array);

        for (int i = 0; i < array.length;) {
            final int element = array[i];
            int elementFrequency = 0;

            do {
                elementFrequency += 1;
                i++;
            } while (i < array.length && array[i] == element);

            luckyNumber = this.verifyLuckyNumber(element, elementFrequency, luckyNumber);
        }

        return luckyNumber;
    }

}
