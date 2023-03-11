package projetoPi;

import java.util.Scanner;

import entities.Personagens;
import vilao.Vilao;

public class main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner ps = new Scanner(System.in);
	
	

		String criadores = "Andre,Erike,Guilherme,Igor,Thomaz";

		System.out.println("-------------Projeto: System Fill----------------");

		System.out.println();

		System.out.println("|**************BEM VINDO JOGADOR!****************|");

		System.out.println();

		System.out.println("+-----------------------------------------------+");
		System.out.println("|                 ( 1 ) Iniciar                 |");
		System.out.println("|                 ( 2 ) Tutorial                |");
		System.out.println("|                 ( 3 ) Criadores               |");
		System.out.println("+-----------------------------------------------+");

		System.out.println();
<<<<<<< HEAD
		System.out.print("Digite o numero da opção escolhida: ");
=======
		System.out.print("Digite o numero da op��o escolhida: ");
>>>>>>> 67022923b830e0e3cea0190d13e65d2d217912a0
		// String nomePersonagem;
		int opcao = sc.nextInt();

		while (opcao >= 4) {

<<<<<<< HEAD
			System.out.println("Digite a opçao entre 1 e 3 corretamente:");
=======
			System.out.println("Digite a op��o entre 1 e 3 corretamente:");
>>>>>>> 67022923b830e0e3cea0190d13e65d2d217912a0

			opcao = sc.nextInt();
		}
		switch (opcao) {

		case 1:
			System.out.println("Digite o nome do seu personagem:");
			
			System.out.println("Digite o poder do seu personagem:");
			// System.out.println(personagem.name);
<<<<<<< HEAD
=======
			personagem.poder = ps.nextLine();

			System.out.println(personagem.toString());
			System.out.println();
			System.out.println("Quem � seu vil�o ?");
			System.out.println();
			vilao.vilao=vi.nextLine();
			/*
			 * String[] vect = vilao.viloes.split(",");
			 * 
			 * System.out.println("1- " + vect[0]); System.out.println("2- " + vect[1]);
			 * System.out.println("3- " + vect[2]); System.out.println();
			 * System.out.println("Digite a sua op��o:"); vilao.vilao = vi.nextInt();
			 */
>>>>>>> 67022923b830e0e3cea0190d13e65d2d217912a0
			

			
			System.out.println();
			System.out.println("Quem é seu vilão ?");
			System.out.println();
			
			
			
			
			
			
			
			System.out.println();
			break;
		case 2:

			System.out.println("Tutorial");

			break;
		case 3:
			System.out.println("***** Criadores *****");

			String[] vects = criadores.split(",");

			System.out.println("- " + vects[0]);
			System.out.println("- " + vects[1]);
			System.out.println("- " + vects[2]);
			System.out.println("- " + vects[3]);
			System.out.println("- " + vects[4]);

			break;

		}

		sc.close();
	}

}
