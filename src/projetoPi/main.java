package projetoPi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {


		System.out.println("Projeto: System Fill");

		System.out.println();

		System.out.println("|**************Ben vindo Jogador****************|");

		String nomePersonagem = escolherPersonagem();
		
		System.out.println(nomePersonagem);

	}
	
	
	static String escolherPersonagem() {
		Scanner sc = new Scanner(System.in);
		Scanner nm = new Scanner(System.in);
		
		System.out.println();

		System.out.println("+------------------------------------------------+");
		System.out.println("|                 Escolha opção 1                  |");
		System.out.println("|                 Escolha opção 2                  |");
		System.out.println("|                 Escolha opção 3                  |");
		System.out.println("|                 Escolha opção 4                  |");
		System.out.println("+------------------------------------------------+");

		System.out.println();
		System.out.print("Digite sua opação: ");
		String nomePersonagem = "";
		int opcao = sc.nextInt();

		while (opcao > 4) {

			System.out.println("Digite a opção entre 1 e 4 corretamente:");

			opcao = sc.nextInt();
		}
		switch (opcao) {

		case 1:
			nomePersonagem = "Andre";
			break;
		case 2:
			System.out.println("Digite o nome do seu personagem:");

			nomePersonagem = nm.nextLine();
			
			break;
		case 3:
			nomePersonagem = "Ygor";
			break;
		case 4:
			nomePersonagem = "Gui";
			break;

		}
		
		return nomePersonagem;
	}
}
