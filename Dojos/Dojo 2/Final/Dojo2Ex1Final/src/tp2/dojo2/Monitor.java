package tp2.dojo2;

public class Monitor {
    private String marca;
    private String resolucao;
    private int frequencia;

    // setters
    public void setMarca(String marca) { this.marca = marca;}
    public void setResolucao(String resolucao) { this.resolucao = resolucao;}
    public void setFrequencia(int frequencia) { this.frequencia = frequencia;}

    public void imprimir() {
        System.out.println("Marca: "+ marca);
        System.out.println("Resolução: " + resolucao);
        System.out.println("Frequência: " + frequencia);
    }
}