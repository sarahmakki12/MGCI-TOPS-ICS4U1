package com.company;

import java.util.*;

public class StrandSort {

    public static ArrayList<Integer> merge (ArrayList<Integer> first, ArrayList<Integer> second) {
        ArrayList<Integer> merged = new ArrayList<>();

        while (!first.isEmpty() && !second.isEmpty()) {
            if(first.get(0) <= second.get(0)) {
                merged.add(first.remove(0));
            } else {
                merged.add(second.remove(0));
            }
        }

        while (!first.isEmpty()) {
            merged.add(first.remove(0));
        }

        while (!second.isEmpty()) {
            merged.add(second.remove(0));
        }

        return merged;
    }

    public static ArrayList<Integer> strandSort (ArrayList<Integer> ip, ArrayList<Integer> op) {
        if (ip.isEmpty()) {
            return op;
        }

        ArrayList<Integer> sub = new ArrayList<>();

        sub.add(ip.remove(0));

        for (int i = 0; i < ip.size(); i++) {
            if (ip.get(i) > sub.get(sub.size() - 1)) {
                sub.add(ip.remove(i));
                i--;
            }
        }

        op = merge(sub, op);

        return strandSort(ip, op);
    }

    public static void main (String[] args) {
        Random r = new Random();
        ArrayList<Integer> ip = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ip.add(r.nextInt(50));
        }
        ArrayList<Integer> op = new ArrayList<>();

        for (Integer integer: ip) {
            System.out.print(integer + " ");
        }
        op = strandSort(ip, op);
        System.out.println();
        for (Integer integer : op) {
            System.out.print(integer + " ");
        }
    }
}
