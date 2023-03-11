package projetoPi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner ps = new Scanner(System.in);
		Scanner pdr = new Scanner(System.in);
	
	int personagem;
     String poder;
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

		System.out.print("Digite o numero da opção escolhida: ");

		// String nomePersonagem;
		int opcao = sc.nextInt();

		while (opcao >= 4) {


			System.out.println("Digite a opçao entre 1 e 3 corretamente:");



			opcao = sc.nextInt();
		}
		switch (opcao) {

		case 1:
			System.out.println("Escolha um dos personagens:");
			System.out.println();
			System.out.println("1-Seya");
			System.out.println("2-Shun");
			System.out.println("3-Ikki");
			System.out.println("4-Shiryu");
			
			
			personagem = ps.nextInt();
			
			while (personagem >=5) {


				System.out.println("Opção invalida, escolha uma opção entre 1 e 4");
				System.out.println("1-Seya");
				System.out.println("2-Shun");
				System.out.println("3-Ikki");
				System.out.println("4-Shiryu");


				personagem = sc.nextInt();
			}
			
			if (personagem == 1) {
				System.out.println("Seya de Pégaso");
			}
			else if (personagem == 2) {
				System.out.println("Shun de Adromeda");
			}
			
			else if (personagem == 3) {
				System.out.println("Ikki de Fenix");
			}
			else if (personagem == 4) {
				System.out.println("Shiryu de Dragão");
			}
			
			
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
