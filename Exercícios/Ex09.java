package com.company;

import java.util.Scanner;

/* Exercício 9: Ler um número real x e imprimi-lo arredondando seu valor para mais ou para
menos. Se a parte decimal for menor que 0.5 arredonda para menos. Se for maior ou igual
a 0.5 arredonda para mais. */

public class Ex09 {
    public static void main(String[] args){
        float x;
        Scanner scan = new Scanner(System.in);

        System.out.println("X: ");
        x = scan.nextFloat();

        int inteiro = (int)x;
        float decimal = x - inteiro;

        if (decimal >= 0.5)
            System.out.println(Math.ceil(x));
        else
            System.out.println(Math.floor(x));
    }
}
