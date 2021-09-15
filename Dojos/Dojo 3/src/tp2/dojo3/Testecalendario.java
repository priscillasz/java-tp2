package tp2.dojo3;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Testecalendario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calendar c= Calendar.getInstance();
        c.add(Calendar.DATE, 6);
        Date d=c.getTime();
        Calendar teste = Calendar.getInstance();
        Date n = teste.getTime();
        //c.add(Calendar.DATE, 7);
        System.out.println(d);
        System.out.println(n);
        Date d2 = teste.getTime();
        Date d3 = c.getTime();
        long subDate = d3.getTime() - d2.getTime();
        long difference = (subDate / (1000 * 60 * 60 * 24)) % 365;
        System.out.println(difference);


        LocalDate pagamento = LocalDate.now();
        LocalDate vencimento = LocalDate.of(2021,9,20);

        int pegames = pagamento.getMonthValue();

        Calendar f = Calendar.getInstance();
        LocalDate date = LocalDate.now();
        LocalDate novaData = date.plusDays(45);
        LocalDate proxMes = date.plusMonths(1);


        // date.datesUntil(novaData);

        System.out.println(date);
        System.out.println(novaData);

        //System.out.println(sumDate);
        //long diff = TimeUnit.DAYS.convert(sumDate, TimeUnit.MILLISECONDS);
        //System.out.println("diff: "+diff);

        System.out.println(proxMes);


        // Date g = f.getTime();
        // System.out.println(g);

        //

        // pegar o dia do pagamento
        int dia = date.getDayOfMonth();
        System.out.println(dia);

        /*System.out.println("Add meses");
        for (int i = 0; i < 3; i++){
            System.out.println(i+1);
            c.add(Calendar.DATE, 30);
            System.out.println(c.getTime());
        }*/

        ArrayList agenda = new ArrayList();

        // Date teste;
        /*Calendar oi = Calendar.getInstance();
        Date hello = oi.getTime();
        boolean input;
        int qtdDias;
        // avançar mês
        System.out.println(hello+"\nSeja Bem-vindo(a)!");
        do {
            System.out.println("Deseja avançar dias?");
            input = scanner.nextBoolean();
            System.out.println("Qnts dias?");
            qtdDias = scanner.nextInt();

            if (input){
                f.add(Calendar.DATE, qtdDias);
                Date g = f.getTime();
                agenda.add(g);
                System.out.println(g);
            }
        }while (input);

        int n = agenda.size();
        for (int i = 0; i < n; i++){
            System.out.println(agenda.get(i));
        }*/

       /* TransacaoEmConta teste = new ContaCorrente();
        teste.getValor();

        ArrayList listaValores = new ArrayList();

        ContaCorrente contaTeste = new ContaCorrente();*/


        /*contaTeste.setSalario(2500);
        contaTeste.setNome("Priscilla");
        listaValores.add("Pessoa 1 " +contaTeste.getSalario()+" "+contaTeste.getNome());

        contaTeste.setSalario(300);
        contaTeste.setNome("Hinata");
        listaValores.add("Pessoa 2 " +contaTeste.getSalario()+" "+contaTeste.getNome());

        contaTeste.setSalario(2000);
        contaTeste.setNome("Bokuto");
        listaValores.add("Pessoa 3 " +contaTeste.getSalario()+" "+contaTeste.getNome());




        System.out.println("Teste");
        int m = listaValores.size();
        for (int i = 0; i < m; i++){
            System.out.println(listaValores.get(i));
        }*/

       /* ArrayList<Double> valores = new ArrayList<>();
        ArrayList<String> nomes = new ArrayList<>();

        contaTeste.setSalario(2500);
        contaTeste.setNome("Kenma");
        valores.add(contaTeste.getSalario());
        nomes.add(contaTeste.getNome());

        contaTeste.setSalario(3200);
        contaTeste.setNome("Kuroo");
        valores.add(contaTeste.getSalario());
        nomes.add(contaTeste.getNome());

        int tamanho = valores.size();
        for (int i = 0; i < tamanho; i++){
            System.out.println(nomes.get(i) +" "+ valores.get(i));
        }*/

        // GregorianCalendar testeAqui = new GregorianCalendar(2001, 3, 5);
        Calendar t = Calendar.getInstance();
        Date w = t.getTime();

        // System.out.println(w);
    }
}
