package tp2.dojo2;

public class Copo {
    private String tipo;
    private int altura;

    public Copo(String tipo, int altura) {
        this.tipo = tipo;
        this.altura = altura;
    }
    public void imprimir() {
        System.out.println("Copo - Tipo: " + tipo + " Altura: " + altura);
    }
}
