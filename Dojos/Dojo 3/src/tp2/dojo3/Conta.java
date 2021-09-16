package tp2.dojo3;

import java.time.LocalDate;
import java.util.Random;

public abstract class Conta {
    // importação da classe Random + criação de uma instância para poder gerar um n aleatório pro número da conta
    Random random = new Random();

    // atributos
    protected String nome;
    protected long cpf;
    protected LocalDate dataDeNascimento;
    protected String email;
    protected long telefone;
    protected String senha;
    protected String agencia;
    protected int conta;

    // Construtores
    public Conta(String nome, long cpf, LocalDate dataDeNascimento, String email, long telefone, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.agencia = "0001";
        this.conta = random.nextInt(99999);
    }

    public Conta(){
        this.agencia = "0001";
        this.conta = random.nextInt(99999);
    }

    // getters e setters
    public Random getRandom() { return random; }

    public void setRandom(Random random) { this.random = random; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public long getCpf() { return cpf; }

    public void setCpf(long cpf) { this.cpf = cpf; }

    public LocalDate getDataDeNascimento() { return dataDeNascimento; }

    public void setDataDeNascimento(LocalDate dataDeNascimento) { this.dataDeNascimento = dataDeNascimento; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public long getTelefone() { return telefone; }

    public void setTelefone(long telefone) { this.telefone = telefone; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public String getAgencia() { return agencia; }

    public void setAgencia(String agencia) { this.agencia = agencia; }

    public int getConta() { return conta; }

    public void setConta(int conta) { this.conta = conta; }

    // métodos abstratos aqui
    public abstract void sacar(double valor);
    public abstract void depositar(double valor);
    public abstract boolean transferir(double valor);
    public abstract void configurarPix();
    public abstract boolean pagarBoleto(LocalDate pagamento, LocalDate vencimento, double valorBoleto);
}
