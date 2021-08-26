package com.company;

/* Exercício 2: Altere o tipo das duas variáveis do exercício 1 para ponto flutuante.
import java.util.Scanner;
public class Ex01 {
public static void main(String [] args)
{
Scanner teclado = new Scanner(System.in);
 Coloque o resto do codigo aqui
}
        } */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float var1, var2;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Variável 1: ");
        var1 = teclado.nextInt();

        System.out.println("Variável 2: ");
        var2 = teclado.nextInt();

        float soma = var1 + var2;
        float sub = var1 - var2;
        float multiplicacao = var1 * var2;
        float div = var1 / var2;

        System.out.printf("Soma = %f\n", soma);
        System.out.printf("Subtração = %f\n", sub);
        System.out.println("Multiplicação = "+multiplicacao);
        System.out.println("Divisão = "+div);
    }
}
