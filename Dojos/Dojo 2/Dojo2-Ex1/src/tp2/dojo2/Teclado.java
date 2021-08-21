package tp2.dojo2;

public class Teclado {
    private String cor;
    private String marca;
    // private boolean rgb;
    // private boolean wireless;
    private int numeroDeTeclas;
    private String tipoDeSwitches;

    public Teclado(String cor, String marca, int numeroDeTeclas, String tipoDeSwitches){
        this.cor = cor;
        this.marca = marca;
        this.numeroDeTeclas = numeroDeTeclas;
        this.tipoDeSwitches = tipoDeSwitches;
    }

    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public int getNumeroDeTeclas() {
        return numeroDeTeclas;
    }

    public String getTipoDeSwitches() {
        return tipoDeSwitches;
    }
}
