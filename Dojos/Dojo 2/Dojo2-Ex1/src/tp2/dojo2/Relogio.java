package tp2.dojo2;

public class Relogio {
    private boolean digital;
    private String cor;
    private String marca;
    private boolean bluetooth;

    public Relogio(boolean digital, String cor, String marca, boolean bluetooth){
        this.digital = digital;
        this.cor = cor;
        this.marca = marca;
        this.bluetooth = bluetooth;
    }

    public boolean isDigital() {
        return digital;
    }

    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }
}
