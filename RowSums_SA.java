/*Rows Sums Class (Exercise 2)
Mr. Jay
ICS4U1-02
Sarah Ali
May 2020*/

package com.company;

public class RowSums_SA {
    public static void main(String[] args) {
        int[][] data = {{3, 2, 5},
                {1, 4, 4, 8, 13},
                {9, 1, 0, 2},
                {0, 2, 6, 3, -1, -8}};

        // declare the sum
        int sum;

        // compute the sums for each row
        for (int[] row : data) {
            // initialize the sum
            sum = 0;

            // compute the sum for this row
            for (int i : row) {
                sum += i;
            }

            // write the sum for this row
            System.out.println(sum);
        }

    }
}
