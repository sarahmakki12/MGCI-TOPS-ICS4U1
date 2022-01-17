/*Smooth Class (Exercise 7)
Mr. Jay
ICS4U1-02
Sarah Ali
May 2020*/

package com.company;

import java.io.*;
import java.util.*;

public class Smooth_SA {
    public static void main(String[] args) throws FileNotFoundException {

        //read data from input file
        File text = new File("C:\\Users\\Public\\Documents/image.txt");
        Scanner sc = new Scanner(text);

        //find number of lines
        int numLines = 0;
        while (sc.hasNextLine()) {
            numLines++;
            sc.nextLine();
        }
        sc = new Scanner(text);

        //create image array
        String[] key = sc.nextLine().split(" ");
        int[][] image = new int[numLines][key.length];

        //initialize first row of image array
        for (int i = 0; i < key.length; i++) {
            image[0][i] = Integer.parseInt(key[i]);
        }

        //fill image array
        int rowNum = 1;
        while (sc.hasNextLine()) {
            key = sc.nextLine().split(" ");
            for (int i = 0; i < key.length; i++) {
                image[rowNum][i] = Integer.parseInt(key[i]);
            }
            rowNum++;
        }
        int colNum = image[0].length;

        // assume a rectangular image
        int[][] smooth = new int[rowNum][colNum];
        int sum, divide;

        // Compute the smoothed value for non-edge locations in the image
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                sum = 0;
                divide = 9;
                for (int i = row - 1; i <= row + 1; i++) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        try {
                            sum += image[i][j];
                        } catch (ArrayIndexOutOfBoundsException e)
                        {
                            divide--;
                        }
                    }
                }
                smooth[row][col] = sum / divide;
            }
        }

        // write out the input
        for (int[] row : image) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println();

        // write out the result
        for (int[] row : smooth) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
