package tp2.dojo1;

/* Grupo:
João Gabriel Evelin D'Oliveira - 20202210036
Priscilla Aparecida Matias de Souza - 20202210023
Udson Bonin Costa - 20192210024 */

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randNumber = new Random();

        int n1 = randNumber.nextInt(30);
        int n2 = randNumber.nextInt(30);
        int n3 = randNumber.nextInt(30);
        int n4 = randNumber.nextInt(30);
        int n5 = randNumber.nextInt(30);

        int media = (n1+n2+n3+n4+n5)/5;

        int numero;
        for (int i = 0; i < 15; i++)
        {
            System.out.println("Digite um número:");
            numero = scan.nextInt();

            if (numero < media)
                System.out.println("Menor.");
            else if (numero > media)
                System.out.println("Maior.");
            else {
                System.out.println("Acertou!");
                break;
            }
            if (i == 14)
                System.out.println("Suas tentativas acabaram!");
        }
    }
}


