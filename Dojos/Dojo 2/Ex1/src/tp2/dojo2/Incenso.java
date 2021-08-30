package tp2.dojo2;

public class Incenso {
    private String nome;
    private String aroma;

    public Incenso(String nome, String aroma) {
        this.nome = nome;
        this.aroma = aroma;
    }
    public void imprimir() {
        System.out.println("Incenso - Nome: " + nome + " Aroma: " + aroma);
    }
}
