package codechallenge;

import mock.ListMock;

import java.util.Arrays;
import java.util.List;

public class ReverseFirstNElements {

    public Integer[] reverse(final Integer[] array, final int position) {
        if (array == null || array.length <= 1) {
            return array;
        }

        int low = 0;
        int high = array.length - position - 1;
        this.reverse(array, low, high);

        return array;
    }

    private void reverse(final Integer[] array, final int low, final int high) {
        for (int i = low, j = high; i < j; i++, j--) {
            final Integer temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = ListMock.integerList(10);

        final int position = 5;
        final var reverse = new ReverseFirstNElements();
        Integer[] reversed = reverse.reverse(integers.toArray(new Integer[0]), position);

        System.out.println(Arrays.toString(reversed));
    }

}
