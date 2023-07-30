package com.epam.training.lukasz_kuchar;

public class MaxMethod {
    public static int max(int[] values) {
        int max = values[0];
        for (int value: values) {
            if(value>max){
                max = value;
            }
        }
        return max;
    }
}
