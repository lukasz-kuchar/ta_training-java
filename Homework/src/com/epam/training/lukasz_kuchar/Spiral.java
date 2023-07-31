package com.epam.training.lukasz_kuchar;

class Spiral {
    static int[][] spiral(int rows, int columns) {

        int[][] output = new int[rows][columns];
        int rowBegin = 0;
        int rowEnd = rows-1;
        int colBegin = 0;
        int colEnd = columns-1;
        int filler = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd){


            for(int i=colBegin; i<= colEnd; i++){
                output[rowBegin][i] = filler;
                filler++;
            }

            rowBegin++;

            for(int i=rowBegin; i<= rowEnd; i++){
                output[i][colEnd]=filler;
                filler++;
            }
            colEnd--;

            if(rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    output[rowEnd][i] = filler;
                    filler++;
                }
            }
            rowEnd--;
            if(colBegin <= colEnd){
                for(int i=rowEnd; i>= rowBegin; i--){
                    output[i][colBegin]= filler;
                    filler++;
                }
            }
            colBegin++;
        }

        return output;
    }

    public static void main(String[] args) {
        int[][] spiral = Spiral.spiral(3, 3);

        for (int i = 0; i < spiral.length; i++) {
            for (int j = 0; j < spiral[i].length; j++) {
                System.out.print(String.format("%4s", spiral[i][j]));
            }
            System.out.println();
        }

    }
}