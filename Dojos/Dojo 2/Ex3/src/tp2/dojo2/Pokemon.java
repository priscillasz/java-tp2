package tp2.dojo2;

public class Pokemon {
    private String nome;
    private String tipo;
    private float peso;
    private float altura;
    private int felicidade;
    private int chanceCaptura;
    private boolean capturado;
    private boolean libertado;

    public Pokemon(String nome, String tipo, float peso, float altura, int felicidade, int chanceCaptura) {
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.altura = altura;
        this.felicidade = felicidade;
        this.chanceCaptura = chanceCaptura;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public float getPeso() { return peso; }

    public void setPeso(float peso) { this.peso = peso; }

    public float getAltura() { return altura; }

    public void setAltura(float altura) { this.altura = altura; }

    public int getFelicidade() { return felicidade; }

    public void setFelicidade(int felicidade) { this.felicidade = felicidade; }

    public int getChanceCaptura() { return chanceCaptura; }

    public void setChanceCaptura(int chanceCaptura) { this.chanceCaptura = chanceCaptura; }

    public void capturar(){
        if (capturado)
            System.out.println("Ação inválida. O pokemon já foi capturado.");
        else {
            if (chanceCaptura>50){
                capturado = true;
                libertado = false;
                System.out.println("Pokemon capturado");
            }
            else{
                capturado = false;
                libertado = true;
                System.out.println("O Pokemon escapou");
            }
        }
    }

    public void libertar(){
        if (libertado)
            System.out.println("Ação inválida. O pokemon já foi libertado.");
        else {
            if (capturado) {
                libertado = true;
                capturado = false;
                System.out.println("Libertado com sucesso!");
            } else {
                libertado = true;
                System.out.println("Ação inválida");
            }
        }
    }

    public void brincar(){
        if (capturado) {
            felicidade += 30;
            System.out.println("Voce brincou com o pokemon");
        }
        else{
            System.out.println("Ação inválida");
        }
    }

    public void alimentar(){
        if (capturado) {
            felicidade += 50;
            System.out.println("Voce alimentou o pokemon");
        }
        else{
            System.out.println("Ação inválida");
        }
    }

    public void falar(){
        if (capturado)
            System.out.println(nome+"!!");
        else{
            System.out.println("Ação inválida");
        }
    }

    public void evoluir(String pokemonEvoluido) {
        if (capturado && felicidade>100){
            setNome(pokemonEvoluido);
            felicidade -=100;
            System.out.println("Pokemon evoluido");
        }
        else{
            System.out.println("Ação inválida");
        }
    }
}
