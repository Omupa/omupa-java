package codechallenge;

import mock.ListMock;

import java.util.Arrays;

public class ReverseArray {

    public Integer[] reverse(final Integer[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            final Integer temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        final Integer[] array = ListMock.integerList(10).toArray(new Integer[0]);

        final var reverseArray = new ReverseArray();
        final Integer[] reversed = reverseArray.reverse(array);
        System.out.println(Arrays.toString(reversed));
    }

}
