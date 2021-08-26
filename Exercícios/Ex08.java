package com.company;

/* Exercício 8: Leia duas variáveis com a quantidade de kilowatts consumidos em uma casa e
o valor do kilowatt. Em seguida, calcule o valor a ser pago, concedendo um desconto de
10% caso o consumo seja menor que 150 */

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args){
        int kilowatts;
        float valor_kw;

        Scanner scan = new Scanner(System.in);

        System.out.println("Quantidade de kilowatts consumidos: ");
        kilowatts = scan.nextInt();

        System.out.println("Valor do kilowatt: ");
        valor_kw = scan.nextFloat();

        float valor_a_pagar = kilowatts * valor_kw;

        if (valor_a_pagar >= 150)
            System.out.println("Valor a pagar: "+valor_a_pagar);
        else
        {
            valor_a_pagar = (kilowatts * valor_kw) - (kilowatts * valor_kw) * 10 / 100;
            System.out.println("Valor a pagar: "+valor_a_pagar);
        }
    }
}
