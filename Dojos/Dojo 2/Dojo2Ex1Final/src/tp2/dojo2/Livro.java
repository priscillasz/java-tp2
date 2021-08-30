package tp2.dojo2;

public class Livro {
    private String titulo;
    private String autor;
    private String genero;

    // construtor
    public Livro(String titulo, String autor, String genero){
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    public void imprimir() {
        System.out.println("Título: "+ titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Gênero: " + genero);
    }
}