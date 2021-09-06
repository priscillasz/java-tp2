package tp2.dojo3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteAquiSla {


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Email:");
        String email = teclado.nextLine();

        try {
            System.out.println("CPF: ");
            int cpf = teclado.nextInt();
        } catch (InputMismatchException erro1) {
            System.err.println("nao tem ponto no cpf o genio");
        }
    }
}
