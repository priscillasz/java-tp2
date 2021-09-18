package tp2.dojo3;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Main {
    // instâncias das contas
    static ContaCorrente contaC = new ContaCorrente();
    static ContaPoupanca contaP = new ContaPoupanca();

    // arraylists
    static ArrayList<String> listaDescricao = new ArrayList<>();
    static ArrayList<String> listaOperacao = new ArrayList<>();
    static ArrayList<Double> listavalor = new ArrayList<>();
    static ArrayList<LocalDate> listaDatas = new ArrayList<>();

    // adicionar dados de cada operação nas listas do extrato
    public static void addToList(double valor, String descricao, String operacao, LocalDate dataOperacao) {
        listavalor.add(valor);
        listaDatas.add(dataOperacao);
        listaDescricao.add(descricao);
        listaOperacao.add(operacao);
    }

    // settar os dados das operações da conta corrente para que elas possam ser usadas no extrato
    public static void setDadosCorrente(double valor, String descricao, String operacao, LocalDate dataOperacao) {
        contaC.setValor(valor);
        contaC.setDescricao(descricao);
        contaC.setTipoOperacao(operacao);
        contaC.setData(dataOperacao);
    }

    // settar os dados das operações da conta poupança para que elas possam ser usadas no extrato
    public static void setDadosPoupanca(double valor, String descricao, String operacao, LocalDate dataOperacao) {
        contaP.setValor(valor);
        contaP.setDescricao(descricao);
        contaP.setTipoOperacao(operacao);
        contaP.setData(dataOperacao);
    }

    public static void main(String[] args) {
        // instância da classe Scanner
        Scanner scan = new Scanner(System.in);

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
        boolean pixCorrente = false;
        boolean pixPoupanca = false;

        // variáveis que ajudam na adição do salário no extrato
        boolean sal1 = true;
        boolean sal2 = false;
        boolean sal3 = false;

        long cpf, telefone;
        int dia, mes, ano;
        String nomePessoa, emailPessoa, senhaPessoa;
        int avancar, diasAvancar;

        // Muitas variáveis para ajudar no cálculo das datas...
        Date d;
        Calendar c = Calendar.getInstance();
        LocalDate novaData;
        LocalDate anoNascimento;
        LocalDate atual;
        LocalDate diaSalario;

        LocalDate inicio = LocalDate.now();
        int diaInicio = inicio.getDayOfMonth();
        int mesInicio = inicio.getMonthValue();
        int anoInicio = inicio.getYear();

        int mesPrint = 0;

        int diaAtual = 0, mesAtual = 0, anoAtual = 0;

        int meses = 0;
        boolean testeMeses = false;

        // Loop do...while para continuar dentro do menu enquanto o usuário não digita '0'
        do {
            // Menu de "avanço no tempo". O usuário pode avançar x dias.
            // A maioria dos testes foi realizada com valores entre 1 e 60.
            if (corrente || poupanca) {
                System.out.println("\n1- Avançar dias");
                System.out.println("0- Continuar");
                avancar = scan.nextInt();
                if (avancar == 1){ // avançar x dias
                    System.out.println("Quantos dias?");
                    diasAvancar = scan.nextInt();
                    c.add(Calendar.DATE, diasAvancar); // Adiciona a data atual a quantidade de dias.

                    d = c.getTime(); // A partir do calendário c, gera a data d.

                    // converte para LocalDate
                    atual = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(d)); // converte a Date d para LocalDate
                    // Pega o dia, mês e ano atual individualmente...
                    diaAtual = atual.getDayOfMonth();
                    mesAtual = atual.getMonthValue();
                    anoAtual = atual.getYear();

                    if (mesAtual != mesInicio) {
                        // Toda vez que o mês muda, o status do salário muda para não recebido, assim ele pode acontecer novamente.
                        salarioRecebido = false;
                        novoMes = true;
                        if (mesAtual - mesInicio != 0) {
                            if (mesAtual > mesInicio) {
                                meses = mesAtual - mesInicio;
                            }
                            else {
                                meses = 12 - mesInicio + mesAtual;
                            }
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

            // formata a data que será usada no corpo do menu
            novaData = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(d));

            // adicionar salário
            if (contaC.getDiaPagamento() <= novaData.getDayOfMonth() && correnteSalario) {
                if (salarioRecebido && !testeMeses) {
                }
                else if (!salarioRecebido && !testeMeses) {
                    contaC.addSalario(contaC.getSalario());
                    salarioRecebido = true;

                    // adicionar o salário no extrato
                    diaSalario = LocalDate.of(anoAtual, mesAtual, contaC.getDiaPagamento());
                    setDadosCorrente(contaC.getSalario(), "Entrada de Salário", "Depósito", diaSalario);
                    addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());
                    listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                            "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());
                }
                else if (!salarioRecebido && testeMeses) {
                    double novoSalario = meses * contaC.getSalario();
                    contaC.addSalario(novoSalario);
                    salarioRecebido = true;
                    testeMeses = false;

                    for (int i = 0; i < meses; i++){
                        if (sal1)
                            mesPrint = mesInicio;

                        if (mesPrint > 12 && sal3) {
                            if (!sal2) {
                                mesPrint = 1;
                                sal2 = true;
                            }
                            anoInicio += 1;
                        }
                       sal1 = false;

                        sal3 = true;
                        // adicionar o salário no extrato
                        diaSalario = LocalDate.of(anoInicio, mesPrint, contaC.getDiaPagamento());
                        setDadosCorrente(contaC.getSalario(), "Entrada de Salário", "Depósito", diaSalario);
                        addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());
                        listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());
                        mesPrint++;
                    }
                }
            }
            else if (contaP.getDiaPagamento() <= novaData.getDayOfMonth() && poupancaSalario) {
                if (salarioRecebido && !testeMeses) {
                    // acho q é redudante isso aqui né, mas deixa aqui só pra não esquecer
                }
                else if (!salarioRecebido && !testeMeses) {
                    contaP.addSalario(contaP.getSalario());
                    salarioRecebido = true;

                    diaSalario = LocalDate.of(anoAtual, mesAtual, contaP.getDiaPagamento());
                    setDadosPoupanca(contaP.getSalario(), "Entrada de Salário", "Depósito", diaSalario);
                    addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                    listaDetalhes.add("Tipo de Operação: "+contaP.getTipoOperacao()+"\nDescrição: "+contaP.getDescricao()+
                            "\nData: "+contaP.getData()+"\nValor: "+contaP.getValor());
                }
                else if (!salarioRecebido && testeMeses) {
                    double novoSalario = meses * contaP.getSalario();
                    contaP.addSalario(novoSalario);
                    salarioRecebido = true;
                    testeMeses = false;

                    for (int i = 0; i < meses; i++) {
                        if (sal1)
                            mesPrint = mesInicio;

                        if (mesPrint > 12 && sal3) {
                            if (!sal2) {
                                mesPrint = 1;
                                sal2 = true;
                            }
                            anoInicio += 1;
                        }
                        sal1 = false;

                        sal3 = true;
                        diaSalario = LocalDate.of(anoInicio, mesPrint, contaP.getDiaPagamento());
                        setDadosPoupanca(contaP.getSalario(), "Entrada de Salário", "Depósito", diaSalario);
                        addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                        listaDetalhes.add("Tipo de Operação: "+contaP.getTipoOperacao()+"\nDescrição: "+contaP.getDescricao()+
                                "\nData: "+contaP.getData()+"\nValor: "+contaP.getValor());
                        mesPrint++;
                    }
                }
            }

            // Rendimento da poupança
            if (diaAtual >= diaInicio && novoMes) {
                rendimentoSaldo = contaP.getSaldo() * 1.03;
                contaP.setSaldo(rendimentoSaldo);
                novoMes = false;
            }

            /* *************INTRO************** */
            System.out.println("\nSeja bem-vindo(a)!");
            System.out.println(novaData+"\n");

            if (corrente) {
                System.out.println("Conta Corrente");
                System.out.println("Saldo: "+contaC.getSaldo());
                System.out.println("Agência: "+contaC.getAgencia()+" Conta: "+contaC.getConta()+"");
                if (pixCorrente) {
                    System.out.println("Pix: "+contaC.getPix());
                }
            }

            if (poupanca) {
                System.out.println("Conta Poupança");
                System.out.println("Saldo: "+contaP.getSaldo());
                System.out.println("Agência: "+contaP.getAgencia()+" Conta: "+contaP.getConta()+"");
                if (pixPoupanca) {
                    System.out.println("Pix: "+contaP.getPix());
                }
            }

            ////////////// MENU ////////////////
            System.out.println("\nO que deseja fazer?");
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

                    // valida o tipo de conta
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

                            if (ehSalario == 1) {
                                // salario
                                do {
                                    System.out.println("Informe o salário:");
                                    salario = scan.nextDouble();

                                    if (salario <= 0) {
                                        System.out.println("Valor inválido.");
                                    }
                                } while (salario <= 0);

                                contaC.setSalario(salario);
                                // data de pagamento
                                do {
                                    System.out.println("Informe o dia do pagamento:");
                                    diaPag = scan.nextInt();

                                    if (diaPag<= 0) {
                                        System.out.println("Valor inválido.");
                                    }
                                } while (diaPag <= 0 || diaPag > 31);

                                 contaC.setDiaPagamento(diaPag);

                                 correnteSalario = true;
                            }

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
                                    do {
                                        System.out.println("Informe o salário:");
                                        salario = scan.nextDouble();

                                        if (salario <= 0) {
                                            System.out.println("Valor inválido.");
                                        }
                                    } while (salario <= 0);

                                    do {
                                        System.out.println("Informe o dia do pagamento:");
                                        diaPag = scan.nextInt();

                                        if (diaPag<= 0) {
                                            System.out.println("Valor inválido.");
                                        }
                                    } while (diaPag <= 0 || diaPag > 31);

                                    contaC.setSalario(salario);
                                    contaC.setDiaPagamento(diaPag);

                                    correnteSalario = true;
                                }
                            }

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
                                do {
                                    System.out.println("Informe o salário:");
                                    salario = scan.nextDouble();

                                    if (salario <= 0) {
                                        System.out.println("Valor inválido.");
                                    }
                                } while (salario <= 0);

                                contaP.setSalario(salario);

                                // data de pagamento
                                do {
                                    System.out.println("Informe o dia do pagamento:");
                                    diaPag = scan.nextInt();

                                    if (diaPag<= 0) {
                                        System.out.println("Valor inválido.");
                                    }
                                } while (diaPag <= 0 || diaPag > 31);

                                contaP.setDiaPagamento(diaPag);

                                poupancaSalario = true;
                            }

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
                                    do {
                                        System.out.println("Informe o salário:");
                                        salario = scan.nextDouble();

                                        if (salario <= 0) {
                                            System.out.println("Valor inválido.");
                                        }
                                    } while (salario <= 0);

                                    // dia pagamento
                                    do {
                                        System.out.println("Informe o dia do pagamento:");
                                        diaPag = scan.nextInt();

                                        if (diaPag<= 0) {
                                            System.out.println("Valor inválido.");
                                        }
                                    } while (diaPag <= 0 || diaPag > 31);

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
                        setDadosCorrente(valorDeposito, "Depósito em conta corrente", "Depósito", novaData);
                        addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());

                        listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());
                    }
                    else if (tipoConta == 1 && !corrente) {
                        System.out.println("Você não possui conta corrente.");
                    }
                    else if (tipoConta == 2 && poupanca) {
                        contaP.depositar(valorDeposito);

                        // extrato
                        setDadosPoupanca(valorDeposito, "Depósito", "Depósito em conta poupança", novaData);
                        addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                        listaDetalhes.add("Tipo de Operação: "+contaP.getTipoOperacao()+"\nDescrição: "+contaP.getDescricao()+
                                "\nData: "+contaP.getData()+"\nValor: "+contaP.getValor());
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
                        if (contaC.sacar(valorSaque)) {
                            // extrato
                            setDadosCorrente(valorSaque, "Saque", "Saque em conta corrente", novaData);
                            addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());
                            listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                    "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());
                        }
                    }
                    else if (tipoConta == 1 && !corrente) {
                        System.out.println("Você não possui conta corrente.");
                    }
                    else if (tipoConta == 2 && poupanca) {
                        if (contaP.sacar(valorSaque)) {
                            // extrato
                            setDadosPoupanca(valorSaque, "Saque", "Saque em conta poupança", novaData);
                            addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                            listaDetalhes.add("Tipo de Operação: "+contaP.getTipoOperacao()+"\nDescrição: "+contaP.getDescricao()+
                                    "\nData: "+contaP.getData()+"\nValor: "+contaP.getValor());
                        }
                    }
                    else if (tipoConta == 2 && !poupanca) {
                        System.out.println("Você não possui conta poupança.");
                    }
                    break;
                case 4: // EMITIR EXTRATO
                    int tam = listaDescricao.size();

                    // Impressão do extrato
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Item    Data       Operação        Descrição            Valor");
                    System.out.println("-------------------------------------------------------------");
                    for (int i = 0; i < tam; i++){
                        System.out.println(" "+(i+1)+"   "+ listaDatas.get(i)+" "+listaOperacao.get(i)+"   "+listaDescricao.get(i)+" "+listavalor.get(i));
                    }
                    System.out.println("-------------------------------------------------------------");

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
                                System.out.println(listaDetalhes.get(viewItem));
                            }
                        }
                        else
                            continue;
                    break;

                case 5: // TRANSFERÊNCIA
                    System.out.println("\nQual conta você quer usar para transferir? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    // valida se o tipo de conta existe
                    if (tipoConta != 1 && tipoConta != 2) {
                        System.out.println("Tipo de conta não existe.");
                        break;
                    }

                    // checar se a transferencia vai ser feita por agência e conta OU pix
                    System.out.println("Como a transferência será feita? (1- Agência e conta, 2- Pix)");
                    int tipoTransferencia = scan.nextInt();

                    if (tipoTransferencia != 1 && tipoTransferencia != 2) {
                        System.out.println("Tipo inválido");
                        break;
                    }

                    System.out.println("Insira o valor a ser transferido:"); // valor a transferir
                    double valorTransferencia = scan.nextDouble();
                    if (valorTransferencia <= 0) { // valida valor de transferencia
                        System.out.println("Valor inválido.");
                        break;
                    }
                    else {
                        // 1 - Por agência e conta
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
                                        setDadosCorrente(valorTransferencia, "Transf. corrente p/ poupança","Transferência", novaData);
                                        addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());
                                        listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                                "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());
                                    }
                                }
                                else { // entre corrente e conta externa
                                    if (contaC.transferir(valorTransferencia)) {
                                        // extrato
                                        setDadosCorrente(valorTransferencia, "Transf. corrente p/ externa", "Transferência", novaData);
                                        addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());
                                        listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                                "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());
                                    }
                                }
                            }
                            // transferindo da conta poupança para a corrente ou uma conta externa...
                            else if (tipoConta == 2) {
                                if (numConta == contaC.getConta()) { // entre conta poupança e corrente
                                    if (contaP.transferir(valorTransferencia, contaC)) {
                                        // extrato
                                        setDadosPoupanca(valorTransferencia, "Transf. poupança p/ corrente","Transferência", novaData);
                                        addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                                        listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                                "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());
                                    }
                                }
                                else { // entre poupança e externa
                                    if (contaP.transferir(valorTransferencia)) {
                                        // extrato
                                        setDadosPoupanca(valorTransferencia, "Transf. poupança p/ externa", "Transferência", novaData);
                                        addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                                        listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                                "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());
                                    }
                                }
                            }
                        }
                        else if (tipoTransferencia == 2) { // por pix
                            System.out.println("Informe o Pix da conta: ");
                            scan.nextLine();
                            String inputPix = scan.nextLine();

                            if (tipoConta == 1) { // quem transfere é a corrente
                                if (inputPix == contaP.getPix()) { // entre corrente e poupança
                                    if (contaC.transferir(valorTransferencia, contaP)) {
                                        setDadosCorrente(valorTransferencia, "Transf. via Pix", "Transferência", novaData);
                                        addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());
                                        listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                                "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());
                                    }
                                }
                                else { // entre corrente e externa
                                    if (contaC.transferir(valorTransferencia)) {
                                        setDadosCorrente(valorTransferencia, "Transf. via Pix", "Transferência", novaData);
                                        addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());
                                        listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                                "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());
                                    }
                                }
                            }
                            else if (tipoConta == 2) { // quem transfere é a poupança
                                if (inputPix == contaC.getPix()) { // entre poupança e corrente
                                    if (contaP.transferir(valorTransferencia, contaC)) {
                                        setDadosPoupanca(valorTransferencia, "Transf. via Pix", "Transferência", novaData);
                                        addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                                        listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                                "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());
                                    }
                                }
                                else { // entre poupança e externa
                                    if (contaP.transferir(valorTransferencia)) {
                                        setDadosPoupanca(valorTransferencia, "Transf. via Pix", "Transferência", novaData);
                                        addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                                        listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "+contaC.getDescricao()+
                                                "\nData: "+contaC.getData()+"\nValor: "+contaC.getValor());
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 6: // CONFIGURAR PIX
                    System.out.println("Deseja configurar o Pix de qual conta? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    // valida o tipo de conta
                    if (tipoConta != 1 && tipoConta != 2) {
                        System.out.println("Tipo de conta não existe.");
                        break;
                    }

                    if (tipoConta == 1 && corrente) {
                        if (!pixCorrente) {
                            contaC.configurarPix();
                            pixCorrente = true;
                        }
                        else {
                            System.out.println("Pix já foi configurado anteriormente.");
                        }
                    }
                    else if (tipoConta == 1 && !corrente)
                        System.out.println("Você não possui uma conta corrente.");
                    else if (tipoConta == 2 && poupanca) {
                        if (!pixPoupanca) {
                            contaP.configurarPix();
                            pixPoupanca = true;
                        }
                        else {
                            System.out.println("Pix já foi configurado anteriormente.");
                        }
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
                    System.out.println("Pagamento de boleto");
                    scan.nextLine(); // buffer
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

                    System.out.println("Descrição do boleto:");
                    scan.nextLine();
                    String descricaoBoleto = scan.nextLine();

                    if (tipoConta == 1 && corrente) {
                        if (contaC.pagarBoleto(novaData, vencimento, valorBoleto)) {
                            // extrato
                            setDadosCorrente(contaC.getBoleto(), descricaoBoleto, "Pagamento de boleto", novaData);
                            addToList(contaC.getValor(), contaC.getDescricao(), contaC.getTipoOperacao(), contaC.getData());
                            listaDetalhes.add("Tipo de Operação: "+contaC.getTipoOperacao()+"\nDescrição: "
                                    +contaC.getDescricao()+"\nData: "+contaC.getData()+"\nValor: "+contaC.getValor()+
                                    "\nCódigo de barras: "+codigoBarras+"\nData de vencimento: "+vencimento+"\nMulta: "+contaC.getMultaBoleto());
                        }
                    }
                    else if (tipoConta == 1 && !corrente) {
                        System.out.println("Você não possui conta corrente.");
                    }
                    else if (tipoConta == 2 && poupanca) {
                        if (contaP.pagarBoleto(novaData, vencimento, valorBoleto)) {
                            // extrato
                            setDadosPoupanca(contaC.getBoleto(), descricaoBoleto, "Pagamento de boleto", novaData);
                            addToList(contaP.getValor(), contaP.getDescricao(), contaP.getTipoOperacao(), contaP.getData());
                            listaDetalhes.add("Tipo de Operação: "+contaP.getTipoOperacao()+"\nDescrição: "
                                    +contaP.getDescricao()+"\nData: "+contaP.getData()+"\nValor: "+contaP.getValor()+
                                    "\nCódigo de barras: "+codigoBarras+"\nData de vencimento: "+vencimento+"\nMulta: "+contaP.getMultaBoleto());
                        }
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
        } while(opcao !=0);
    }
}
