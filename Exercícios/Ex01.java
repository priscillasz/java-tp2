package com.company;

/* Exercício 1: Leia duas variáveis inteiras e imprima a soma, subtração, multiplicação e divisão entre elas. */

import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {
        int var1, var2;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Variável 1: ");
        var1 = teclado.nextInt();

        System.out.println("Variável 2: ");
        var2 = teclado.nextInt();

        int soma = var1 + var2;
        int sub = var1 - var2;
        int multiplicacao = var1 * var2;
        int div = var1 / var2;

        System.out.printf("Soma = %d\n", soma);
        System.out.printf("Subtração = %d\n", sub);
        System.out.println("Multiplicação = "+multiplicacao);
        System.out.println("Divisão = "+div);
    }
}
