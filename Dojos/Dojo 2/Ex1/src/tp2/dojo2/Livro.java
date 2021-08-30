package tp2.dojo2;

public class Livro {
    private String autor;
    private String titulo;

    public Livro(String autor, String titulo) {
        this.autor = autor;
        this.titulo = titulo;
    }
    public void imprimir() {
        System.out.println("Livro - Autor: " + autor + " Título: " + titulo);
    }
}
