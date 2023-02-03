package codechallenge;

import mock.ListMock;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class ReverseLastNElements {

    public Integer[] reverse(final Integer[] array, final int position) {
        if (array == null || array.length <= 1) {
            return array;
        } else if (array.length < position) {
            throw new InvalidParameterException("Position cannot be higher than size of the array");
        }

        final int low = array.length - position;
        final int high = array.length - 1;
        this.reverse(array, low, high);

        return array;
    }

    private void reverse(final Integer[] array, final int low, final int high) {
        for (int i = low, j = high; i < j; i++, j--) {
            final int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        final int position = 10;
        final Integer[] array = ListMock.integerList(10).toArray(new Integer[0]);

        final var reverseLastNElements = new ReverseLastNElements();
        final Integer[] reversed = reverseLastNElements.reverse(array, position);
        System.out.println(Arrays.toString(reversed));
    }
}