package com.epam.training.lukasz_kuchar;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int seconds = input % 86400;
        int h = seconds/3600;
        int m = (seconds % 3600)/60;
        int s = (seconds % 3600) % 60;
        System.out.println(h + ":" + String.format("%02d", m) + ":" + String.format("%02d", s));
    }
}
