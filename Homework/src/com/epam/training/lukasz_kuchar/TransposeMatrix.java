package com.epam.training.lukasz_kuchar;

import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int[][] temp = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < matrix[0].length; i++){
            for (int j = 0; j < matrix.length; j++){
                temp[i][j] = matrix[j][i];
            }
        }

        return temp;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] matrix = {
                {1, 2},
                {7, -13} };

        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }

}
