package tp2.dojo3;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TesteData {
    public static void main(String[] args) {
        Calendar p = Calendar.getInstance();
        Date pagamento = p.getTime();

        Calendar v = Calendar.getInstance();
        v.add(Calendar.DAY_OF_MONTH, 5);
        Date vencimento = v.getTime();

        System.out.println("Pagamento: "+pagamento);
        System.out.println("Vencimento: "+vencimento);

        long diffInMillies = vencimento.getTime() - pagamento.getTime();
        long dias = TimeUnit.MILLISECONDS.toDays(diffInMillies);
        System.out.println("Diferença: "+dias);

        // com LocalDate
        LocalDate pag = LocalDate.now();
        LocalDate ven = LocalDate.of(2021, 9, 20);

        Period period = Period.between(pag, ven);
        period.getDays();
        System.out.println("Diferença: "+period.getDays());


        // LocalDate pagamento
        LocalDate diaPagamento = LocalDate.now();
        // converte LocalDate to Date
        Date pagDate = Date.from(diaPagamento.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // LocalDate vencimento
        LocalDate diaVencimento = LocalDate.of(2021, 9, 28);
        // converte LocalDate to Date
        Date venDate = Date.from(diaVencimento.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // diferença entre dias p calcular a multa
        long diasEmMillie = venDate.getTime() - pagDate.getTime();
        long diasMulta = TimeUnit.MILLISECONDS.toDays(diasEmMillie);

        // checar
        System.out.println("Hoje: "+pagDate);
        System.out.println("Vencimento: "+venDate);
        System.out.println("Diferença de dias: "+diasMulta);

        double pagar = 500 + (500 * (0.1 * diasMulta));
        System.out.println("Valor com multa: "+pagar);
    }
}
