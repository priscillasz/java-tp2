package com.company;

/* Leia o salário e o percentual de aumento. Em seguida, aplique o percentual de aumento sobre o salário e imprima o novo salário. */

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        float salario, aumento, novo_salario;

        Scanner teclado = new Scanner (System.in);

        System.out.println("Salário: ");
        salario = teclado.nextFloat();

        System.out.println("Percentual de aumento: ");
        aumento =  teclado.nextFloat();

        novo_salario = salario + (salario * aumento) / 100;

        System.out.println("Novo salario: "+novo_salario);
    }
}
