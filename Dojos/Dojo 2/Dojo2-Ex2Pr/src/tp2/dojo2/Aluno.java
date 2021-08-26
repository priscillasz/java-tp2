package tp2.dojo2;

public class Aluno {
    private int matricula;
    private String nome;
    private int idade;

    // construtor
    public Aluno(int matricula, String nome, int idade){
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
    }

    // getters e setters | code > generate > getters e setters > seleciona tds os elementos
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
