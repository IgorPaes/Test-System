package projetoPI;

import java.util.Scanner;

public class Program {

	static int recebeLimpa() {
		
		Scanner scanner = new Scanner(System.in); 
		int retornoDoScanner = scanner.nextInt(); 

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
		int senhaDigitada = recebeLimpa();

		for(int tentativas = 1; tentativas < (maxTentativasSenha + 1); tentativas++) {
							 
			boolean SenhaCheck = senha == senhaDigitada;

			if(SenhaCheck) {
	
				menuProfessor();
				break;
				// PASSAR TRUE SE PRECIAR PARA O MENU DE VOLTAR.

			}else if(!SenhaCheck && tentativas != maxTentativasSenha) {

				int erroTentativas = maxTentativasSenha - tentativas;

				if(erroTentativas > 1) {

					System.out.printf("Senha incorreta, você possue mais %d tentavivas: \n", erroTentativas);
					System.out.printf("SENHA: %d \n", senha);
					System.out.printf("\nDigite: ");

				}else {

					System.out.printf("Senha incorreta, você possue mais %d tentaviva: \n", erroTentativas);
					System.out.printf("SENHA: %d \n", senha);
					System.out.printf("\nDigite: ");
	
				}

				senhaDigitada = recebeLimpa();

			}
			
		}

	}
	
	static void menuProfessor() {
		System.out.println("...");
		int numeroEscolhidoProfessor;

		do{

			System.out.println("+-----------------------------------------------+");
			System.out.println("***         MENU DE EDIÇÃO DA PROVA!          ***");
			System.out.println("+-----------------------------------------------+");
			System.out.println("1) QUANTIDADE DE QUESTÕES");
			System.out.println("2) VALOR DAS QUESTÕES");
			System.out.println("3) MODO DE QUESTÕES ALEATÓRIAS");
			System.out.println("4) NÚMERO DE TENTATIVAS");
			System.out.println("+-----------------------------------------------+");
			System.out.println("0) VOLTAR");
			System.out.println("+-----------------------------------------------+");

			numeroEscolhidoProfessor = recebeLimpa();

		}while(numeroEscolhidoProfessor < 0 || numeroEscolhidoProfessor > 4);

		int qtdQuestoes = 0;
		
		switch(numeroEscolhidoProfessor) {
			
			case 1:
				qtdQuestoes = quantidadeQuestoes();
			break;

			case 2:
				controleValorQuestoes();
			break;

			case 3:
				
			break;

			case 4:
				
			break;

			case 0:
				menuInicial();
			break;

		}

		// construtorProva();

	}

	static void construtorProva() {



		// String listaGeral[][] = geralQuestoes(qtdQuestoes);

	}
	
	static boolean voltarMenu() {

		int digitoVoltarContinuar;

		do {

			System.out.println("Digite 1 para continuar ou 0 para voltar ao menu de edição:");
			System.out.println("1) Alterar Resposta");
			System.out.println("0) Voltar Menu");
			digitoVoltarContinuar = recebeLimpa();

		}while(digitoVoltarContinuar != 1 && digitoVoltarContinuar != 0);

		if(digitoVoltarContinuar == 1) {

			return true;

		}else {

			menuProfessor();
			return false;

		}

	}

	static String[][] geralQuestoes(int qtdQuestoes) {

		String listaQuestoesRespostas[][] = new String[3][qtdQuestoes];

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

		// ALTERNATIVAS
		listaQuestoesRespostas[1][0] = 
		"A) Alternativa 1 \n" + 
		"B) Alternativa 2 \n" + 
		"C) Alternativa 3 \n" + 
		"D) Alternativa 4 \n";
		listaQuestoesRespostas[1][1] = "2";
		listaQuestoesRespostas[1][2] = "3";
		listaQuestoesRespostas[1][3] = "4";
		listaQuestoesRespostas[1][4] = "5";
		listaQuestoesRespostas[1][5] = "6";
		listaQuestoesRespostas[1][6] = "7";
		listaQuestoesRespostas[1][7] = "8";
		listaQuestoesRespostas[1][8] = "9";
		listaQuestoesRespostas[1][9] = "10";

		// VALOR DAS QUESTÕES
		listaQuestoesRespostas[2][0] = "1";
		listaQuestoesRespostas[2][1] = "2";
		listaQuestoesRespostas[2][2] = "0.50";
		listaQuestoesRespostas[2][3] = "1";
		listaQuestoesRespostas[2][4] = "0.50";
		listaQuestoesRespostas[2][5] = "2";
		listaQuestoesRespostas[2][6] = "0.75";
		listaQuestoesRespostas[2][7] = "1";
		listaQuestoesRespostas[2][8] = "0.25";
		listaQuestoesRespostas[2][9] = "1";

		return listaQuestoesRespostas;
	}

	static int quantidadeQuestoes() {

		int qtdQuestoes = 0;

		boolean voltarContinuar = true;

		while(voltarContinuar) {

			System.out.println("Digite a quantidade de questões de 1 a 10");
			qtdQuestoes = recebeLimpa();

			while(qtdQuestoes < 1 || qtdQuestoes > 10){

				System.out.println("Opção invalida! digite um valor entre 1 e 10");
				qtdQuestoes = recebeLimpa();

			}
			
			voltarContinuar = voltarMenu();

		}
		// AQUI TEM QUE ARRUMAR ELE ESTÁ CHAMANDO A FUNÇÃO ANTES DE RETORNAR O qtdQuestoes
		return qtdQuestoes;
	}

	static double[] controleValorQuestoes() {


		double controleValorQuestoes[] = new double[10];
		double somaValorQuestoes = 0;

		for(int i = 0; i < controleValorQuestoes.length; i++) {
			
			System.out.printf("Digite a nota de questão de número %d \n", i + 1);
			controleValorQuestoes[i] = recebeLimpa();
			somaValorQuestoes += controleValorQuestoes[i];

		}

		// if(somaValorQuestoes) {
			
		// }

		return controleValorQuestoes;
	}

	static void menuInicial() {

		int numeroEscolhido;

		do {

			System.out.print("\033\143");
			System.out.println("+-----------------------------------------------+");
			System.out.println("|                                               |");
			System.out.println("|                SEJA BEM - VINDO               |");
			System.out.println("|                                               |");
			System.out.println("+-----------------------------------------------+\n");
			
			System.out.println("****** Prova de Lógica a Programação (JAVA) ******\n");

			System.out.println("Selecione a opção correspondente:");

			System.out.println("1) Professor");
			System.out.println("2) Aluno");

			numeroEscolhido = recebeLimpa();

		}while(numeroEscolhido <= 0 || numeroEscolhido > 2);

		authTipoUsuario(numeroEscolhido);
	}

	public static void main(String[] args) {

		menuInicial(); // :) 

	}

}
