package com.company;

/* Exercício 10: Ler um número inteiro n e mais dois números (inferior e superior) que formam
um intervalo. Ao final, imprima uma mensagem informando se n está antes, dentro ou
depois do intervalo. */

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args){
        int n, inferior, superior;

        Scanner scan = new Scanner(System.in);

        System.out.println("N: ");
        n = scan.nextInt();

        System.out.println("Inferior: ");
        inferior = scan.nextInt();

        System.out.println("Superior: ");
        superior = scan.nextInt();

        if (n >= inferior && n <= superior)
            System.out.println("N está dentro do intervalo");
        else if (n < inferior)
            System.out.println("N está antes do intervalo");
        else
            System.out.println("N está depois do intervalo");
    }
}
