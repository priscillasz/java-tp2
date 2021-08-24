package tp2.dojo2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // criação da instância scan da classe Scanner para leitura de valores
        Scanner scan = new Scanner(System.in);

        // leitura dos atributos do pokemon
        System.out.println("Informações do Pokémon: ");
        System.out.println("Nome:");
        String nome = scan.nextLine();
        System.out.println("Tipo:");
        String tipo = scan.nextLine();
        System.out.println("Peso (em kg):");
        float peso = scan.nextFloat();
        System.out.println("Altura (em cm):");
        float altura = scan.nextFloat();
        System.out.println("Felicidade:");
        int felicidade = scan.nextInt();
        System.out.println("Chance de captura (%):");
        int chanceCaptura = scan.nextInt();

        // criação do objeto pokemon da classe Pokemon
       Pokemon pokemon = new Pokemon(nome, tipo, peso, altura, felicidade, chanceCaptura);

        // menu de ações
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

            switch(acao){
                case 1: // capturar
                    pokemon.capturar();
                    break;
                case 2: // libertar
                    pokemon.libertar();
                    break;
                case 3: // brincar
                    pokemon.brincar();
                    break;
                case 4: // alimentar
                    pokemon.alimentar();
                    break;
                case 5: // falar
                    pokemon.falar();
                    break;
                case 6: // evoluir
                    scan.nextLine();
                    System.out.println("Para qual Pokémon você quer que "+pokemon.getNome()+" evolua?");
                    String pokeEvolucao = scan.nextLine();
                    System.out.println("Qual é o tipo desse Pokémon?");
                    String tipoEvolucao = scan.nextLine();
                    pokemon.evoluir(pokeEvolucao, tipoEvolucao);
                    break;
            }

        } while (acao != 0);
    }
}
