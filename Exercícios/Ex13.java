package com.company;

/* Exercício 13: Ler um número de alunos n. Em seguida, ler as notas dos n alunos e
imprimir, ao final, a média da turma */

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args){
        int n;
        float nota, soma = 0, media;

        Scanner scan = new Scanner(System.in);

        System.out.println("Número de alunos: ");
        n = scan.nextInt();

        for (int i = 1; i <= n; i++)
        {
            System.out.println("Nota do aluno "+ i+":");
            nota = scan.nextFloat();
            soma += nota;
        }

        media = soma / n;
        System.out.println("Media da turma: "+ media);
    }
}
