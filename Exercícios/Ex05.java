package com.company;

/* Exercício 5: Leia uma variável t com um tempo qualquer em segundos e imprima esse valor em hora, minuto e segundo. */

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args){
        int t;

        Scanner scan = new Scanner(System.in);

        System.out.println("Tempo (em segundos): ");
        t = scan.nextInt();

        int horas, minutos, segundos, r;
        horas = t / 3600;
        r = t % 3600;
        minutos = r / 60;
        segundos = r % 60;

        System.out.printf("%d:%d:%d\n", horas, minutos, segundos);
    }
}
