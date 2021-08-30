package tp2.dojo2;

public class Incenso {
    private String nome;
    private String aroma;

    // setters
    public void setNome(String nome) { this.nome = nome;}
    public void setAroma(String aroma) { this.aroma = aroma;}

    public void imprimir() {
        System.out.println("Nome: " + nome);
        System.out.println("Aroma: " + aroma);
    }
}
