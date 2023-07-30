package com.epam.training.lukasz_kuchar;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array != null && array.length != 0) {
            int last = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = last;
        }
    }

    static void cycleSwap(int[] array, int shift) {
        if (array != null && array.length != 0) {
            int n = shift;
            for (int i = 0; i < n; i++) {
                int last = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = last;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 7, 4};
        CycleSwap.cycleSwap(array, 2);
        System.out.println(Arrays.toString(array));
    }
}