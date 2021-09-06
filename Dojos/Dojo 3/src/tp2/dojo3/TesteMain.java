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

        boolean corrente = false;
        boolean poupanca = false;

        int dia, mes, ano;
        String nomePessoa;

        do {
            System.out.println("Menu");
            System.out.println("1 - Abrir conta");
            opcao = scan.nextInt();


            switch (opcao){
                case 1:
                    System.out.println("Qual tipo de conta você quer criar? (1- Corrente 2- Poupança)");
                    tipoConta = scan.nextInt();

                    if (tipoConta == 1){
                        if (!corrente && !poupanca){
                            corrente = true;

                            System.out.println("Nome completo");
                            scan.nextLine(); // buffer
                            nomePessoa = scan.nextLine();

                            System.out.println("Data de nascimento (dia, mês e ano)");
                            dia = scan.nextInt();
                            mes = scan.nextInt();
                            ano = scan.nextInt();
                            LocalDate anoNascimento = LocalDate.of(ano, mes, dia);

                            contaC.setNome(nomePessoa);
                            contaC.setDataDeNascimento(anoNascimento);
                            System.out.println("Sua conta corrente foi criada com sucesso.");
                        }
                        else if (!corrente && poupanca){
                            corrente = true;
                            contaCorrente.setNomeCompleto(contaPoupanca.getNomeCompleto());
                            contaCorrente.setAnoNascimentoh(contaPoupanca.getAnoNascimentoh());
                            System.out.println("Conta corrente criada com sucesso. ");
                        }
                        else if (corrente && !poupanca){
                            System.out.println("Você já tem uma conta corrente. ");
                        }
                        else if(corrente && poupanca){
                            System.out.println("Você já tem as duas contas.");
                        }
                    }

                    break;
                default:
                    break;
            }


        }while(opcao !=0);
    }
}
