package tp2.dojo2;

public class Mouse {
    private String cor;
    private String marca;
    private Boolean rgb;

    // setters
    public void setCor(String cor) { this.cor = cor;}
    public void setMarca(String marca) { this.marca = marca;}
    public void setRgb(Boolean rgb) { this.rgb = rgb;}

    public void imprimir() {
        System.out.println("Cor: "+ cor);
        System.out.println("Marca: " + marca);
        System.out.println("RGB: " + rgb);
    }
}
