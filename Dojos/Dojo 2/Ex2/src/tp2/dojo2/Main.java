package tp2.dojo2;

        /*                  Grupo:
        (Copiloto) João Gabriel Evelin D'Oliveira - 20202210036
        (Copiloto) Priscilla Aparecida Matias de Souza - 20202210023
        (Piloto) Udson Bonin Costa - 20192210024 */

import java.util.Scanner;

public class Main {

    // CRIAÇÃO DO VETOR DE ALUNOS ETC...
    static final int MAX = 10;

    static Aluno[] alunosCadastrados = new Aluno[MAX];

    // (1) LISTAGEM DE ALUNOS
    public static void listaAluno(int qtdAlunos){
        for (int i = 0; i< qtdAlunos; i++)
            System.out.println(alunosCadastrados[i].getNome());
    }

    // (2) ADICIONAR ALUNO NOVO
    public static void addAluno(int i){
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira os dados do novo aluno (matricula, nome e idade):");
        int matricula = scan.nextInt();
        scan.nextLine();
        String nome = scan.nextLine();
        int idade = scan.nextInt();

        alunosCadastrados[i] = new Aluno(matricula, nome, idade);
        System.out.println("Aluno adicionado com sucesso");
    }

    // (3) DELETAR ALUNO
    public static void deletaAluno(int qtdAlunos, boolean alunoExiste){
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira a matrícula do aluno a ser deletado:");
        int numMatricula = scan.nextInt();

        int posicao = 0;

        for (int i = 0; i< qtdAlunos; i++)
            if (numMatricula == alunosCadastrados[i].getMatricula()){
                posicao = i;
                alunoExiste = true;
            }
        if(alunoExiste){
            for (int k = posicao; k< qtdAlunos-1; k++)
                alunosCadastrados[k] = alunosCadastrados[k+1];
            System.out.println("Aluno deletado com sucesso!");

        }
        else
            System.out.println("Aluno não encontrado!");
    }

    // (4) LEITURA DE ATRIBUTOS DE UM ALUNO ESPECÍFICO
    public static void lerAtributosAluno(int qtdAlunos){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira a matrícula do aluno:");
        int numMatricula = scan.nextInt();

        boolean alunoExiste = false;

        for (int i = 0; i< qtdAlunos; i++){
            if (numMatricula == alunosCadastrados[i].getMatricula()){

                System.out.println("Dados do aluno:");
                System.out.println("Matrícula: "+ alunosCadastrados[i].getMatricula());
                System.out.println("Nome: "+ alunosCadastrados[i].getNome());
                System.out.println("Idade: " + alunosCadastrados[i].getIdade());
                alunoExiste = true;
            }
        }
        if (!alunoExiste)
            System.out.println("Aluno não encontrado");

    }

    // (5) ALTERAR IDADE DE UM ALUNO ESPECÍFICO
    public static void alteraIdade (int qtdAlunos){
        Scanner scan = new Scanner(System.in);

        boolean alunoExiste = false;

        System.out.println("Insira a matrícula do aluno cuja idade será alterada:");
        int numMatricula = scan.nextInt();
        for (int i = 0; i< qtdAlunos; i++){
            if(numMatricula == alunosCadastrados[i].getMatricula()){
                alunoExiste = true;
                System.out.println("Insira a nova idade:");
                int novaIdade = scan.nextInt();
                alunosCadastrados[i].setIdade(novaIdade);
                System.out.println("Idade alterada");

            }
        }
        if (!alunoExiste)
            System.out.println("Aluno não encontrado");
    }

    // MAIN
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i = 0;

        int opcao;

        do{
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Listar os alunos");
            System.out.println("2 - Adicionar aluno");
            System.out.println("3 - Deletar aluno");
            System.out.println("4 - Ler atributos do aluno");
            System.out.println("5 - Alterar idade");
            System.out.println("0 - Sair do sistema");
            opcao = scan.nextInt(); // Esquecemos de colocar durante a gravação.

            switch(opcao){
                case 1:
                    listaAluno(i);
                    break;
                case 2:
                    addAluno(i);
                    i++;
                    break;
                case 3:
                    boolean alunoExiste = false;
                    deletaAluno(i, alunoExiste);
                    if(alunoExiste)
                        i--;
                    break;
                case 4:
                    lerAtributosAluno(i);
                    break;
                case 5:
                    alteraIdade(i);
                    break;
                default:
                    if(opcao!=0)
                        System.out.println("Opção inválida");
                    break;
            }
        } while(opcao != 0);
    }
}
