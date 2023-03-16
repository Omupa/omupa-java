package codetemplates;

public class BinarySearchDuplicatesLeftMostInsertion {

    public static int fn(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] withDuplicates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 16, 16, 18, 19, 20};
        int result = fn(withDuplicates, 16);
        System.out.printf("Elemento %d encontrado na posição: %d", withDuplicates[result], result);
    }

}
