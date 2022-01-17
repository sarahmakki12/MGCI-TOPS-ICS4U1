package com.company;

import java.util.*;

public class BalancedTreesRecursion {
    static Scanner in = new Scanner(System.in);

    int[] lookup = new int[100000];

    public static int balance(int w) {
        if (w == 1) {
            return 1;
        } else {
            int trees = 0;
            for (int k = w; k >= 2; k--) {
                trees += balance(w / k);
            }
            return trees;
        }
    }

    public static void main(String[] args) {
        int w = in.nextInt();

        System.out.println(balance(w));
    }
}