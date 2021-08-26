package com.company;

/* Exercício 12: Ler dois números inteiros (a e b) e imprimir os pares no intervalo a..b, além
da soma e da média desses números. Caso a seja maior que b, imprima os números no
intervalo b..a. */

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args){
        int a, b, soma = 0, media = 0, counter = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println("A: ");
        a = scan.nextInt();

        System.out.println("B: ");
        b = scan.nextInt();

        if (a < b)
        {
            System.out.println("Números pares no intervalo:");
            for (int i = a; i <= b; i++)
            {
                if (i % 2 == 0)
                {
                    System.out.printf("%d ", i);
                    soma += i;
                    counter++;
                    media = soma / counter;
                }
            }

            System.out.println("\nSoma: "+soma);
            System.out.println("Média: "+media);
        }
        else
        {
            System.out.println("Números pares no intervalo:");
            for (int i = b; i <= a; i++)
            {
                if (i % 2 == 0)
                {
                    System.out.printf("%d ", i);
                    soma += i;
                    counter++;
                    media = soma / counter;
                }
            }

            System.out.println("\nSoma: "+soma);
            System.out.println("Média: "+media);
        }
    }
}
