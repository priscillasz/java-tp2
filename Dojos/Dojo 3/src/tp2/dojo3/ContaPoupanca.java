package tp2.dojo3;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class ContaPoupanca extends Conta implements TransacaoEmConta{
    private double saldo;
    private double salario;

    private double valor;
    private String desc;
    private int tipoOp;
    private Date dataOp;
    public ContaPoupanca(String nome, long cpf, LocalDate dataDeNascimento, String email, int telefone, String senha) {
        super(nome, cpf, dataDeNascimento, email, telefone, senha);
    }

    public ContaPoupanca(){
        this.saldo = saldo + salario;
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
    public void setCpf(long cpf) {
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
    public long getTelefone() {
        return super.getTelefone();
    }

    @Override
    public void setTelefone(long telefone) {
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

    // sets p usar junto da interface
    public void setValor(double valorOp) {
        this.valor = valorOp;
    }

    public void setDescricao(String descOp){
        this.desc = descOp;
    }

    public void setTipoOperacao(int operacao){
        this.tipoOp = operacao;
    }

    @Override
    public void setData(Date dataOp) {
        this.dataOp = dataOp;
    }

    // métodos da interface


    @Override
    public Date getData() {
        return dataOp;
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public String getDescricao() {
        return desc;
    }

    @Override
    public int getTipoOperacao() {
        return tipoOp;
    }

    //
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void addSalario(double pagamento) {
        saldo = saldo + pagamento;
    }

    // CONFIGURAÇÃO DO PIX
    public long pixCpf(){
        long pix = getCpf();
        return pix;
    }

    public String pixEmail(){
        String pix = getEmail();
        return pix;
    }

    public long pixTelefone(){
        long pix = getTelefone();
        return pix;
    }

    public int pixChaveAleatoria(){
        Random naosei = new Random();
        int pix = naosei.nextInt(99999999);
        return pix;
    }
    // metodos herdados
    @Override
    public void sacar(double valor) {
        if (valor < saldo){
            saldo -= valor;
            System.out.println("Saque realizado com sucesso. Valor em conta: "+saldo);
        }
        else{
            System.out.println("Operação inválida. Não há saldo suficiente em conta. Valor em conta: "+saldo);


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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Como deseja configurar o Pix?");
        System.out.println("1 - Cpf");
        System.out.println("2 - Email");
        System.out.println("3 - Telefone");
        System.out.println("4 - Chave aleatória");
        int opcao = scanner.nextInt();

        if (opcao == 1){
            pixCpf();
        }
        else if (opcao == 2){
            pixEmail();
        }
        else if (opcao == 3){
            pixTelefone();
        }
        else if (opcao == 4){

        }

    }

    @Override
    public void pagarBoleto() {

    }
}
