package tp2.dojo2;

public class Pokemon {
    private String nome;
    private String tipo;
    private float peso;
    private float altura;
    private int felicidade;
    private int chanceDeCaptura;
    private boolean capturado;
    private boolean libertado;

    // construtor
    public Pokemon(String nome, String tipo, float peso, float altura, int felicidade, int chanceDeCaptura){
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.altura = altura;
        this.felicidade = felicidade;
        this.chanceDeCaptura = chanceDeCaptura;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getFelicidade() {
        return felicidade;
    }

    public void setFelicidade(int felicidade) {
        this.felicidade = felicidade;
    }

    public int getChanceDeCaptura() {
        return chanceDeCaptura;
    }

    public void setChanceDeCaptura(int chanceDeCaptura) {
        this.chanceDeCaptura = chanceDeCaptura;
    }

    /*---------MÉTODOS---------*/

    // capturar
    public void capturar(){

    }

    // libertar
    public void libertar(){

    }

    // brincar -> aumenta a felicidade em 50
    public void brincar(){
        felicidade += 50;
        System.out.println("Felicidade subiu para "+felicidade+"!");

    }
    // alimentar -> aumenta a felicidade em 30
    public void alimentar(){
        felicidade += 30;
        System.out.println("Felicidade subiu para "+felicidade+"!");

    }
    // falar
    public void falar(){
        System.out.println(nome);
    }

    // evoluir
    public void evoluir(){

    }
}
