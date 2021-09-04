package tp2.dojo3;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Data de nascimento (dia, mês e ano)");
        int dia = scan.nextInt();
        int mes = scan.nextInt();
        int ano = scan.nextInt();

        LocalDate birthDate = LocalDate.of(ano, mes, dia);
        System.out.println(birthDate);
        /*int opcao;
        do {
            System.out.println("Menu");
            System.out.println("Abrir conta");
            System.out.println("Sacar");
            System.out.println("Depositar");
            System.out.println("Emitir extrato");
            System.out.println("Configurar PIX");
            System.out.println("Pagar boleto");
            opcao = scan.nextInt();

            switch (opcao){
                case 1: // abrir conta
                    break;
                case 2: // sacar
                    break;
                case 3: // depositar
                    break;
                case 4: // emitir extrato
                    break;
                case 5: // configurar pix
                    break;
                case 6: // pagar boleto
                    break;
                default:
                    if (opcao != 0)
                        System.out.println("Opção inválida!");
                    break;
            }
        } while(opcao != 0);*/
    }
}
