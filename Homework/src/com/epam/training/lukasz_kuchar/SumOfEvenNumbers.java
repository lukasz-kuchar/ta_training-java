package com.epam.training.lukasz_kuchar;

public class SumOfEvenNumbers {
    public static int sum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        else{
            int sum = 0;
            for (int item : array) {
                if (item % 2 == 0) {
                    sum = sum + item;
                }
            }
            return sum;
        }
    }
    public static void main (String[]args){
        int[] arr = new int[0];

        System.out.println(sum(arr));
    }

}