package tp2.dojo2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        // MOUSE
        Mouse mouse1 = new Mouse();

        System.out.println("Mouse");
        System.out.println("Qual a cor do mouse? ");
        mouse1.setCor(scann.nextLine());
        System.out.println("Qual a marca do mouse? ");
        mouse1.setMarca(scann.nextLine());
        System.out.println("Seu mouse tem RGB? (true ou false)");
        mouse1.setRgb(scann.nextBoolean());

        // LIVRO
        System.out.println("\n-----Livro-----");
        System.out.println("Qual é o título do livro?");
        scann.nextLine(); // buffer do teclado
        String tituloLivro = scann.nextLine();
        System.out.println("Quem é o autor do livro? ");
        String autorLivro = scann.nextLine();
        System.out.println("Qual o gênero do livro? ");
        String generoLivro = scann.nextLine();

        Livro livro1 = new Livro(tituloLivro, autorLivro, generoLivro);

        // TECLADO
        Teclado teclado1 = new Teclado();
        System.out.println("\n-----Teclado-----");
        System.out.println("Seu teclado é wireless? (true ou false)");
        teclado1.setWireless(scann.nextBoolean());
        System.out.println("Seu teclado é ABNT? (true ou false)");
        teclado1.setAbnt(scann.nextBoolean());
        System.out.println("Seu teclado tem macro? (true ou false)");
        teclado1.setMacro(scann.nextBoolean());

        // MONITOR
        Monitor monitor1 = new Monitor();
        System.out.println("\n-----Monitor-----");
        System.out.println("Qual a marca do monitor? ");
        scann.nextLine(); // buffer do teclado
        monitor1.setMarca(scann.nextLine());
        System.out.println("Qual a resolução do monitor? ");
        monitor1.setResolucao(scann.nextLine());
        System.out.println("Qual a taxa de frequência do monitor? (em Hz) ");
        monitor1.setFrequencia(scann.nextInt());

        // INCENSO
        Incenso incenso1 = new Incenso();

        System.out.println("\nIncenso");
        System.out.println("Qual o nome do Incenso? ");
        scann.nextLine(); // buffer do teclado
        incenso1.setNome(scann.nextLine());
        System.out.println("Qual o aroma do Incenso? ");
        incenso1.setAroma(scann.nextLine());

        // IMPRESSÃO DAS CARACTERÍSTICAS DOS OBJETOS
        System.out.println("\n-----Mouse-----");
        mouse1.imprimir();

        System.out.println("\n-----Livro-----");
        livro1.imprimir();

        System.out.println("\n-----Teclado-----");
        teclado1.imprimir();

        System.out.println("\n-----Monitor-----");
        monitor1.imprimir();

        System.out.println("\n-----Incenso-----");
        incenso1.imprimir();
    }
}