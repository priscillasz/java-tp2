package tp2.dojo3;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ContaTeste contaCorrente = new ContaTeste();
        PoupançaTeste contaPoupanca = new PoupançaTeste();
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

            switch(opcao){
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

                            contaCorrente.setNomeCompleto(nomePessoa);
                            contaCorrente.setAnoNascimentoh(anoNascimento);
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
                    if (tipoConta == 2){
                      if (!corrente && !poupanca){
                          poupanca = true;

                          System.out.println("Nome completo");
                          scan.nextLine(); // buffer
                          nomePessoa = scan.nextLine();

                          System.out.println("Data de nascimento (dia, mês e ano)");
                          dia = scan.nextInt();
                          mes = scan.nextInt();
                          ano = scan.nextInt();

                          LocalDate anoNascimento = LocalDate.of(ano, mes, dia);
                          contaPoupanca.setNomeCompleto(nomePessoa);
                          contaPoupanca.setAnoNascimentoh(anoNascimento);
                          System.out.println("Sua conta poupança foi criada com sucesso. ");
                      }
                      else if (corrente && !poupanca){
                          poupanca = true;
                          contaPoupanca.setNomeCompleto(contaCorrente.getNomeCompleto());
                          contaPoupanca.setAnoNascimentoh(contaCorrente.getAnoNascimentoh());
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
                case 2:
                    break;
                default:
                    break;
            }
        } while (opcao != 0);

        System.out.println("Dados das contas so p eu testar");
        System.out.println("Corrente");
        System.out.println("Nome: "+contaCorrente.getNomeCompleto());
        System.out.println("Data de nascimento: "+contaCorrente.getAnoNascimentoh());

        System.out.println("Poupança");
        System.out.println("Nome: "+contaPoupanca.getNomeCompleto());
        System.out.println("Data de nascimento: "+contaPoupanca.getAnoNascimentoh());

        // TESTANDO COISA DE DATA AQUI
        /*System.out.println("Data de nascimento (dia, mês e ano)");
        int dia = scan.nextInt();
        int mes = scan.nextInt();
        int ano = scan.nextInt();

        LocalDate vencBoleto = LocalDate.of(ano, mes, dia);
        LocalDate dataAtual = LocalDate.now();

        System.out.println("Boleto vence: "+vencBoleto);
        System.out.println("Hoje eh: "+dataAtual);

        if (dataAtual.isBefore(vencBoleto))
            System.out.println("ta no prazo");
        else if (dataAtual.isEqual(vencBoleto))
            System.out.println("ainda ta no prazo");
        else
            System.out.println("kk vai pagar multa");*/

        // RASCUNHO DO MENU
        /*int opcao;
        do {
            System.out.println("Menu");
            System.out.println("Abrir conta");
            System.out.println("Sacar");
            System.out.println("Depositar");
            System.out.println("Emitir extrato");
            System.out.println("Configurar PIX");
            System.out.println("Pagar boleto");
            opcao = scan.nextInt();

            switch (opcao){
                case 1: // abrir conta
                    break;
                case 2: // sacar
                    break;
                case 3: // depositar
                    break;
                case 4: // emitir extrato
                    break;
                case 5: // configurar pix
                    break;
                case 6: // pagar boleto
                    break;
                default:
                    if (opcao != 0)
                        System.out.println("Opção inválida!");
                    break;
            }
        } while(opcao != 0);*/
    }
}
