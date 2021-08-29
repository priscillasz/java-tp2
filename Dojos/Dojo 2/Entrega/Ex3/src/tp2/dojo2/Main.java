package tp2.dojo2;

        /*                  Grupo:
        (Copiloto) João Gabriel Evelin D'Oliveira - 20202210036
        (Copiloto) Priscilla Aparecida Matias de Souza - 20202210023
        (Piloto) Udson Bonin Costa - 20192210024 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Pokemon[] pokemons = new Pokemon[5];

        pokemons[1] = new Pokemon("Charmander", "Fogo", 8, 60, 0, 40);
        pokemons[2] = new Pokemon("Eevee", "Normal", 6, 30, 40, 60);
        pokemons[3] = new Pokemon("Bulbassauro","Água", 7, 40, 20, 30);

        System.out.println("Escolha um Pokemon:");
        System.out.println("1 - Charmander");
        System.out.println("2 - Eevee");
        System.out.println("3 - Bulbassauro");
        int input = scan.nextInt();

        int acao;
        do {
            System.out.println("(1) Capturar");
            System.out.println("(2) Libertar");
            System.out.println("(3) Brincar");
            System.out.println("(4) Alimentar");
            System.out.println("(5) Falar");
            System.out.println("(6) Evoluir");
            System.out.println("(0) Fim");

            acao = scan.nextInt();

            switch (acao){
                case 1:
                    pokemons[input].capturar();
                    break;
                case 2:
                    pokemons[input].libertar();
                    break;
                case 3:
                    pokemons[input].brincar();
                    break;
                case 4:
                    pokemons[input].alimentar();
                    break;
                case 5:
                    pokemons[input].falar();
                    break;
                case 6:
                    scan.nextLine(); // buffer
                    System.out.println("Para qual pokemon voce quer evoluir?");
                    String pokeEvolucao = scan.nextLine();
                    pokemons[input].evoluir(pokeEvolucao);
                    break;
                default:
                    if (acao !=0)
                        System.out.println("Ação invalida!");
                    break;
            }
        }while(acao != 0);
    }
}
