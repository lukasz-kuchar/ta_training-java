package com.epam.training.lukasz_kuchar;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int sum = input;
        int average;
        int counter = 0;
        while(input != 0){
            input = scan.nextInt();
            sum = sum + input;
            counter++;
        }
        average = sum / counter;
        System.out.println(average);
    }
}
