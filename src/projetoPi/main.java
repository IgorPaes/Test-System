package projetoPi;

import java.util.Scanner;


public class main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner nm = new Scanner(System.in);
		Scanner sn = new Scanner(System.in);
		String nomePersonagem;
		String criadores = "Andre,Erike,Guilherme,Igor,Thomaz";

		System.out.println();
		System.out.println( "------------- Projeto: System Fill ----------------");
		
		System.out.println();

		System.out.println("|************** BEM VINDO JOGADOR! ****************|");

		System.out.println();

		System.out.println("+-----------------------------------------------+");
		System.out.println("|                 ( 1 ) Iniciar                 |");
		System.out.println("|                 ( 2 ) Tutorial                |");
		System.out.println("|                 ( 3 ) Creditos                |");
		System.out.println("+-----------------------------------------------+");

		System.out.println();
		System.out.print("Digite o número da opção escolhida: ");
		int opcao = sc.nextInt();

		while (opcao > 4) {

			System.out.println("Digite a opção entre 1 e 4 corretamente:");

			opcao = sc.nextInt();
		}
		
		switch (opcao) {

		case 1:
			System.out.printf("Digite o nome do seu personagem: ");
			nomePersonagem = nm.nextLine();

			System.out.println("Você deseja que seu nome seja " + nomePersonagem + "?");

			System.out.printf("[Digite SIM OU NÃO]: ");
			String simOuNao = sn.nextLine().toUpperCase();

			while (simOuNao.equalsIgnoreCase( "NÃO") || simOuNao.equalsIgnoreCase( "N")) {
				
				System.out.printf("Digite o nome do seu personagem então: ");
				nomePersonagem = nm.nextLine();
				System.out.println("Você deseja que seu nome seja " + nomePersonagem + "?");
				System.out.printf("[Digite SIM OU NÃO]: ");
				simOuNao = sn.nextLine().toUpperCase();
				
			}
			if (simOuNao.equalsIgnoreCase("SIM")|| simOuNao.equalsIgnoreCase("S")){
				System.out.printf("Nome %s adicionado ao novo personagem.", nomePersonagem);
				System.out.println(" ");
			}
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
