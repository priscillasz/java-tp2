package com.company;

/* Exercício 14: Ler notas de alunos até que o usuário digite -1. Ao final imprimir a quantidade
de alunos, a média da turma, a maior nota e a menor nota. */

import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args){
        float nota = 0, mediaTurma, soma = 0, maiorNota = 0, menorNota = 0;
        int qtdAlunos = 0;

        Scanner scan = new Scanner(System.in);

        while (nota != -1)
        {
            System.out.println("Nota: ");
            nota = scan.nextFloat();
            if (nota > maiorNota)
                maiorNota = nota;
            if (nota < menorNota && nota != -1) // ????????
                menorNota = nota;
            soma += nota;
            if (nota != -1)
                qtdAlunos++;
        }

        mediaTurma = soma / qtdAlunos;
        System.out.println("Quantidade de alunos: "+qtdAlunos);
        System.out.println("Média da turma: "+mediaTurma);
        System.out.println("Maior nota: "+maiorNota);
        System.out.println("Menor nota: "+menorNota);
    }
}
