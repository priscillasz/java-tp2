package tp2.dojo3;

import java.time.LocalDate;
import java.util.Random;

public class ContaCorrente extends Conta {
    private double chequeEspecial = 3000;
    private double salario;
    private double saldo;

    public ContaCorrente(String nome, long cpf, LocalDate dataDeNascimento, String email, int telefone, String senha) {
        super(nome, cpf, dataDeNascimento, email, telefone, senha);

    }

    public ContaCorrente() {

    }

    // getters e setters
    @Override
    public Random getRandom() {
        return super.getRandom();
    }

    @Override
    public void setRandom(Random random) {
        super.setRandom(random);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public long getCpf() {
        return super.getCpf();
    }

    @Override
    public void setCpf(int cpf) {
        super.setCpf(cpf);
    }

    @Override
    public LocalDate getDataDeNascimento() {
        return super.getDataDeNascimento();
    }

    @Override
    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        super.setDataDeNascimento(dataDeNascimento);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public int getTelefone() {
        return super.getTelefone();
    }

    @Override
    public void setTelefone(int telefone) {
        super.setTelefone(telefone);
    }

    @Override
    public String getSenha() {
        return super.getSenha();
    }

    @Override
    public void setSenha(String senha) {
        super.setSenha(senha);
    }

    @Override
    public String getAgencia() {
        return super.getAgencia();
    }

    @Override
    public void setAgencia(String agencia) {
        super.setAgencia(agencia);
    }

    @Override
    public int getConta() {
        return super.getConta();
    }

    @Override
    public void setConta(int conta) {
        super.setConta(conta);
    }

    //

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // métodos herdados
    @Override
    public void sacar(double valor) {
        if (valor < saldo){
            saldo -= valor;
            System.out.println("Saque realizado com sucesso. Valor em conta: "+getSaldo());
        }
        else {
            // double saldoRetirar = valor - (valor - saldo);
            double sobra = valor - saldo;
            if (chequeEspecial >= sobra){
                chequeEspecial -= sobra;
                saldo -= saldo;
                System.out.println("Saque realizado com sucesso. Valor em conta: "+getSaldo()+" Valor restante do cheque especial: "+chequeEspecial);
            }
            else if (chequeEspecial < sobra) {
                System.out.println("Operação inválida. Valor em conta não é suficiente e não há cheque especial disponível.");
                System.out.println("Valor em conta: "+saldo+" Valor restante do cheque especial: "+chequeEspecial);
            }
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso. Valor em conta: "+saldo);
    }

    @Override
    public void emitirExtrato() {

    }

    @Override
    public void transferir() {

    }

    @Override
    public void configurarPix() {

    }

    @Override
    public void pagarBoleto() {

    }
}
