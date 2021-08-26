package com.company;

/* Exercício 4: Leia o raio de um círculo. Em seguida imprima o perímetro (2piR) e a área (piR^2) do círculo com esse raio. */

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        float raio, perimetro, area;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Raio do círculo: ");
        raio = teclado.nextFloat();

        perimetro = 2 * 3.14f * raio;
        area = 3.14f * raio * raio;

        System.out.println("Perímetro: "+perimetro);
        System.out.println("Área: "+area);
    }
}
