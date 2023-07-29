package com.epam.training.lukasz_kuchar;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int bill = scan.nextInt();
        int friends = scan.nextInt();
        if(bill < 0){
            System.out.println("Bill total amount cannot be negative");
        } else if (friends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        }else {
            double split = bill*1.1/friends;
            System.out.println((int)split);
        }

    }
}
