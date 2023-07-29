package com.epam.training.lukasz_kuchar;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
        public static void main(String[] args) throws IOException {
            //Write a program, asks for a number - amount of strangers to meet.
            //Then reads stranger names line by line and prints line by line "Hello, ...".
            Scanner scan = new Scanner(System.in);
            int numberOfStrangers = scan.nextInt();
            scan.nextLine();
            if (numberOfStrangers == 0) {
                System.out.println("Oh, it looks like there is no one here");
            } else if (numberOfStrangers < 0) {
                System.out.println("Seriously? Why so negative?");
            } else {
                String[] names = new String[numberOfStrangers];
                for (int i = 0; i < names.length; i++) {
                    String nameOfStranger = scan.nextLine();
                    names[i] = nameOfStranger;
                }
                for (int i = 0; i < names.length; i++) {
                    System.out.println("Hello, " + names[i]);
                }
            }
        }
    }
