package tp2.dojo3;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TesteMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // instâncias
        ContaCorrente contaC = new ContaCorrente();
        ContaPoupanca contaP = new ContaPoupanca();

        // arraylists
        ArrayList<String> listaDescricao = new ArrayList<>();
        ArrayList<Integer> listaOperacao = new ArrayList<>();
        ArrayList<Double> listavalor = new ArrayList<>();
        ArrayList<LocalDate> listaDatas = new ArrayList<>();

        // variáveis
        int opcao, tipoConta, ehSalario, diaPag;
        double salario;

        boolean corrente = false;
        boolean poupanca = false;

        boolean salarioRecebido = false;

        long cpf, telefone;
        int dia, mes, ano;
        String nomePessoa, emailPessoa, senhaPessoa;
        int avancar, diasAvancar;

        Date d;
        Calendar c = Calendar.getInstance();
        LocalDate novaData;

        do {
            // avanço no tempo
            if (corrente || poupanca) {
                System.out.println("1- Avançar dias");
                System.out.println("2- Avançar para o próximo mês");
                System.out.println("3- Avançar para o próximo dia de pagamento");
                System.out.println("0- Continuar");
                avancar = scan.nextInt();
                if (avancar == 1){ // avançar x dias
                    System.out.println("Quantos dias?");
                    diasAvancar = scan.nextInt();
                    c.add(Calendar.DATE, diasAvancar);
                    d = c.getTime();
                }
                else if (avancar == 2) { // avançar proximo mes
                    c.add(Calendar.MONTH, 1);
                    d = c.getTime();
                    double rendimentoSaldo = contaP.getSaldo() + (contaP.getSaldo() * 0.3);
                    contaP.setSaldo(rendimentoSaldo);
                }
                else { // 0
                    d = c.getTime();
                }
            }
            else {
                d = c.getTime();
            }

            // formata a data
            novaData = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(d));

            /* A primeira conta a ser criada tem a opção de ser salário ou não. A segunda conta criada nunca é salário. */
            // adicionar salário
            if (contaC.getDiaPagamento() <= novaData.getDayOfMonth()) {
                contaC.addSalario(contaC.getSalario());
            }
            else if (contaP.getDiaPagamento() <= novaData.getDayOfMonth()) {
                contaP.addSalario(contaP.getSalario());
            }

            // intro
            System.out.println("Seja bem-vindo(a)!");
            System.out.println(novaData+"\n");
            System.out.println("Conta corrente: "+contaC.getSaldo());
            System.out.println("Conta poupança: "+contaP.getSaldo());

            // MENU
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Abrir conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Emitir extrato");
            System.out.println("5 - Transferência");
            System.out.println("6 - Configurar Pix");
            System.out.println("7 - Pagar boleto");
            System.out.println("0 - Sair");
            opcao = scan.nextInt();

            switch (opcao){
                case 1: // adicionar conta
                    System.out.println("Qual tipo de conta você quer criar? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    if (tipoConta == 1){
                        if (!corrente && !poupanca){
                            corrente = true;

                            System.out.println("Nome completo");
                            scan.nextLine(); // buffer
                            nomePessoa = scan.nextLine();

                            System.out.println("Cpf (somente números):");
                            cpf = scan.nextLong();

                            System.out.println("Data de nascimento (dia, mês e ano)");
                            System.out.println("Dia:");
                            dia = scan.nextInt();
                            System.out.println("Mês:");
                            mes = scan.nextInt();
                            System.out.println("Ano:");
                            ano = scan.nextInt();
                            LocalDate anoNascimento = LocalDate.of(ano, mes, dia);

                            scan.nextLine(); // buffer
                            System.out.println("Email:");
                            emailPessoa = scan.nextLine();

                            System.out.println("Telefone:");
                            telefone = scan.nextLong();

                            scan.nextLine(); // buffer
                            System.out.println("Senha:");
                            senhaPessoa = scan.nextLine();

                            // perguntar se a conta é salario
                            System.out.println("É conta-salário? (1- Sim, 2- Não)");
                            ehSalario = scan.nextInt();

                            if (ehSalario == 1){
                                // salario
                                System.out.println("Informe o salário:");
                                salario = scan.nextDouble();

                                contaC.setSalario(salario);
                                // contaC.addSalario(salario);
                                // data de pagamento
                                 System.out.println("Informe o dia do pagamento:");
                                 diaPag = scan.nextInt();
                                 contaC.setDiaPagamento(diaPag);
                            }
                            else
                                continue;

                            // settar os atributos
                            contaC.setNome(nomePessoa);
                            contaC.setDataDeNascimento(anoNascimento);
                            contaC.setCpf(cpf);
                            contaC.setEmail(emailPessoa);
                            contaC.setTelefone(telefone);
                            contaC.setSenha(senhaPessoa);

                            System.out.println("Sua conta corrente foi criada com sucesso.");
                        }
                        else if (!corrente && poupanca){
                            corrente = true;
                            contaC.setNome(contaP.getNome());
                            contaC.setDataDeNascimento(contaP.getDataDeNascimento());
                            contaC.setCpf(contaP.getCpf());
                            contaC.setEmail(contaP.getEmail());
                            contaC.setTelefone(contaP.getTelefone());
                            contaC.setSenha(contaP.getSenha());
                            System.out.println("Conta corrente criada com sucesso. ");
                        }
                        else if (corrente && !poupanca){
                            System.out.println("Você já tem uma conta corrente. ");
                        }
                        else if(corrente && poupanca){
                            System.out.println("Você já tem as duas contas.");
                        }
                    }
                    if (tipoConta == 2){
                        if (!corrente && !poupanca){
                            poupanca = true;

                            System.out.println("Nome completo");
                            scan.nextLine(); // buffer
                            nomePessoa = scan.nextLine();

                            System.out.println("Cpf (somente números):");
                            cpf = scan.nextLong();

                            System.out.println("Data de nascimento (dia, mês e ano)");
                            dia = scan.nextInt();
                            mes = scan.nextInt();
                            ano = scan.nextInt();

                            scan.nextLine(); // buffer

                            System.out.println("Email:");
                            emailPessoa = scan.nextLine();

                            System.out.println("Telefone:");
                            telefone = scan.nextLong();

                            scan.nextLine(); // buffer
                            System.out.println("Senha:");
                            senhaPessoa = scan.nextLine();

                            // perguntar se a conta é salario
                            System.out.println("É conta-salário? (1- Sim, 2- Não)");
                            ehSalario = scan.nextInt();

                            if (ehSalario == 1){
                                // salario
                                System.out.println("Informe o salário:");
                                salario = scan.nextDouble();

                                contaP.setSalario(salario);
                                // contaP.addSalario(salario);

                                // data de pagamento
                                System.out.println("Informe o dia do pagamento:");
                                diaPag = scan.nextInt();
                                contaP.setDiaPagamento(diaPag);
                            }
                            else
                                continue;

                            // setters
                            LocalDate anoNascimento = LocalDate.of(ano, mes, dia);
                            contaP.setNome(nomePessoa);
                            contaP.setDataDeNascimento(anoNascimento);
                            contaP.setCpf(cpf);
                            contaP.setEmail(emailPessoa);
                            contaP.setTelefone(telefone);
                            contaP.setSenha(senhaPessoa);
                            System.out.println("Sua conta poupança foi criada com sucesso. ");
                        }
                        else if (corrente && !poupanca){
                            poupanca = true;
                            contaP.setNome(contaC.getNome());
                            contaP.setDataDeNascimento(contaC.getDataDeNascimento());
                            contaP.setCpf(contaC.getCpf());
                            contaP.setEmail(contaC.getEmail());
                            contaP.setTelefone(contaC.getTelefone());
                            contaP.setSenha(contaC.getSenha());
                            System.out.println("Conta poupança criada com sucesso. ");
                        }
                        else if (!corrente && poupanca){
                            System.out.println("Você já tem uma conta poupança.");
                        }
                        else if (corrente && poupanca){
                            System.out.println("Você já tem as duas contas. (poupança aqui)");
                        }
                    }
                    break;
                case 2: // depositar
                    System.out.println("Em qual conta você quer depositar? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    System.out.println("Insira o valor a ser depositado: ");
                    double valorDeposito = scan.nextDouble();
                    if (tipoConta == 1 && corrente){
                        contaC.depositar(valorDeposito);

                        // extrato
                        contaC.setValor(valorDeposito);
                        contaC.setTipoOperacao(opcao);
                        contaC.setDescricao("Depósito em conta corrente");
                        contaC.setData(novaData);

                        listavalor.add(contaC.getValor());
                        listaOperacao.add(contaC.getTipoOperacao());
                        listaDescricao.add(contaC.getDescricao());
                        listaDatas.add(contaC.getData());
                    }
                    else if (tipoConta == 1 && !corrente){
                        System.out.println("Você não possui conta corrente.");
                    }
                    else if (tipoConta == 2 && poupanca){
                        contaP.depositar(valorDeposito);

                        // extrato
                        contaP.setValor(valorDeposito);
                        contaP.setTipoOperacao(opcao);
                        contaP.setDescricao("Depósito em conta poupança");
                        contaP.setData(novaData);

                        listavalor.add(contaP.getValor());
                        listaOperacao.add(contaP.getTipoOperacao());
                        listaDescricao.add(contaP.getDescricao());
                        listaDatas.add(contaP.getData());
                    }
                    else if (tipoConta == 2 && !poupanca)
                        System.out.println("Você não possui conta poupança.");

                    break;
                case 3: // sacar
                    System.out.println("De qual conta você quer sacar? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    System.out.println("Insira o valor a ser sacado:");
                    double valorSaque = scan.nextDouble();

                    // adicionar a excessao: if tipoconta == 1 e corrente -> sacar
                    // if tipoconta == 1 e !corrente -> vc n tem corrente
                    // if tipoconta == 2 e poupanca -> sacar
                    // if tipoconta == 2 e !poupanca -> vc n tem poupança
                    if (tipoConta == 1)
                        contaC.sacar(valorSaque);
                    else if (tipoConta == 2)
                        contaP.sacar(valorSaque);
                    break;
                case 4: // emitir extrato
                    // imprime aqui tds as coisas
                    int tam = listaDescricao.size();

                    // falta só deixar bonito
                    System.out.println("Data     Operação       Descrição               Valor");
                    for (int i = 0; i < tam; i++){
                        System.out.println(listaDatas.get(i)+" "+listaOperacao.get(i)+" "+listaDescricao.get(i)+" "+listavalor.get(i));
                    }
                    // pergunta se o usuário quer os detalhes de algum item
                    System.out.println("Deseja visualizar os detalhes de algum item? (1 - sim 0 - não)");
                    int verItem = scan.nextInt();

                        // se sim, então imprime os detalhes do item
                        if (verItem == 1) {
                            System.out.println("Insira o número do item que quer visualizar:");
                            int viewItem = scan.nextInt();

                            for (int i = 0; i < tam; i++) {
                                if (i == viewItem) {
                                    // print os detalhes aqui...
                                }
                            }
                        }
                        // se não, sai
                    break;
                case 5: // transferência
                    // pergunta de qual conta quer tirar o dinheiro p transferir
                        // se for corrente e existir...

                    // pergunta o método de transferencia: agencia/conta ou pix
                        // if agencia/conta, checa se a conta existe
                            // procede e pergunta a qtd de dinheiro
                                // se tiver essa qtd, então transfere
                    break;
                case 6: // configurar pix
                    System.out.println("Deseja configurar o Pix de qual conta? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    if (tipoConta == 1 && corrente){
                        contaC.configurarPix();
                        System.out.println("Pix configurado com sucesso!");
                    }
                    else if (tipoConta == 1 && !corrente)
                        System.out.println("Você não possui uma conta corrente.");
                    else if (tipoConta == 2 && poupanca){
                        contaP.configurarPix();
                        System.out.println("Pix configurado com ssucesso.");
                    }
                    else if (tipoConta == 2 && !poupanca)
                        System.out.println("Você não possui uma conta poupança.");
                    break;
                case 7: // pagar boleto
                    // escolher qual conta vai usar para pagar o boleto
                    System.out.println("Com qual conta quer pagar o boleto? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    // if tipoconta == 1 e corrente -> contaC.pagarboleto();
                    if (tipoConta == 1 && corrente) {
                        contaC.pagarBoleto(novaData);
                    }
                    // if tipoconta == 1 e !corrente -> "você não possui conta corrente"
                    else if (tipoConta == 1 && !corrente) {
                        System.out.println("Você não possui conta corrente.");
                    }
                    // if tipoconta == 2 e poupanca -> contaP.pagarboleto();
                    else if (tipoConta == 2 && poupanca) {

                    }
                    // if tipoconta == 2 e !poupanca -> "você não possui conta poupança"
                    else if (tipoConta == 2 && !poupanca) {
                        System.out.println("Você não possui conta poupança.");
                    }
                    break;
                default:
                    if (opcao != 0)
                        System.out.println("Opção inválida.");
                    break;
            }
        }while(opcao !=0);

        // teste output
        System.out.println("Conta corrente");
        System.out.println("Nome: "+contaC.getNome());
        System.out.println("Data de nascimento: "+ contaC.getDataDeNascimento());
        System.out.println("Cpf: "+ contaC.getCpf());
        System.out.println("Email: "+ contaC.getEmail());
        System.out.println("Telefone: "+ contaC.getTelefone());
        System.out.println("Senha: "+ contaC.getSenha());
        System.out.println("Salário: "+ contaC.getSalario());
        System.out.println("Conta: "+ contaC.getConta());
        System.out.println("Agência: "+ contaC.getAgencia());
        System.out.println("Saldo: "+ contaC.getSaldo());

        System.out.println("\n");
        System.out.println("Conta Poupança");
        System.out.println("Nome: "+contaP.getNome());
        System.out.println("Data de nascimento: "+contaP.getDataDeNascimento());
        System.out.println("Cpf: "+ contaP.getCpf());
        System.out.println("Email: "+ contaP.getEmail());
        System.out.println("Telefone: "+ contaP.getTelefone());
        System.out.println("Senha: "+ contaP.getSenha());
        System.out.println("Salário: "+ contaP.getSalario());
        System.out.println("Conta: "+ contaP.getConta());
        System.out.println("Agência: "+ contaP.getAgencia());
    }
}
