package com.epam.training.lukasz_kuchar;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = scan.nextInt();
        int pieces = scan.nextInt();
        int pizzas = 1;
        while((pizzas*pieces)%people != 0){
            pizzas++;
        }
        System.out.println(pizzas);
    }
}
