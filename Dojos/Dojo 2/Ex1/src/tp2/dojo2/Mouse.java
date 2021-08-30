package tp2.dojo2;

public class Mouse {
    private String cor;
    private String marca;

    public Mouse(String cor, String marca) {
        this.cor = cor;
        this.marca = marca;
    }
    public void imprimir(){
        System.out.println("Mouse - Cor: "+ cor + " Marca: " + marca);
    }
}
