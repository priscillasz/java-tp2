package tp2.dojo2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // criação do array de pokemons
        Pokemon[] pokemons = new Pokemon[5];

        // criação de 3 objetos da classe Pokemon com atributos já definidos
        pokemons[1] = new Pokemon("Charmander","Fogo", 8, 60, 0, 40);
        pokemons[2] = new Pokemon("Eevee", "Normal", 6, 30, 40, 60);
        pokemons[3] = new Pokemon("Bulbasaur", "Água", 7, 40, 20, 30);

        // Menu de escolha de Pokémons disponíveis
        System.out.println("Escolha um Pokémon:");
        System.out.println("(1) Charmander");
        System.out.println("(2) Eevee");
        System.out.println("(3) Bulbasaur");
        int input = scan.nextInt();

        // Menu de ações
        int acao;
        do {
            System.out.println("\n-----Ações-----");
            System.out.println("(1) Capturar");
            System.out.println("(2) Libertar");
            System.out.println("(3) Brincar");
            System.out.println("(4) Alimentar");
            System.out.println("(5) Falar");
            System.out.println("(6) Evoluir");
            System.out.println("(0) Fim");
            acao = scan.nextInt();

            // o usuário só pode realizar as ações brincar, alimentar, falar e evoluir se já tiver capturado o pokémon.
            switch (acao) {
                case 1: // capturar
                    pokemons[input].capturar();
                    break;
                case 2: // libertar
                    pokemons[input].libertar();
                    break;
                case 3: // brincar
                    pokemons[input].brincar();
                    break;
                case 4: // alimentar
                    pokemons[input].alimentar();
                    break;
                case 5: // falar
                    pokemons[input].falar();
                    break;
                case 6: // evoluir
                    scan.nextLine(); // buffer
                    System.out.println("Para qual Pokémon você quer que " + pokemons[input].getNome() + " evolua?");
                    String pokeEvolucao = scan.nextLine();
                    System.out.println("Qual é o tipo desse Pokémon?");
                    String tipoEvolucao = scan.nextLine();
                    pokemons[input].evoluir(pokeEvolucao, tipoEvolucao);
                    break;
            }
        } while (acao != 0);
    }
}
