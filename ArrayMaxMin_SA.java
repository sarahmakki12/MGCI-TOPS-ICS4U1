/*Array Maximum and Minimum Class (Exercise 4)
Mr. Jay
ICS4U1-02
Sarah Ali
May 2020*/

package com.company;

public class ArrayMaxMin_SA {
    public static void main(String[] args) {
        int[][] data = {{3, 2, 5},
                {1, 4, 4, 8, 13},
                {9, 1, 0, 2},
                {0, 2, 6, 3, -1, -8}};

        // declare and initialize the max and the min
        int min = data[0][0], max = data[0][0];

        //
        for (int[] row : data) {
            for (int i : row) {
                if (i > max) {
                    max = i;
                }
                if (i < min) {
                    min = i;
                }
            }
        }

        // write out the results
        System.out.println("max = " + max + "; min = " + min);

    }
}
