package tp2.dojo3;

import java.time.LocalDate;

public class PoupançaTeste {
    private String nomeCompleto;
    private LocalDate anoNascimentoh;

    /*public PoupançaTeste(String nomeCompleto, LocalDate anoNascimentoh) {
        this.nomeCompleto = nomeCompleto;
        this.anoNascimentoh = anoNascimentoh;
    }*/

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getAnoNascimentoh() {
        return anoNascimentoh;
    }

    public void setAnoNascimentoh(LocalDate anoNascimentoh) {
        this.anoNascimentoh = anoNascimentoh;
    }
}
