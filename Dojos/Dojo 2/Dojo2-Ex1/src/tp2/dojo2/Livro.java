package tp2.dojo2;

public class Livro {
    private String titulo;
    private String autor;
    private String idioma;
    private int numeroPaginas;
    private int anoLancamento;

    public Livro(String titulo, String autor, String idioma, int numeroPaginas, int anoLancamento){
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.numeroPaginas = numeroPaginas;
        this.anoLancamento = anoLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
}
