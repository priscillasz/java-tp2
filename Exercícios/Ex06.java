package com.company;

/* Exercício 6: Leia a distância percorrida por um carro, o tempo gasto e a quantidade de
gasolina consumida. Em seguida, imprima a velocidade média (KM/h) e o consumo de
combustível (Km/l). */

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args){
        float distancia, tempo, gasolina;

        Scanner scan = new Scanner(System.in);

        System.out.println("Distância percorrida (Km): ");
        distancia = scan.nextFloat();

        System.out.println("Tempo gasto (em horas): ");
        tempo = scan.nextFloat();

        System.out.println("Quantidade de gasolina consumida (L): ");
        gasolina = scan.nextFloat();

        float velocidade_media = distancia / tempo;
        float consumo_combustivel = distancia / gasolina;

        System.out.println("Velocidade média: "+velocidade_media+" Km/h");
        System.out.println("Consumo de combustível: "+consumo_combustivel+" Km/l");
    }
}
