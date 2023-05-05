package projetoPI;

import java.util.Scanner;

public class Program {

	static Scanner sc = new Scanner(System.in); 

	static int escolhaMenu() {

		int numeroEscolhidoMenu = sc.nextInt(); 

		// System.out.print("\033\143");

		return numeroEscolhidoMenu;
	}

	static void authTipoUsuario(int EscolhaTipousuario) {

		switch(EscolhaTipousuario) {
			case 1:
				AuthSenhaProfessor();
			break;

			case 2:
				System.out.println("B");
			break;
		}

	}

	static void AuthSenhaProfessor() {

		int senha = 123;

		System.out.println("Digite a senha!");
		
		int senhaDigitada = sc.nextInt();

		for(int tentativasSenha = 1; tentativasSenha < 3; tentativasSenha++) {

			System.out.printf("Senha incorreta, Você possue mais %d tentavivas: \n", 3 - tentativasSenha);
			senhaDigitada = sc.nextInt();
			
			if(senhaDigitada == senha) {

				menuProfessor();

			}
			

		}
		


	}

	static double menuProfessor() {

		int numeroEscolhidoProfessor;

		do{

			System.out.println("BEM VINDO AO MENU DO PROFESSOR!");
			System.out.println("+-----------------------------------------------+");
			System.out.println("1) QUANTIDADE DE QUESTÕES");
			System.out.println("2) VALOR DAS QUESTÕES");
			System.out.println("3) MODO DE QUESTÕES ALEATÓRIAS");
			System.out.println("4) NÚMERO DE TENTATIVAS");
			System.out.println("+-----------------------------------------------+");

			numeroEscolhidoProfessor = sc.nextInt();

		}while(numeroEscolhidoProfessor <= 0 || numeroEscolhidoProfessor > 4);

		switch(numeroEscolhidoProfessor) {
			case 1:
				menuProfessor();
			break;

			case 2:
				System.out.println("B");
			break;
		}

		return 1;
	}

	public static void main(String[] args) {

		int numeroEscolhido;

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

			numeroEscolhido = escolhaMenu();
			System.out.println(numeroEscolhido);

		}while(numeroEscolhido <= 0 || numeroEscolhido > 2);

		authTipoUsuario(numeroEscolhido);

	}

}
