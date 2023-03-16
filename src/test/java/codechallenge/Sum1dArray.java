package codechallenge;

public class Sum1dArray {

    /**
     * time complexity O(n)
     * space complexity O(1)
     *
     * @param arr Input array
     * @return int[] Output array
     */
    public static int[] sumArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};

        int[] result = sumArray(arr);

        for (int num : result) {
            System.out.printf(" - %d", num);
        }
    }

}
