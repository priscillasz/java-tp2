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

    // construtor com os atributos
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

    public float getAltura() { return altura; }

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
        if (capturado)
            System.out.println("O pokémon "+nome+" já foi capturado!");
        else
        {
            if (chanceDeCaptura > 50){
                capturado = true;
                libertado = false;
                System.out.println(nome+" foi capturado com sucesso!");
            }
            else
            {
                capturado = false;
                libertado = true;
                System.out.println("Oops! Você não conseguiu capturar "+nome+" :(");
            }
        }
    }

    // libertar
    public void libertar(){
        if (libertado)
            System.out.println("O pokémon já foi libertado!");
        else
        {
            if (capturado){
                libertado = true;
                capturado = false;
                System.out.println("Pokémon libertado com sucesso!");
            }
            else{ // acho que isso aqui é redundante mas ok
                libertado = true;
                System.out.println("O pokémon já está libertado.");
            }
        }
    }

    // brincar -> aumenta a felicidade em 50
    public void brincar(){
        felicidade += 50;
        System.out.println("Você brincou com "+nome+" e sua felicidade subiu para "+felicidade+"!");

    }
    // alimentar -> aumenta a felicidade em 30
    public void alimentar(){
        felicidade += 30;
        System.out.println("Você alimentou "+nome+" e sua felicidade subiu para "+felicidade+"!");

    }
    // falar
    public void falar(){
        System.out.println(nome+"!!");
    }

    // evoluir
    public void evoluir(String pokemonEvoluido, String tipoEvoluido){
        if (felicidade <= 100)
            System.out.println("O pokémon não pode ser evoluído.");
        else
        {
            felicidade -= 100; // felicidade diminui em 100
            setNome(pokemonEvoluido); // nome e tipo mudam para o evoluído
            setTipo(tipoEvoluido);
            peso += peso; // escolhi aumentar peso e altura
            altura += altura;

            System.out.println("Pokémon evoluído com sucesso!");

            // teste
            System.out.println("Nome: "+getNome());
            System.out.println("Tipo: "+getTipo());
            System.out.println("Peso: "+getPeso());
            System.out.println("Altura: "+getAltura());
            System.out.println("Felicidade: "+getFelicidade());
            System.out.println("Chance de captura: "+getChanceDeCaptura());
        }
    }
}
