package tp2.dojo1;

/* Grupo:
João Gabriel Evelin D'Oliveira - 20202210036
Priscilla Aparecida Matias de Souza - 20202210023
Udson Bonin Costa - 20192210024 */

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public int getDia() {return dia;}
    public int getMes() {return mes;}
    public int getAno() {return ano;}

    public Data (int dias, int ano){
        this.mes = dias / 30;

        if (dias % 30 == 0)
            this.dia = 30;
        else {
            this.dia = dias % 30;
            this.mes += 1;
        }

        this.ano = ano;
    }
}
