package projetoPi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner nm = new Scanner(System.in);
		System.out.println( "-------------Projeto: System Fill----------------");
		String criadores = "Andre,Erike,Guilherme,Igor,Thomaz";
		System.out.println();

		System.out.println("|**************Bem vindo Jogador****************|");

		System.out.println();

		System.out.println("+------------------------------------------------+");
		System.out.println("|                 Escolha opção 1 Jogar          |");
		System.out.println("|                 Escolha opção 2 Instruções     |");
		System.out.println("|                 Escolha opção 3 Criadores      |");
		System.out.println("+------------------------------------------------+");

		System.out.println();
		System.out.print("Digite sua opção: ");
		String nomePersonagem;
		int opcao = sc.nextInt();

		while (opcao > 4) {

			System.out.println("Digite a opção entre 1 e 4 corretamente:");

			opcao = sc.nextInt();
		}
		switch (opcao) {

		case 1:
			System.out.println("Digite o nome do seu personagem:");
			nomePersonagem = nm.nextLine();
			System.out.println(nomePersonagem);
			break;
		case 2:
			
		   System.out.println("Instruções");
			
			break;
		case 3:
			System.out.println("***** Criadores *****");
			
			String [] vect = criadores.split(",");
			
			System.out.println("- " + vect[0]);
			System.out.println("- " + vect[1]);
			System.out.println("- " + vect[2]);
			System.out.println("- " + vect[3]);
			System.out.println("- " + vect[4]);
			
			break;
		

		}

	}

}
