package projetoPI;

import java.util.Random;
import java.util.Scanner;

public class Program {

	static int recebeLimpaInt() {
		
		Scanner scan = new Scanner(System.in); 
		int retornoDoScanner = scan.nextInt(); 

		System.out.print("\033\143");

		return retornoDoScanner;
	}

	static double recebeLimpaDouble() {
		
		Scanner scan = new Scanner(System.in); 
		double retornoDoScanner = scan.nextDouble(); 

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
		int senhaDigitada = recebeLimpaInt();

		for(int tentativas = 1; tentativas < (maxTentativasSenha + 1); tentativas++) {
							 
			boolean SenhaCheck = senha == senhaDigitada;

			if(SenhaCheck) {
	
				menuProfessor(true, 0);
				break;

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

				senhaDigitada = recebeLimpaInt();

			}
			
		}

	}

	static void menuProfessor(boolean altResposta, int numeroEscolhido) {
										
		int numeroEscolhidoProfessor = 0;
		
		if(altResposta) {

			do{

				System.out.println("+-----------------------------------------------+");
				System.out.println("***         MENU DE EDIÇÃO DA PROVA!          ***");
				System.out.println("+-----------------------------------------------+");
				System.out.println("1) QUANTIDADE DE QUESTÕES");
				System.out.println("2) VER VALORES DAS QUESTÕES");
				System.out.println("3) MODO DE QUESTÕES ALEATÓRIAS");
				System.out.println("4) NÚMERO DE TENTATIVAS");
				System.out.println("+-----------------------------------------------+");
				System.out.println("0) SALVAR E VOLTAR");
				System.out.println("+-----------------------------------------------+");
	
				numeroEscolhidoProfessor = recebeLimpaInt();
	
			}while(numeroEscolhidoProfessor < 0 || numeroEscolhidoProfessor > 4);	
			
		}else {

			numeroEscolhidoProfessor = numeroEscolhido;
			
		}

		int qtdQuestoes = 0;
		
		switch(numeroEscolhidoProfessor) {
			case 1:
				qtdQuestoes = quantidadeQuestoes();
			break;

			case 2:
				if(qtdQuestoes == 0) {
					controleValorQuestoes(10);			
				}else {
					controleValorQuestoes(qtdQuestoes);	
				}
			break;

			case 3:
				
			break;

			case 4:
				
			break;

			case 0:
				menuInicial();
			break;

		}
	
		if(numeroEscolhidoProfessor > 0) {

			voltarMenu(numeroEscolhidoProfessor);

		}

		// construtorProva();

	}
	
	static void voltarMenu(int numeroEscolhidoProfessor) {

		int digitoVoltarContinuar;

		do {

			System.out.println("Digite 1 para continuar ou 0 para voltar ao menu de edição:");
			System.out.println("1) Alterar Resposta");
			System.out.println("0) Voltar Menu");
			digitoVoltarContinuar = recebeLimpaInt();

		}while(digitoVoltarContinuar != 1 && digitoVoltarContinuar != 0);

		if(digitoVoltarContinuar == 1) {
			
			menuProfessor(false, numeroEscolhidoProfessor);

		}else {

			menuProfessor(true, 0);

		}
		

	}

	static void construtorProva() {

		// String listaGeral[][] = geralQuestoes(qtdQuestoes);

	}
	
