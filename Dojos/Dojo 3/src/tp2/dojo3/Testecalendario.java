package tp2.dojo3;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Testecalendario {
    public static void main(String[] args) {
        Calendar c= Calendar.getInstance();
        c.add(Calendar.DATE, 30);
        Date d=c.getTime();
        System.out.println(d);

        Calendar f = Calendar.getInstance();
        Date g = f.getTime();
        System.out.println(g);

        System.out.println("Add meses");
        for (int i = 0; i < 3; i++){
            System.out.println(i+1);
            c.add(Calendar.DATE, 30);
            System.out.println(c.getTime());
        }
    }
}
