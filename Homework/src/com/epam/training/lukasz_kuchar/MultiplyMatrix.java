package com.epam.training.lukasz_kuchar;

import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] a, int[][] b) {

        int[][] c = new int[a.length][b[0].length];

        for(int i=0; i<c.length; i++) {
            for (int j=0; j < c[i].length; j++) {
                for (int k=0; k<a[0].length; k++){

                    c[i][j] += a[i][k]*b[k][j];
                }
            }
        }

        return c;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {{1, 2, 3},
                {4, 5, 6}};

        int[][] b = {{7, 8},
                {9, 10},
                {11, 12}};

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}