package tp2.dojo3;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import java.util.InputMismatchException;

public class TesteMain {
    // arraylists
    static ArrayList<String> listaDescricao = new ArrayList<>();
    static ArrayList<String> listaOperacao = new ArrayList<>();
    static ArrayList<Double> listavalor = new ArrayList<>();
    static ArrayList<LocalDate> listaDatas = new ArrayList<>();

    // adicionar dados de cada operação na lista do extrato
    public static void addToList(double valor, String descricao, String operacao, LocalDate dataOperacao) {
        listavalor.add(valor);
        listaDatas.add(dataOperacao);
        listaDescricao.add(descricao);
        listaOperacao.add(operacao);
    }

    public static void main(String[] args) {
        // instância da classe Scanner
        Scanner scan = new Scanner(System.in);

        // instâncias
        ContaCorrente contaC = new ContaCorrente();
        ContaPoupanca contaP = new ContaPoupanca();

        // arraylist com detalhes de cada item do extrato
        ArrayList listaDetalhes = new ArrayList();

        // variáveis
        int opcao, tipoConta, ehSalario, diaPag;
        double salario;
        double valorBoleto;
        double rendimentoSaldo;

        boolean corrente = false;
        boolean poupanca = false;

        boolean salarioRecebido = false;
        boolean poupancaSalario = false;
        boolean correnteSalario = false;
        boolean novoMes = false;

        boolean saqueConcluido = false; // apagar dps???
        boolean transferenciaConcluida = false;
        boolean pagBoletoConcluido = false;

        long cpf, telefone;
        int dia, mes, ano;
        String nomePessoa, emailPessoa, senhaPessoa;
        int avancar, diasAvancar;

        // datas
        Date d;
        Calendar c = Calendar.getInstance();
        LocalDate novaData;
        LocalDate anoNascimento;
        LocalDate atual;

        LocalDate inicio = LocalDate.now();
        int diaInicio = inicio.getDayOfMonth();
        int mesInicio = inicio.getMonthValue();

        int diaAtual = 0, mesAtual;

        int meses = 0;
        boolean testeMeses = false;

        do {
            // avanço no tempo
            if (corrente || poupanca) {
                System.out.println("1- Avançar dias");
                System.out.println("0- Continuar");
                avancar = scan.nextInt();
                if (avancar == 1){ // avançar x dias
                    System.out.println("Quantos dias?");
                    diasAvancar = scan.nextInt();
                    c.add(Calendar.DATE, diasAvancar);

                    d = c.getTime();

                    // converte para LocalDate
                    atual = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(d));
                    // pega o dia
                    diaAtual = atual.getDayOfMonth();
                    mesAtual = atual.getMonthValue();

                    if (mesAtual != mesInicio) {
                        salarioRecebido = false;
                        novoMes = true;
                        if (mesAtual - mesInicio != 0) {
                            if (mesAtual > mesInicio) {
                                meses = mesAtual - mesInicio;
                            }
                            else {
                                meses = 12 - mesInicio + mesAtual;
                            }
                            System.out.println("Atual: "+mesAtual); // apagar dps
                            System.out.println("Inicio: "+mesInicio); // apagar dps
                            System.out.println("Meses: "+meses); // apagar dps
                            testeMeses = true;
                        }
                        mesInicio = mesAtual;
                    }
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

            // adicionar salário
            if (contaC.getDiaPagamento() <= novaData.getDayOfMonth() && correnteSalario) {
                if (salarioRecebido && !testeMeses) {
                    System.out.println("nada"); // apagar isso dps
                }
                else if (!salarioRecebido && !testeMeses) {
                    contaC.addSalario(contaC.getSalario());
                    System.out.println("to aqui"); // apagar isso dps
                    salarioRecebido = true;
                }
                else if (!salarioRecebido && testeMeses) {
                    double novoSalario = meses * contaC.getSalario();
                    System.out.println("novo salario: "+novoSalario+" Meses: "+meses);
                    contaC.addSalario(novoSalario);
                    salarioRecebido = true;
                    testeMeses = false;
                }
            }
            else if (contaP.getDiaPagamento() <= novaData.getDayOfMonth() && poupancaSalario) {
                if (salarioRecebido && !testeMeses) {
                    System.out.println("nada"); // apagar isso dps
                }
                else if (!salarioRecebido && !testeMeses) {
                    contaP.addSalario(contaP.getSalario());
                    System.out.println("to aqui"); // apagar isso dps
                    salarioRecebido = true;
                }
                else if (!salarioRecebido && testeMeses) {
                    double novoSalario = meses * contaP.getSalario();
                    System.out.println("novo salario: "+novoSalario+" Meses: "+meses);
                    contaP.addSalario(novoSalario);
                    salarioRecebido = true;
                    testeMeses = false;
                }
            }

            // rendimento
            if (diaAtual >= diaInicio && novoMes) {
                rendimentoSaldo = contaP.getSaldo() + (contaP.getSaldo() * 0.3);
                contaP.setSaldo(rendimentoSaldo);
                novoMes = false;
            }

            /* *************INTRO************** */
            System.out.println("\nSeja bem-vindo(a)!");
            System.out.println(novaData+"\n");
            System.out.println("Conta corrente: "+contaC.getSaldo());
            System.out.println("Conta poupança: "+contaP.getSaldo()+"\n");

            ////////////// MENU ////////////////
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
                case 1: // ADICIONAR CONTA
                    System.out.println("Qual tipo de conta você quer criar? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    // valida se o tipo de conta existe
                    if (tipoConta != 1 && tipoConta != 2) {
                        System.out.println("Tipo de conta não existe.");
                        break;
                    }

                    if (tipoConta == 1){
                        if (!corrente && !poupanca){ // abrir conta corrente quando nenhuma das contas existe
                            corrente = true;

                            System.out.println("Nome completo:");
                            scan.nextLine(); // buffer
                            nomePessoa = scan.nextLine();

                            /*System.out.println("Cpf (somente números):");
                            cpf = scan.nextLong();*/

                            try { // arrumar isso aqui dps
                                System.out.println("Cpf (somente números):");
                                cpf = scan.nextLong();
                            } catch(InputMismatchException e2) {
                                System.out.println("Apenas números.");
                            } finally {
                                System.out.println("Cpf (somente números):");
                                cpf = scan.nextLong();
                            }

                            System.out.println("Data de nascimento (dia, mês e ano)");
                            System.out.println("Dia:");
                            dia = scan.nextInt();
                            System.out.println("Mês:");
                            mes = scan.nextInt();
                            System.out.println("Ano:");
                            ano = scan.nextInt();
                            anoNascimento = LocalDate.of(ano, mes, dia);

                            // compara data de nascimento com a data atual... se a diferença for menor que 18, a pessoa n pode criar uma conta
                            Period p = Period.between(anoNascimento, novaData);

                            // menores de 18 não podem criar contas
                            if (p.getYears() < 18)
                                throw new ArithmeticException("Menores de 18 anos não podem criar contas");

                            scan.nextLine(); // buffer
                            System.out.println("Email:");
                            emailPessoa = scan.nextLine();

                            System.out.println("Telefone (somente números):");
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
                                // data de pagamento
                                 System.out.println("Informe o dia do pagamento:");
                                 diaPag = scan.nextInt();
                                 contaC.setDiaPagamento(diaPag);

                                 correnteSalario = true;
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
                        else if (!corrente && poupanca){ // abrir conta corrente quando a poupança já existe
                            corrente = true;
                            contaC.setNome(contaP.getNome());
                            contaC.setDataDeNascimento(contaP.getDataDeNascimento());
                            contaC.setCpf(contaP.getCpf());
                            contaC.setEmail(contaP.getEmail());
                            contaC.setTelefone(contaP.getTelefone());
                            contaC.setSenha(contaP.getSenha());

                            if (!correnteSalario && !poupancaSalario) {
                                System.out.println("É conta-salário? (1- Sim, 2- Não)");
                                ehSalario = scan.nextInt();

                                if (ehSalario == 1) {
                                    // salario
                                    System.out.println("Informe o salário:");
                                    salario = scan.nextDouble();
                                    // validar salario -> tem q ser > 0
                                    System.out.println("Informe o dia do pagamento:");
                                    diaPag = scan.nextInt();
                                    contaC.setSalario(salario);
                                    contaC.setDiaPagamento(diaPag);

                                    correnteSalario = true;
                                }
                            }
                            else
                                continue;
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
                        if (!corrente && !poupanca){ // abrir conta poupança quando nenhuma das contas existe ainda
                            poupanca = true;

                            System.out.println("Nome completo:");
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
                            anoNascimento = LocalDate.of(ano, mes, dia);

                            // compara data de nascimento com a data atual... se a diferença for menor que 18, a pessoa n pode criar uma conta
                            Period p = Period.between(anoNascimento, novaData);

                            // menores de 18 não podem criar contas
                            if (p.getYears() < 18)
                                throw new ArithmeticException("Menores de 18 anos não podem criar contas");

                            scan.nextLine(); // buffer
                            System.out.println("Email:");
                            emailPessoa = scan.nextLine();

                            System.out.println("Telefone (somente números):");
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

                                // data de pagamento
                                System.out.println("Informe o dia do pagamento:");
                                diaPag = scan.nextInt();
                                contaP.setDiaPagamento(diaPag);

                                poupancaSalario = true;
                            }
                            else
                                continue;

                            // setters
                            contaP.setNome(nomePessoa);
                            contaP.setDataDeNascimento(anoNascimento);
                            contaP.setCpf(cpf);
                            contaP.setEmail(emailPessoa);
                            contaP.setTelefone(telefone);
                            contaP.setSenha(senhaPessoa);
                            System.out.println("Sua conta poupança foi criada com sucesso. ");
                        }
                        else if (corrente && !poupanca) { // abrir poupança quando conta corrente já existe
                            poupanca = true;
                            contaP.setNome(contaC.getNome());
                            contaP.setDataDeNascimento(contaC.getDataDeNascimento());
                            contaP.setCpf(contaC.getCpf());
                            contaP.setEmail(contaC.getEmail());
                            contaP.setTelefone(contaC.getTelefone());
                            contaP.setSenha(contaC.getSenha());

                            if (!poupancaSalario && !correnteSalario) {
                                System.out.println("É conta-salário? (1- Sim, 2- Não)");
                                ehSalario = scan.nextInt();

                                if (ehSalario == 1) {
                                    // salario
                                    System.out.println("Informe o salário:");
                                    salario = scan.nextDouble();
                                    // validar salario -> tem q ser > 0
                                    System.out.println("Informe o dia do pagamento:");
                                    diaPag = scan.nextInt();
                                    contaP.setSalario(salario);
                                    contaP.setDiaPagamento(diaPag);
                                    poupancaSalario = true;
                                }
                            }
                            System.out.println("Conta poupança criada com sucesso.");
                        }
                        else if (!corrente && poupanca) {
                            System.out.println("Você já tem uma conta poupança.");
                        }
                        else if (corrente && poupanca){
                            System.out.println("Você já tem as duas contas. (poupança aqui)");
                        }
                    }
                    break;
                case 2: // DEPOSITAR
                    System.out.println("Em qual conta você quer depositar? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    // valida se o tipo de conta existe
                    if (tipoConta != 1 && tipoConta != 2) {
                        System.out.println("Tipo de conta não existe.");
                        break;
                    }

                    // valor de depósito
                    System.out.println("Insira o valor a ser depositado: ");
                    double valorDeposito = scan.nextDouble();

                    // valida valor de depósito
                    if (valorDeposito <= 0) {
                        System.out.println("Valor inválido.");
                        break;
                    }

                    if (tipoConta == 1 && corrente) {
                        contaC.depositar(valorDeposito);

                        // extrato
                        contaC.setValor(valorDeposito);
                        contaC.setTipoOperacao("Depósito");
                        contaC.setDescricao("Depósito em conta corrente");
                        contaC.setData(novaData);

                        addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());
                        /*listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());*/
                    }
                    else if (tipoConta == 1 && !corrente) {
                        System.out.println("Você não possui conta corrente.");
                    }
                    else if (tipoConta == 2 && poupanca) {
                        contaP.depositar(valorDeposito);

                        // extrato
                        contaP.setValor(valorDeposito);
                        contaP.setTipoOperacao("Depósito");
                        contaP.setDescricao("Depósito em conta poupança");
                        contaP.setData(novaData);

                        addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                        /*listaDetalhes.add("Tipo de Operação: "+contaP.getTipoOperacao()+"\nDescrição: "+contaP.getDescricao()+
                                "\nData: "+contaP.getData()+"\nValor: "+contaP.getValor());*/
                    }
                    else if (tipoConta == 2 && !poupanca)
                        System.out.println("Você não possui conta poupança.");
                    break;
                case 3: // SACAR
                    System.out.println("De qual conta você quer sacar? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    // valida se o tipo de conta existe
                    if (tipoConta != 1 && tipoConta != 2) {
                        System.out.println("Tipo de conta não existe.");
                        break;
                    }

                    // valor a sacar
                    System.out.println("Insira o valor a ser sacado:");
                    double valorSaque = scan.nextDouble();

                    // valida valor de saque
                    if (valorSaque <= 0) {
                        System.out.println("Valor inválido.");
                        break;
                    }

                    if (tipoConta == 1 && corrente) {
                        contaC.sacar(valorSaque);
                        // extrato
                        contaC.setValor(valorSaque);
                        contaC.setTipoOperacao("Saque");
                        contaC.setDescricao("Saque em conta corrente.");
                        contaC.setData(novaData);

                        addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());
                        /*listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());*/
                    }
                    else if (tipoConta == 1 && !corrente) {
                        System.out.println("Você não possui conta corrente.");
                    }
                    else if (tipoConta == 2 && poupanca) {
                        contaP.sacar(valorSaque);
                        // extrato
                        contaP.setValor(valorSaque);
                        contaP.setTipoOperacao("Saque");
                        contaP.setDescricao("Saque em conta poupança.");
                        contaP.setData(novaData);

                        addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                        /*listaDetalhes.add("Tipo de Operação: "+contaP.getTipoOperacao()+"\nDescrição: "+contaP.getDescricao()+
                                "\nData: "+contaP.getData()+"\nValor: "+contaP.getValor());*/
                    }
                    else if (tipoConta == 2 && !poupanca) {
                        System.out.println("Você não possui conta poupança.");
                    }
                    break;
                case 4: // EMITIR EXTRATO

                    int tam = listaDescricao.size();

                    // Impressão do extrato
                    System.out.println("Data     Operação       Descrição               Valor");
                    for (int i = 0; i < tam; i++){
                        System.out.println((i+1)+ " "+ listaDatas.get(i)+" "+listaOperacao.get(i)+" "+listaDescricao.get(i)+" "+listavalor.get(i));
                    }

                    // pergunta se o usuário quer os detalhes de algum item
                    System.out.println("Deseja visualizar os detalhes de algum item? (1 - sim 0 - não)");
                    int verItem = scan.nextInt();

                        // se sim, então imprime os detalhes do item
                        if (verItem == 1) {
                            System.out.println("Insira o número do item que quer visualizar:");
                            int viewItem = scan.nextInt();
                            viewItem -= 1;

                            if (viewItem < 0 || viewItem > tam) {
                                System.out.println("Item não existe.");
                            }
                            else {
                                /*System.out.println(listaDetalhes.get(viewItem));*/
                            }
                        }
                        else
                            continue;
                    break;

                case 5: // transferência
                    System.out.println("Qual conta você quer usar para transferir? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    // valida se o tipo de conta existe
                    if (tipoConta != 1 && tipoConta != 2) {
                        System.out.println("Tipo de conta não existe.");
                        break;
                    }

                    // valor a transferir
                    System.out.println("Insira o valor a ser sacado:");
                    double valorTransferencia = scan.nextDouble();

                    // valida valor de transferencia
                    if (valorTransferencia <= 0) {
                        System.out.println("Valor inválido.");
                        break;
                    }
                    else {
                        // checar se a transferencia vai ser feita por agencia e conta ou pix
                        System.out.println("Como a transferência será feita? (1- Agência e conta, 2- Pix");
                        int tipoTransferencia = scan.nextInt();

                        if (tipoTransferencia != 1 && tipoTransferencia != 2) {
                            System.out.println("Tipo inválido");
                            break;
                        }
                        else {
                            // por agencia e conta
                            if (tipoTransferencia == 1) {
                                System.out.println("Número da agência: ");
                                int numAgencia = scan.nextInt();
                                if (numAgencia != 0001) {
                                    System.out.println("Agência não existe.");
                                    break;
                                }

                                System.out.println("Número da conta: ");
                                int numConta = scan.nextInt();

                                // transferindo da conta corrente para a poupança ou uma conta externa...
                                if (tipoConta == 1) {
                                    if (numConta == contaP.getConta()) { // entre conta corrente e poupança
                                        if (contaC.transferir(valorTransferencia, contaP)){
                                            // add ao extrato
                                            contaC.setValor(valorTransferencia);
                                            contaC.setTipoOperacao("Transferência");
                                            contaC.setDescricao("Transf. corrente p/ poupança");
                                            contaC.setData(novaData);

                                            addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());
                                            /*listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                                    "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());*/
                                        }
                                    }
                                    else { // entre corrente e conta externa
                                        if (contaC.transferir(valorTransferencia)) {
                                            // extrato
                                            contaC.setValor(valorTransferencia);
                                            contaC.setTipoOperacao("Transferência");
                                            contaC.setDescricao("Transf. corrente p/ externa");
                                            contaC.setData(novaData);

                                            addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());
                                            /*listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                                    "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());*/
                                        }
                                    }
                                }
                                // transferindo da conta poupança para a corrente ou uma conta externa...
                                else if (tipoConta == 2) {
                                    if (numConta == contaC.getConta()) { // entre conta poupança e corrente
                                        contaP.transferir(valorTransferencia, contaC);
                                        if (contaP.transferir(valorTransferencia, contaC)) {
                                            // extrato
                                            contaP.setValor(valorTransferencia);
                                            contaP.setTipoOperacao("Transferência");
                                            contaP.setDescricao("Transf. poupança p/ corrente");
                                            contaP.setData(novaData);

                                            addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                                            /*listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                                    "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());*/
                                        }
                                    }
                                    else { // entre poupança e externa
                                        if (contaP.transferir(valorTransferencia)) {
                                            contaP.setValor(valorTransferencia);
                                            contaP.setTipoOperacao("Transferência");
                                            contaP.setDescricao("Transf. poupança p/ externa");
                                            contaP.setData(novaData);

                                            addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                                            /*listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                                    "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());*/
                                        }
                                    }
                                }
                            }
                            else if (tipoTransferencia == 2) { // por pix FALTA ISSO AQUI

                            }
                        }
                    }
                    break;
                case 6: // configurar pix // FALTA ISSO AQUI
                    System.out.println("Deseja configurar o Pix de qual conta? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    // valida se o tipo de conta existe
                    if (tipoConta != 1 && tipoConta != 2) {
                        System.out.println("Tipo de conta não existe.");
                        break;
                    }

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

                case 7: // PAGAR BOLETO
                    // escolher qual conta vai usar para pagar o boleto
                    System.out.println("Com qual conta quer pagar o boleto? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    // valida se o tipo de conta existe
                    if (tipoConta != 1 && tipoConta != 2) {
                        System.out.println("Tipo de conta não existe.");
                        break;
                    }

                    // Dados do boleto
                    System.out.println("Pagamento de boleto:");
                    scan.nextLine();
                    System.out.println("Código de barras (48 dígitos):");
                    String codigoBarras = scan.nextLine();

                    System.out.println("Valor:");
                    do {
                        valorBoleto = scan.nextDouble();
                        if (valorBoleto <= 0) {
                            System.out.println("Valor inválido. Digite novamente.");
                        }
                    } while(valorBoleto <= 0);

                    // leitura da data
                    System.out.println("Data de vencimento:");
                    System.out.println("Dia:");
                    int diaBoleto = scan.nextInt();
                    System.out.println("Mês:");
                    int mesBoleto = scan.nextInt();
                    System.out.println("Ano:");
                    int anoBoleto = scan.nextInt();
                    LocalDate vencimento = LocalDate.of(anoBoleto, mesBoleto, diaBoleto);

                    System.out.println("Descrição do boleto");
                    String descricaoBoleto = scan.nextLine();

                    if (tipoConta == 1 && corrente) {
                        contaC.pagarBoleto(novaData, vencimento, valorBoleto);

                        // extrato
                        contaC.setValor(valorBoleto);
                        contaC.setTipoOperacao("Pagamento de boleto");
                        contaC.setDescricao(descricaoBoleto);
                        contaC.setData(novaData);

                        addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());
                        /*listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "
                                +contaC.getDescricao()+"\nData: "+contaC.getData()+"\nValor: "+contaC.getValor()+
                                "\nCódigo de barras: "+codigoBarras+"\nData de vencimento: "+vencimento+"Multa: "+contaC.getMultaBoleto());*/
                    }
                    else if (tipoConta == 1 && !corrente) {
                        System.out.println("Você não possui conta corrente.");
                    }
                    else if (tipoConta == 2 && poupanca) {
                        contaP.pagarBoleto(novaData, vencimento, valorBoleto);

                        // extrato
                        contaP.setValor(valorBoleto);
                        contaP.setTipoOperacao("Pagamento de boleto");
                        contaP.setDescricao(descricaoBoleto);
                        contaP.setData(novaData);

                        addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                        /*listaDetalhes.add("Tipo de Operação: "+contaP.getTipoOperacao()+"\nDescrição: "
                                +contaP.getDescricao()+"\nData: "+contaP.getData()+"\nValor: "+contaP.getValor()+
                                "\nCódigo de barras: "+codigoBarras+"\nData de vencimento: "+vencimento+"Multa: "+contaP.getMultaBoleto());*/
                    }
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
    }
}
