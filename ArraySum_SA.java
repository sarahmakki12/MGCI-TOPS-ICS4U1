/*Array Sum Class (Exercise 1)
Mr. Jay
ICS4U1-02
Sarah Ali
May 2020*/

package com.company;

public class ArraySum_SA {
    public static void main(String[] args) {
        int[][] data = {{3, 2, 5},
                {1, 4, 4, 8, 13},
                {9, 1, 0, 2},
                {0, 2, 6, 3, -1, -8}};

        // declare the sum
        int sum = 0;

        // compute the sum
        for (int[] row : data) {
            for (int i : row) {
                sum += i;
            }
        }

        // write out the sum
        System.out.println(sum);

    }
}
