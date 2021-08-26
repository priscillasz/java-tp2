package tp2.dojo1;

/* Grupo:
João Gabriel Evelin D'Oliveira - 20202210036
Priscilla Aparecida Matias de Souza - 20202210023
Udson Bonin Costa - 20192210024 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira as notas de avaliação: (mínima para passar direto, mínima para fazer prova final, e mínima para passar na média final:");
        float minimoDireta = scan.nextFloat();
        float minimoPF = scan.nextFloat();
        float minimoMF = scan.nextFloat();

        System.out.println("Insira as notas:");
        float n1 = scan.nextFloat();
        float n2 = scan.nextFloat();
        float n3 = scan.nextFloat();

        Aluno aluno1 = new Aluno(n1, n2, n3);

        if (aluno1.getMedia() >= minimoDireta)
            System.out.println("O aluno passou direto.");
        else if (aluno1.getMedia() < minimoDireta && aluno1.getMedia() >= minimoPF){
            System.out.println("O aluno ficou de prova final.");
            System.out.println("Insira a nota da prova final: ");
            float notaPF = scan.nextFloat();

            float mediaFinal = (notaPF + aluno1.getMedia())/2;
            if (mediaFinal >= minimoMF)
                System.out.println("O aluno passou.");
            else
                System.out.println("O aluno reprovou.");
        }
        else
            System.out.println("O aluno reprovou.");
        }
    }

