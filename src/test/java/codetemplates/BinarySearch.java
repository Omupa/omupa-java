package codetemplates;

public class BinarySearch {

    public static int fn(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                // do something
                return mid;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // left is the insertion point
        return left;
    }

    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] withDuplicates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 16, 16, 18, 19, 20};
        int result = fn(elements, 16);
        System.out.printf("Elemento %d encontrado na posição: %d", withDuplicates[result], result);
    }

}
