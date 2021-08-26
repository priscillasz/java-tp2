package tp2.dojo1;

/* Grupo:
João Gabriel Evelin D'Oliveira - 20202210036
Priscilla Aparecida Matias de Souza - 20202210023
Udson Bonin Costa - 20192210024 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o ano:");
        int ano = scan.nextInt();

        System.out.println("Insira o dia:");
        int qtdDias = scan.nextInt();

        Data data1 = new Data(qtdDias, ano);

        if (ano % 2 == 0)
            System.out.println("Paridade: Par");
        else
            System.out.println("Paridade: Ímpar");

        boolean bissexto;
        if ((ano % 4 != 0 || ano % 100 == 0) && ano % 400 != 0)
            bissexto = false;
        else
            bissexto = true;

        System.out.println("Bissexto: "+ bissexto);

        if (ano < 2021)
            System.out.println("Distância: "+(2021-ano));
        else
            System.out.println("Distância: "+(ano-2021));

        System.out.println("Data: "+data1.getDia()+"/"+data1.getMes()+"/"+data1.getAno());
    }
}
