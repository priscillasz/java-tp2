package tp2.dojo2;

import java.util.Scanner;

public class Main {
    // tamanho máximo do vetor de alunos
    static final int MAX = 10; // escolhemos 10 para ficar mais fácil para testar

    // criação de vetor de alunos cadastrados
    static Aluno[] alunosCadastrados = new Aluno[MAX];

    // listagem de alunos cadastrados
    public static void listaAluno(int qtdAlunos){
        for (int i = 0; i < qtdAlunos; i++)
            System.out.println(alunosCadastrados[i].getNome());
    }

    // ADICIONAR ALUNO NOVO
    public static void addAluno(int i){
        // nova instancia/objeto da classe Scanner
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira os dados do novo aluno (matrícula, nome e idade):");
        int matricula = scan.nextInt();
        scan.nextLine(); // limpar o buffer do teclado
        String nome = scan.nextLine();
        int idade = scan.nextInt();

        alunosCadastrados[i] = new Aluno(matricula, nome, idade); // criação do novo objeto Aluno
        System.out.println("Aluno adicionado com sucesso!");
    }

    // DELETAR ALUNO
    public static void deletaAluno(int qtdAlunos){
        // nova instancia/objeto da classe Scanner
        Scanner scan = new Scanner(System.in);

        // lê a matrícula do aluno a ser deletado
        System.out.println("Insira a matrícula do aluno a ser deletado:");
        int numMatricula = scan.nextInt();

        boolean alunoExiste = false;
        int posicao = 0;

        // procura a posição da matrícula do aluno na array
        for (int i = 0; i < qtdAlunos; i++)
            if (numMatricula == alunosCadastrados[i].getMatricula()){
                posicao = i;
                alunoExiste = true;
            }

        // se a matrícula existir, procede deletando o aluno
        if (alunoExiste){
            for (int k = posicao; k < qtdAlunos-1; k++)
                alunosCadastrados[k] = alunosCadastrados[k+1];

            System.out.println("Aluno deletado com sucesso!");
        }
        else
            System.out.println("Aluno não encontrado.");
    }

    // LEITURA DE ATRIBUTOS DE UM ALUNO ESPECÍFICO
    public static void leAtributosAluno(int qtdAlunos){
        // nova instancia/objeto da classe Scanner
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira a matrícula do aluno específico:");
        int numMatricula = scan.nextInt();

        boolean alunoExiste = false;

        for (int i = 0; i < qtdAlunos; i++){
            if (numMatricula == alunosCadastrados[i].getMatricula()){
                System.out.println("Dados do aluno:");
                System.out.println("Matrícula: "+ alunosCadastrados[i].getMatricula());
                System.out.println("Nome: "+ alunosCadastrados[i].getNome());
                System.out.println("Idade: "+ alunosCadastrados[i].getIdade());
                alunoExiste = true;
            }
        }
        if (!alunoExiste) // caso o código de matrícula digitado não seja encontrado, então o aluno não existe.
            System.out.println("Aluno não encontrado.");
    }

    // ALTERAR IDADE DE UM ALUNO ESPECÍFICO
    public static void alteraIdade(int qtdAlunos){
        // nova instancia/objeto da classe Scanner
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira a matrícula do aluno a ter a idade alterada:");
        int numMatricula = scan.nextInt();

        for (int i = 0; i < qtdAlunos; i++){
            if (numMatricula == alunosCadastrados[i].getMatricula()){
                System.out.println("Insira a nova idade:");
                int novaIdade = scan.nextInt();
                alunosCadastrados[i].setIdade(novaIdade);
                System.out.println("Nova idade:"+alunosCadastrados[i].getIdade());
            }
        }
    }
    
    public static void main(String[] args) {
        // nova instancia/objeto da classe Scanner
        Scanner scan = new Scanner(System.in);

        int i = 0;
        //int qtdAlunos = 0;
        // menu com as opções. o usuário pode escolher ações até que 0 seja digitado, então o programa para.
        int opcao;
        do {
            System.out.println("O que deseja fazer?");
            System.out.println("(1) Listar todos os alunos");
            System.out.println("(2) Adicionar um novo aluno");
            System.out.println("(3) Deletar um aluno existente");
            System.out.println("(4) Ler os atributos de um aluno");
            System.out.println("(5) Alterar a idade de um aluno");
            System.out.println("(0) Sair do sistema");
            opcao = scan.nextInt();

            switch (opcao){
                case 1: // listar todos os alunos
                    listaAluno(i);
                    break;
                case 2: // adicionar um novo aluno
                    addAluno(i);
                    i++; // incrementa a quantidade de alunos qnd um novo é adicionado
                    break;
                case 3: // deletar um aluno existente
                    deletaAluno(i);
                    i--; // decrementa a quantidade de alunos qnd um é deletado
                    break;
                case 4: // ler os atributos de um aluno
                    leAtributosAluno(i);
                    break;
                case 5: // alterar a idade de um aluno
                    alteraIdade(i);
                    break;
                default:
                    break;
            }
        } while(opcao != 0);
    }
}
