/*Array Practice Quiz
Mr. Jay
ICS4U1-02
Sarah Ali
May 2020*/

package com.company;

//I had to use Array2 because we already has class Array from another assignment.
public class Array2 {
    private int[] arr;

    public Array2(int size) {
        arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = 7 - i;
        }
    }

    public void shiftRightTwo() {
        int[] temp = new int[arr.length];

        temp[0] = arr[arr.length - 2];
        temp[1] = arr[arr.length - 1];

        System.arraycopy(arr, 0, temp, 2, temp.length - 2);

        arr = temp;
    }

    public int belowAverage() {
        int avg = 0;
        for (int num : arr) {
            avg += num;
        }
        avg /= arr.length;

        int count = 0;
        for (int num : arr) {
            count += num < avg ? 1 : 0;
        }
        return count;
    }

    public void mirror() {
        int[] temp = new int[arr.length * 2];

        System.arraycopy(arr, 0, temp, 0, arr.length);

        for (int i = arr.length; i < temp.length; i++) {
            temp[i] = arr[temp.length - 1 - i];
        }

        arr = temp;
    }

    public static void main(String[] args) {
        Array2 list = new Array2(7);

        list.shiftRightTwo();

        System.out.print("There are " + list.belowAverage() + " below average.");

        list.mirror();
    }
}
