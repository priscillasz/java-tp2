package tp2.dojo3;

import java.util.Random;

public abstract class Conta {
    // importação da classe Random + criação de uma instância para poder gerar um n aleatório pro número da conta
    Random random = new Random();

    // atributos
    protected String nome;
    protected int cpf;
    // data de nascimento -> vou colocar dps
    protected String email;
    protected int telefone;
    protected String senha;
    protected int agencia;
    protected int conta;

    public Conta(String nome, int cpf, String email, int telefone, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.agencia = 0001;
        this.conta = random.nextInt(99999);
    }

    // métodos abstratos aqui
    public abstract void sacar();
    public abstract void depositar();
    public abstract void emitirExtrato();
    public abstract void transferir();
    public abstract void configurarPix();
    public abstract void pagarBoleto();
}
