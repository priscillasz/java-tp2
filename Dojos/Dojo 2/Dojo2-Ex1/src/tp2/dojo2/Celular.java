package tp2.dojo2;

public class Celular {
    private String modelo;
    private String marca;
    private String cor;
    private int armazenamento;

    public Celular(String modelo, String marca, String cor, int armazenamento){
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.armazenamento = armazenamento;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public int getArmazenamento() {
        return armazenamento;
    }
}
