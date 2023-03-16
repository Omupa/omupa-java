package codetemplates;

public class PrefixSum {

    /**
     * time complexity O(n)
     * space complexity O(1)
     *
     * @param arr
     * @return
     */
    public static int[] fn(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        return prefix;
    }

    public static void main(String[] args) {
        int[] elements = new int[]{2, 4, 6, 8, 10};
        int[] results = fn(elements);
        System.out.println(results);
    }

}
