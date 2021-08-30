package tp2.dojo2;

        /*                  Grupo:
        (Copiloto) João Gabriel Evelin D'Oliveira - 20202210036
        (Copiloto) Priscilla Aparecida Matias de Souza - 20202210023
        (Piloto) Udson Bonin Costa - 20192210024 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Mouse");
        System.out.println("Cor:");
        String corMouse = scan.nextLine();
        System.out.println("Marca:");
        String marcaMouse = scan.nextLine();

        Mouse mouse1 = new Mouse(corMouse, marcaMouse);

        System.out.println("Livro");
        System.out.println("Autor:");
        String autorLivro = scan.nextLine();
        System.out.println("Título:");
        String tituloLivro = scan.nextLine();

        Livro livro1 = new Livro(autorLivro, tituloLivro);

        System.out.println("Copo");
        System.out.println("Tipo:");
        String copoTipo = scan.nextLine();
        System.out.println("Altura:");
        int alturaCopo = scan.nextInt();

        Copo copo1 = new Copo(copoTipo,alturaCopo);

        System.out.println("Cubo");
        System.out.println("Lado:");
        int ladoCubo = scan.nextInt();

        Cubo cubo1 = new Cubo(ladoCubo);

        System.out.println("Incenso");
        scan.nextLine();
        System.out.println("Nome:");
        String nomeIncenso = scan.nextLine();
        System.out.println("Aroma:");
        String aromaIncenso = scan.nextLine();

        Incenso incenso1 = new Incenso(nomeIncenso, aromaIncenso);

        mouse1.imprimir();
        livro1.imprimir();
        copo1.imprimir();
        cubo1.imprimir();
        incenso1.imprimir();
    }
}
