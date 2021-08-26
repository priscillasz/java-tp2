package com.company;

/* Exercício 7: Leia uma variável n inteira. Em seguida, imprima uma mensagem informando se o número n é par ou ímpar. */

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args){
        int n;
        Scanner scan = new Scanner (System.in);

        System.out.println("N: ");
        n = scan.nextInt();

        if (n % 2 == 0)
            System.out.println("Par");
        else
            System.out.println("Ímpar");
    }
}
