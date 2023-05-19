package projetoPI;

import java.util.Random;
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

		for(int i = 1; i < (maxTentativasSenha + 1); i++) {
		
			boolean SenhaCheck = senha == senhaDigitada;

			if(SenhaCheck) {
	
				menuProfessor();
				// PASSAR TRUE SE PRECIAR PARA O MENU DE VOLTAR.

			}else if(!SenhaCheck && i != maxTentativasSenha) {

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

		}

	}

	static double menuProfessor() {

		int numeroEscolhidoProfessor;

		do{

			System.out.println("BEM VINDO AO MENU DE EDIÇÃO DA PROVA!");
			System.out.println("+-----------------------------------------------+");
			System.out.println("1) QUANTIDADE DE QUESTÕES");
			System.out.println("2) VALOR DAS QUESTÕES");
			System.out.println("3) MODO DE QUESTÕES ALEATÓRIAS");
			System.out.println("4) NÚMERO DE TENTATIVAS");
			System.out.println("+-----------------------------------------------+");

			numeroEscolhidoProfessor = recebeDigito();

		}while(numeroEscolhidoProfessor <= 0 || numeroEscolhidoProfessor > 4);

		int qtdQuestoes = 0;
		
		switch(numeroEscolhidoProfessor) {
			
			case 1:
				qtdQuestoes = quantidadeQuestoes();
			break;

			case 2:
				
			break;

			case 3:
				
			break;

			case 4:
				
			break;

		}

		geralQuestoes(qtdQuestoes);

		return 1;
	}

	static String[][] geralQuestoes(int qtdQuestoes) {

		String listaQuestoesRespostas[][] = new String[qtdQuestoes][qtdQuestoes];

		// PERGUNTAS
		listaQuestoesRespostas[0][0] = "1";
		listaQuestoesRespostas[0][1] = "2";
		listaQuestoesRespostas[0][2] = "3";
		listaQuestoesRespostas[0][3] = "4";
		listaQuestoesRespostas[0][4] = "5";
		listaQuestoesRespostas[0][5] = "6";
		listaQuestoesRespostas[0][6] = "7";
		listaQuestoesRespostas[0][7] = "8";
		listaQuestoesRespostas[0][8] = "9";
		listaQuestoesRespostas[0][9] = "10";

		// RESPOSTAS
		listaQuestoesRespostas[1][0] = 
		"A) Resposta 1 \n" + 
		"B) Resposta 2 \n" + 
		"C) Resposta 3 \n" + 
		"D) Resposta 4 \n" + 
		"E) Resposta 5 \n" ;
		listaQuestoesRespostas[1][1] = "2";
		listaQuestoesRespostas[1][2] = "3";
		listaQuestoesRespostas[1][3] = "4";
		listaQuestoesRespostas[1][4] = "5";
		listaQuestoesRespostas[1][5] = "6";
		listaQuestoesRespostas[1][6] = "7";
		listaQuestoesRespostas[1][7] = "8";
		listaQuestoesRespostas[1][8] = "9";
		listaQuestoesRespostas[1][9] = "10";

		return listaQuestoesRespostas;
	}

	static int quantidadeQuestoes() {

		Scanner sc = new Scanner(System.in); 
		int qtdQuestoes =  0;

		System.out.println("Digite a quantidade de questões de 1 a 10");
		qtdQuestoes = sc.nextInt();

		while(qtdQuestoes < 1 || qtdQuestoes > 10){

			System.out.println("Opção invalida Digite novamente");
			qtdQuestoes = sc.nextInt();

		}
		
		return qtdQuestoes;
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
