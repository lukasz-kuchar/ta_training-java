package com.epam.training.lukasz_kuchar;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int h = scan.nextInt();
        if (a <= b && h > a){
            System.out.println("Impossible");
        } else if (a >= b && a >= h) {
            System.out.println(1);
        } else {
            int counter = 0;
            int position = 0;
            while (position <= h){
                counter++;
                position = position + a;
                if(position >= h){
                    break;
                }
                position = position - b;
            }
            System.out.println(counter);
        }

    }
}
