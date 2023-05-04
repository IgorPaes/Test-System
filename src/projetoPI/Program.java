package projetoPI;

import java.util.Scanner;

public class Program {

	static Scanner sc = new Scanner(System.in); 

	static char EscolhaMenu() {

		char NumeroEscolhidoMenu = sc.next().charAt(0); 

		System.out.print("\033\143");

		return NumeroEscolhidoMenu;
	}

	static void MenuProfessor(char EscolhaTipousuario) {

		switch(EscolhaTipousuario) {
			case '1':
				System.out.println("A");
			break;

			case '2':
				System.out.println("B");
			break;
		}

	}

	static double MenuProfessor() {

		System.out.println();

		return 1;
	}

	public static void main(String[] args) {

		char NumeroEscolhido;

		do {

			System.out.println("+-----------------------------------------------+");
			System.out.println("|                                               |");
			System.out.println("|                SEJA BEM - VINDO               |");
			System.out.println("|                                               |");
			System.out.println("+-----------------------------------------------+\n");
			
			System.out.println("******* Prova de Logica de Programação (JAVA) *******\n");

			System.out.println("Você é um Professor ou um Aluno?");

			System.out.println("1) Professor");
			System.out.println("2) Aluno");

			NumeroEscolhido = EscolhaMenu();

		}while(NumeroEscolhido != '1' && NumeroEscolhido != '2');

		MenuProfessor(NumeroEscolhido);
		
	}
}