	static String[][] questoesProva() {

		String listaQuestoesRespostas[][] = new String[2][10];
		
		// PERGUNTAS
		listaQuestoesRespostas[0][0] = "Questão  : Qual dos seguintes tipos de dados em Java representa números inteiros sem casas decimais?";
		listaQuestoesRespostas[0][1] = "Questão  : Qual é a saída deste código Java?\n int x = 5;\nSystem.out.println(x++);";
		listaQuestoesRespostas[0][2] = "Questão  : Em Java, qual é a palavra-chave utilizada para definir uma classe?";
		listaQuestoesRespostas[0][3] = "Questão  : Qual é a estrutura de controle em Java utilizada para repetir um bloco de código várias vezes?";
		listaQuestoesRespostas[0][4] = "Questão  : O que o seguinte código Java faz?\n String nome = 'João'\nSystem.out.println(nome.length())";
		listaQuestoesRespostas[0][5] = "Questão  : Em Java, qual é a forma correta de declarar um array de inteiros chamado 'numeros' com tamanho 5?";
		listaQuestoesRespostas[0][6] = "Questão  : O que o seguinte código Java faz?\nint resultado = Math.abs(-10);\nSystem.out.println(resultado);";
		listaQuestoesRespostas[0][7] = "Questão  : Qual é a forma correta de escrever um comentário de várias linhas em Java?";
		listaQuestoesRespostas[0][8] = "Questão  : Em Java, como você chama um método de uma classe 'MinhaClasse'?";
		listaQuestoesRespostas[0][9] = "Questão  : Qual é a saída deste código Java? int[] numeros = {1, 2, 3, 4, 5}\nfor (int i = 0; i < numeros.length; i++) {\nSystem.out.print(numeros[i] + ' ')\n}";
	

		// ALTERNATIVAS
		listaQuestoesRespostas[1][0] = 
		"A) int 1 \n" + /*correta */
		"B) float 2 \n" + 
		"C) double 3 \n" + 
		"D) String 4 \n";
		listaQuestoesRespostas[1][1] = 
		"A)  4 \n" + 
		"B)  5 \n" + /*correta*/
		"C)  6 \n" + 
		"D)  O código resultará em um erro de compilação \n";
		listaQuestoesRespostas[1][2] = 
		"A)  class \n" + /*correta*/
		"B)  public \n" + 
		"C)  static \n" + 
		"D)  void \n";
		listaQuestoesRespostas[1][3] = 
		"A)  if \n" + 
		"B)  switch \n" + 
		"C)  while \n" + 
		"D)  for \n"; /*correta*/
		listaQuestoesRespostas[1][4] = 
		"A)  Imprime o nome 'João' \n" + 
		"B)  Retorna o tamanho do nome 'João' \n" + /*correta*/
		"C)  Retorna a posição da letra 'o' no nome 'João' \n" + 
		"D)  O código resultará em um erro de compilação \n";
		listaQuestoesRespostas[1][5] = 
		"A)  int[] numeros = new int[5]; \n" + /*correta*/
		"B)  int[] numeros = {1, 2, 3, 4, 5}; \n" + 
		"C)  int numeros[] = new int[5]; \n" + 
		"D)  int numeros[] = {1, 2, 3, 4, 5}; \n";
		listaQuestoesRespostas[1][6] = 
		"A)  Calcula o valor absoluto de -10 \n" + /*correta */
		"B)  Calcula a raiz quadrada de -10 \n" + 
		"C)  Calcula o seno de -10 \n" + 
		"D)  O código resultará em um erro de compilação \n";
		listaQuestoesRespostas[1][7] = 
		"A)  // Este é um comentário \n"   + 
		"B)  /* Este é um comentário / \n" + /*correta*/
		"C)  // Este é um comentário / \n" + 
		"D)  /* Este é um comentário // \n";
		listaQuestoesRespostas[1][8] = 
		"A)  MinhaClasse.metodo(); \n" + /*correta*/								
		"B)  metodo.MinhaClasse(); \n" + 
		"C)  MinhaClasse.metodo; \n" + 
		"D)  metodo.MinhaClasse; \n";
		listaQuestoesRespostas[1][9] = 
		"A) 1 2 3 4 5 \n" + /*correto*/
		"B) 5 4 3 2 1 \n" + 
		"C) 1 1 1 1 1 \n" + 
		"D) O código resultará em um erro de compilação\n";

		return listaQuestoesRespostas;
	}

	static int quantidadeQuestoes() {

		int qtdQuestoes = 0;

		System.out.println("Digite a quantidade de questões de 1 a 10");
		qtdQuestoes = recebeLimpaInt();

		while(qtdQuestoes < 1 || qtdQuestoes > 10){

			System.out.println("Opção invalida! digite um valor entre 1 e 10");
			qtdQuestoes = recebeLimpaInt();

		}
			
		return qtdQuestoes;
	}

	static void controleValorQuestoes(int qtdQuestoes) {
		
		Random random = new Random();

		Float listaValoresQuestoes[] = new Float[qtdQuestoes];
		
		byte valorMaxProva = 10;
		byte somaValorQuestoes = 0;

		while(somaValorQuestoes != valorMaxProva) {
			
			byte controleSomaValores = 0;

			for(int i = 0; i < qtdQuestoes; i++) {
				
				float notaQuestao = 0.25f + random.nextFloat(2);
		
				listaValoresQuestoes[i] = Math.round(notaQuestao * 10.0f) / 10.0f;
				controleSomaValores += (byte) Math.round(listaValoresQuestoes[i]);
				
			}

			somaValorQuestoes = controleSomaValores;
			controleSomaValores = 0;
		}

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

			numeroEscolhido = recebeLimpaInt();

		}while(numeroEscolhido <= 0 || numeroEscolhido > 2);

		authTipoUsuario(numeroEscolhido);
	}

	public static void main(String[] args) {

		menuInicial(); // :) 

	}

}
