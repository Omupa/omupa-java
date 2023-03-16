package mock;

import java.util.Random;

public class ArrayMock {

    public static int[] oneDimensional(int length) {
        int[] arr = new int[length];

        for (int i = 0; i <= length; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }

    public static int[][] biDimensional(int xLength, int yLength) {
        int[][] matrix = new int[xLength][yLength];

        for (int i = 0; i < xLength; i++) {
            int[] yAxis = new int[yLength];

            for (int j = 0; j < yLength; j++) {
                yAxis[j] = new Random().nextInt(20);
            }
            matrix[i] = yAxis;
        }

        return matrix;
    }


}
