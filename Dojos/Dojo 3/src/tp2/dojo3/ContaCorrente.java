package tp2.dojo3;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class ContaCorrente extends Conta implements TransacaoEmConta {
    private double chequeEspecial = 3000;
    private double salario;
    private double saldo;
    private int diaPagamento;

    // interface
    private double valor;
    private String desc;
    private int tipoOp;
    private LocalDate dataOp;

    // construtores
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

    // métodos da interface
    public void setValor(double valorOp) {
        this.valor = valorOp;
    }

    public void setDescricao(String descOp){
        this.desc = descOp;
    }

    public void setTipoOperacao(int operacao){
        this.tipoOp = operacao;
    }

    public void setData(LocalDate dataOp){ this.dataOp = dataOp; }

    @Override
    public LocalDate getData() { return dataOp; }

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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void addSalario(double pagamento) {
        saldo = saldo + pagamento;
    }

    public void setDiaPagamento(int diaPagamento) { this.diaPagamento = diaPagamento; }

    public int getDiaPagamento() { return diaPagamento; }



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
            pixChaveAleatoria();
        }
    }

    @Override
    public void pagarBoleto(LocalDate pagamento) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pagamento de boleto:");
        System.out.println("Código de barras (48 dígitos):");
        String codigoBarras = scanner.nextLine();
        System.out.println("Valor:");
        double valorBoleto = scanner.nextLong();

        // leitura da data
        System.out.println("Data de vencimento:");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int ano = scanner.nextInt();
        LocalDate vencimento = LocalDate.of(ano, mes, dia);

        // LocalDate pagamento = LocalDate.now();

        // if data de vencimento >= data atual -> procede p pagar sem multa
        if (pagamento.isBefore(vencimento) || pagamento.isEqual(vencimento)) {
            // if valorBoleto > saldo -> não há saldo suficiente, n tem como pagar
            if (valorBoleto > saldo) {
                System.out.println("Não há saldo suficiente em conta.");
            }
            // else if valorBoleto <= saldo -> subtrai o valor do saldo e confirma o pagamento (saldo = saldo - valorBoleto)
            else {
                saldo = saldo - valorBoleto;
                System.out.println("Pagamento de boleto realizado com sucesso.");
            }
        }
        // if data de vencimento < data atual -> boleto vencido, procede p pagar com multa de 0,1 por dia atrasado
        else if (pagamento.isAfter(vencimento)) {
            // calcula dias de atraso no pagamento -> calcula novo valor do boleto

            // if valorBoleto > saldo -> não há saldo suficiente, n tem como pagar (saldo = saldo - (valorBoleto + (valorBoleto * 0.1)
            if (valorBoleto > saldo) {

            }
            // else if valorBoleto <= saldo -> subtrai o valor do saldo e confirma o pagamento (saldo = saldo - (valorBoleto + (valorBoleto * 0.1)
            else {

            }
        }
    }
}
