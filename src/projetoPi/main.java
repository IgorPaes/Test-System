package projetoPi;

import java.util.Scanner;

import entities.Personagens;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner ps = new Scanner(System.in);
		
		Personagens personagem = new Personagens();
		
		String criadores = "Andre,Erike,Guilherme,Igor,Thomaz";
		System.out.println( "-------------Projeto: System Fill----------------");
		
		System.out.println();

		System.out.println("|**************BEM VINDO JOGADOR!****************|");

		System.out.println();

		System.out.println("+-----------------------------------------------+");
		System.out.println("|                 ( 1 ) Iniciar                 |");
		System.out.println("|                 ( 2 ) Tutorial                |");
		System.out.println("|                 ( 3 ) Creditos                |");
		System.out.println("+-----------------------------------------------+");

		System.out.println();
		System.out.print("Digite o número da opção escolhida: ");
		//String nomePersonagem;
		int opcao = sc.nextInt();

		while (opcao > 4) {

			System.out.println("Digite a opção entre 1 e 4 corretamente:");

			opcao = sc.nextInt();
		}
		switch (opcao) {

		case 1:
			System.out.println("Digite o nome do seu personagem");
			personagem.name = ps.nextLine();
			//System.out.println(personagem.name);
			System.out.println(personagem.toString());
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

		sc.close();
	}

}
