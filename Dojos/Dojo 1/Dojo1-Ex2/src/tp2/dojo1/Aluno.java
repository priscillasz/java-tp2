package tp2.dojo1;

/* Grupo:
João Gabriel Evelin D'Oliveira - 20202210036
Priscilla Aparecida Matias de Souza - 20202210023
Udson Bonin Costa - 20192210024 */

public class Aluno {
    private float media;

    public float getMedia() {
        return media;
    }

    public Aluno(float n1, float n2, float n3){
        this.media = (n1+n2+n3)/3;
    }
}
