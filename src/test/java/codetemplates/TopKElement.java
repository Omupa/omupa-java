package codetemplates;

import java.util.PriorityQueue;

public class TopKElement {

    public static int[] fn(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(10);
        for (int num : arr) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.remove();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 3, 4, 5, 2, 2, 8, 3, 10};
        int k = 2;

        int[] result = fn(elements, k);
        for (int curr : result) {
            System.out.printf(" - %d", curr);
        }
    }
}
