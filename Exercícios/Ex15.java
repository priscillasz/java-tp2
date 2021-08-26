package com.company;

/* Exercício 15: Ler caracteres até que o usuário digite '.' (ponto). Ao final imprimir: a
quantidade de vogais, a quantidade de dígitos e a quantidade dos demais caracteres. */

import java.util.Scanner;

public class Ex15 {
    public static void main(String[] args){
        char c;
        int vogal = 0, digito = 0, outros = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Caractere: ");
            c = scan.next().charAt(0);

            if (c >= 65 && c <= 69 || c >= 97 && c <= 101)
                vogal++;
            else if (c >= 48 && c <= 57)
                digito++;
            else
                outros++;

        } while (c != '.');

        System.out.println("Vogais: "+vogal);
        System.out.println("Dígitos: "+digito);
        System.out.println("Demais caracteres: "+outros);
    }
}
