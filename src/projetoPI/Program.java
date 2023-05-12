package projetoPI;

import java.util.Scanner;

public class Program {

	static int recebeDigito() {
		
		Scanner sc = new Scanner(System.in); 

		int retornoDoScanner = sc.nextInt(); 

		System.out.print("\033\143");

		return retornoDoScanner;
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
		int maxTentativasSenha = 3;

		System.out.println("Digite a senha!");
		System.out.printf("SENHA: %d\n", senha);
		System.out.printf("\nDigite: ");
		int senhaDigitada = recebeDigito();

		for(int i = 1; i < maxTentativasSenha; i++) {
		
			boolean SenhaCheck = senha == senhaDigitada;

			if(!SenhaCheck) {

				int erroTentativas = maxTentativasSenha - i;

				if(erroTentativas == 1) {

					System.out.printf("Senha incorreta, você possue mais %d tentaviva: \n", erroTentativas);
					System.out.printf("SENHA: %d \n", senha);
					System.out.printf("\nDigite: ");

				}else {

					System.out.printf("Senha incorreta, você possue mais %d tentavivas: \n", erroTentativas);
					System.out.printf("SENHA: %d \n", senha);
					System.out.printf("\nDigite: ");
	
				}
				senhaDigitada = recebeDigito();

			}

			if(SenhaCheck) {
	
				menuProfessor();
				// PASSAR TRUE SE PRECIAR PARA O MENU DE VOLTAR.
	
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

			numeroEscolhidoProfessor = recebeDigito();

		}while(numeroEscolhidoProfessor <= 0 || numeroEscolhidoProfessor > 4);

		switch(numeroEscolhidoProfessor) {

			case 1:
				System.out.println("A");
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

			numeroEscolhido = recebeDigito();

		}while(numeroEscolhido <= 0 || numeroEscolhido > 2);

		authTipoUsuario(numeroEscolhido);

	}

}
