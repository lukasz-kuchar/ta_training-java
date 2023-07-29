package com.epam.training.lukasz_kuchar;

import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        Scanner scan = new Scanner(System.in);
        int input;
        input = scan.nextInt();
        int max = input;
        while(true){
            input = scan.nextInt();
            if (input == 0){
                break;
            }
            if (input > max){
                max = input;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        System.out.println(max());
    }
}