package tp2.dojo3;

import java.time.LocalDate;
import java.util.Scanner;

public class TesteMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LocalDate niver = LocalDate.of(2001, 1, 6);
        ContaCorrente conta1 = new ContaCorrente("eu", 1407927477, niver, "priscillaxtp@gmail.com", 2005984, "39438dj@@");


        System.out.println(conta1.getConta());
        System.out.println(conta1.getAgencia());
        System.out.println(conta1.getDataDeNascimento());

        // instancias
        ContaCorrente contaC = new ContaCorrente();
        ContaPoupanca contaP = new ContaPoupanca();

        // outros
        int opcao;
        int tipoConta;
        int ehSalario;

        double salario;

        boolean corrente = false;
        boolean poupanca = false;

        long cpf, telefone;
        int dia, mes, ano;
        String nomePessoa, emailPessoa, senhaPessoa;

        do {
            System.out.println("Menu");
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
                                contaC.addSalario(salario);
                                // data de pagamento
                                // System.out.println("Informe o dia do pagamento:");

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
                                contaP.addSalario(salario);
                                // data de pagamento
                                // System.out.println("Informe o dia do pagamento:");

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
                    if (tipoConta == 1 && corrente)
                        contaC.depositar(valorDeposito);
                    else if (tipoConta == 1 && !corrente){
                        System.out.println("Você não possui conta corrente.");
                    }
                    else if (tipoConta == 2 && poupanca)
                        contaP.depositar(valorDeposito);
                    else if (tipoConta == 2 && !poupanca)
                        System.out.println("Você não possui conta poupança.");

                    break;
                case 3: // sacar
                    System.out.println("De qual conta você quer sacar? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    System.out.println("Insira o valor a ser sacado:");
                    double valorSaque = scan.nextDouble();
                    if (tipoConta == 1)
                        contaC.sacar(valorSaque);
                    else if (tipoConta == 2)
                        contaP.sacar(valorSaque);
                    break;
                case 4: // emitir extrato
                    break;
                case 5: // transferência
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
                    // if tipoconta == 1 e corrente -> contaC.pagarboleto();
                    break;
                default:
                    if (opcao != 0)
                        System.out.println("Opção inválida.");
                    break;
            }
        }while(opcao !=0);

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