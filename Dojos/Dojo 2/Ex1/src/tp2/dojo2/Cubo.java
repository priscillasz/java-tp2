package tp2.dojo2;

public class Cubo {
    private int lado;
    private int volume;

    public Cubo(int lado) {
        this.lado = lado;
        this.volume =  lado*lado*lado;
    }
    public void imprimir() {
        System.out.println("Cubo - Lado: " + lado + " Volume: " + volume);
    }
}
