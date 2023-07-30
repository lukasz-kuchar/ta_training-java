package com.epam.training.lukasz_kuchar;

import java.util.Arrays;

public class SumOfPrevious {

    public static void main(String[] args) {
        int[] array = new int[]{1, -1};

        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array){

        boolean[] booleanArray = new boolean[array.length];
        booleanArray[0] = false;
        booleanArray[1] = false;
        if(array.length>2) {
            for (int i = 2; i < array.length; i++) {
                if (array[i] == array[i - 1] + array[i - 2]) {
                    booleanArray[i] = true;
                } else {
                    booleanArray[i] = false;
                }
            }
            return booleanArray;
        }else{
            return booleanArray;
        }
    }
}
