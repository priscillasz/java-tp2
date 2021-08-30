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

    public Pokemon(String nome, String tipo, float peso, float altura, int felicidade, int chanceCaptura){
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.altura = altura;
        this.felicidade = felicidade;
        this.chanceCaptura = chanceCaptura;
    }

    // getters e setters
    public String getNome(){return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getTipo(){return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public float getPeso(){return peso;}
    public void setPeso(float peso) {this.peso = peso;}

    public float getAltura(){return altura;}
    public void setAltura(float altura) {this.altura = altura;}

    public int getFelicidade(){return felicidade;}
    public void setFelicidade(int felicidade) {this.felicidade = felicidade;}

    public float getChanceCaptura(){return chanceCaptura;}
    public void setChanceCaptura(int chanceCaptura) {this.chanceCaptura = chanceCaptura;}

    // capturar
    public void capturar(){
        if (capturado)
            System.out.println("Ação inválida! O pokemon "+nome+" já foi capturado!");
        else
        {
            if (chanceCaptura > 50){
                capturado = true;
                libertado = false;
                System.out.println(nome+" foi capturado com sucesso!");
            }
            else
            {
                capturado = false;
                libertado = true;
                System.out.println("Ele escapou! Você não conseguiu capturar "+nome+" :(");
            }
        }
    }

    // libertar
    public void libertar(){
        if (libertado)
            System.out.println("Ação inválida! O pokemon já foi libertado!");
        else
        {
            if (capturado){
                libertado = true;
                capturado = false;
                System.out.println("Pokémon libertado com sucesso!");
            }
            else{ // acho que isso aqui é redundante mas ok
                libertado = true;
                System.out.println("Ação inválida! O pokémon já está libertado.");
            }
        }
    }

    // brincar -> aumenta a felicidade em 30
    public void brincar(){
        if (capturado) {
            felicidade += 30;
            System.out.println("Você brincou com "+nome+" e sua felicidade subiu para "+felicidade+"!");
        }
        else
            System.out.println("Você não pode fazer isso, pois o Pokémon não foi capturado!");

    }

    // alimentar -> aumenta a felicidade em 20
    public void alimentar(){
        if (capturado){
            felicidade += 20;
            System.out.println("Você alimentou "+nome+" e sua felicidade subiu para "+felicidade+"!");
        }
        else
            System.out.println("Você não pode fazer isso, pois o Pokémon não foi capturado!");
    }

    // falar
    public void falar(){
        if (capturado)
            System.out.println(nome+"!");
        else
            System.out.println("Você não pode fazer isso, pois o Pokémon não foi capturado!");
    }

    // evoluir
    public void evoluir(String pokemonEvoluido, String tipoEvoluido){
        if(capturado){
            if (felicidade <= 100)
                System.out.println("Evolução impossível! A felicidade do Pokémon precisa ser maior que 100 para que ele possa evoluir.");
            else
            {
                felicidade -= 100; // felicidade diminui em 100
                setNome(pokemonEvoluido); // nome e tipo mudam para o evoluído
                setTipo(tipoEvoluido);
                peso += peso; // escolhemos aumentar peso e altura
                altura += altura;

                System.out.println("Pokémon evoluído com sucesso!");
            }
        }
        else
            System.out.println("Você não pode fazer isso, pois o Pokémon não foi capturado!");
    }
}