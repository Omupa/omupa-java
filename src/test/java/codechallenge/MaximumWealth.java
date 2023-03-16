package codechallenge;

import mock.ArrayMock;

public class MaximumWealth {

    /**
     * time complexity O(n x m)
     * space complexity O(1)
     */
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int[] customer : accounts) {
            int customerBalance = 0;

            for (int bankBalance : customer) {
                customerBalance += bankBalance;
            }

            maxWealth = Math.max(maxWealth, customerBalance);
        }

        return maxWealth;
    }

    public static void main(String[] args) {
        int[][] matrix = ArrayMock.biDimensional(5, 5);

        int maxWealth = maximumWealth(matrix);
        System.out.println("Max wealth is: " + maxWealth);
    }

}
