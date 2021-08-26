package com.company;

import java.util.Scanner;

/* Exercício 11: Ler um caractere op representando uma operação aritmética (+, -, *, /) e em
seguida dois números reais a e b. Imprimir a expressão matemática junto com o seu
resultado no formato:* /

 */
public class Ex11 {
    public static void main(String[] args){
        char op;
        float a, b;
        float soma, sub, multip, divisao;

        Scanner scan = new Scanner(System.in);

        System.out.println("Operação a ser realizada (+, -, *, /): ");
        op = scan.next().charAt(0);

        System.out.println("A: ");
        a = scan.nextFloat();

        System.out.println("B: ");
        b = scan.nextFloat();

        if (op == '+')
        {
            soma = a + b;
            System.out.println(a+" + "+ b +" = "+ soma);
        }
        else if (op == '-')
        {
            sub = a - b;
            System.out.println(a+" - "+ b +" = "+ sub);
        }
        else if (op == '*')
        {
            multip = a * b;
            System.out.println(a+" * "+ b +" = "+ multip);
        }
        else
        {
            divisao = a / b;
            System.out.println(a+" / "+ b +" = "+ divisao);
        }
    }
}
