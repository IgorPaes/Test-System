package projetoPI;

import java.util.Arrays;
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

	static String recebeLimpaString() {
		
		Scanner scan = new Scanner(System.in); 
		String retornoDoScanner = scan.nextLine(); 

		System.out.print("\033\143");

		return retornoDoScanner;
	}

	static void authTipoUsuario(int EscolhaTipousuario) {

		switch(EscolhaTipousuario) {

			case 1:
				AuthSenhaProfessor();
			break;
			
			case 2:
				AuthUsuarioAluno();
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
							 
			boolean senhaCheck = senha == senhaDigitada;

			if(senhaCheck) {
	
				menuProfessor(true, 0);
				break;

			}else if(!senhaCheck && tentativas != maxTentativasSenha) {

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

	static void AuthUsuarioAluno() {
	
		String nomeUsuario[] = {"Pedro", "Julio", "Erike", "Guilherme", "Igor", "Vitor", "Victor"};

		System.out.println("Lista de nomes: " + Arrays.toString(nomeUsuario) + "\n");
		System.out.printf("Digite o seu nome: ");
		String nomeAluno = recebeLimpaString().toUpperCase();

		int maxTentativasSenha = 3;

		for(int tentativas = 1; tentativas < (maxTentativasSenha + 1); tentativas++) {
				
			boolean usuarioCheck = false;

			for(int i = 0; i < nomeUsuario.length; i++) {

				if(nomeAluno.equals(nomeUsuario[i].toUpperCase())) {
					
					usuarioCheck = true;

				}

			}

			if(usuarioCheck) {
	
				menuInicialProva(nomeAluno);
				break;

			}else if(!usuarioCheck && tentativas != maxTentativasSenha) {

				int erroTentativas = maxTentativasSenha - tentativas;

				if(erroTentativas > 1) {

					System.out.printf("Usuário incorreto, você possue mais %d tentavivas: \n", erroTentativas);
					System.out.println("Nomes da lista: " + Arrays.toString(nomeUsuario));
					System.out.printf("\nDigite: ");

				}else {

					System.out.printf("Usuário incorreto, você possue mais %d tentaviva: \n", erroTentativas);
					System.out.println("Nomes da lista: " + Arrays.toString(nomeUsuario));
					System.out.printf("\nDigite: ");

				}

				nomeAluno = recebeLimpaString().toUpperCase();

			}
			
		}

	}

	static float listaValoresQuestoesRetornada[];
	static String listaQuestoesProntas[][] = new String[3][10];

	static void menuProfessor(boolean altResposta, int numeroEscolhido) {	

		int numeroEscolhidoProfessor = 0;
		
		if(altResposta) {

			do{

				System.out.println("+-----------------------------------------------+");
				System.out.println("***         MENU DE EDIÇÃO DA PROVA!          ***");
				System.out.println("+-----------------------------------------------+");
				System.out.println("1) QUANTIDADE DE QUESTÕES");
				System.out.println("2) GERAR OS VALORES DAS QUESTÕES");
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
					listaValoresQuestoesRetornada = controleValorQuestoes(10);			
				}else {
					listaValoresQuestoesRetornada = controleValorQuestoes(qtdQuestoes);	
				}
			break;

			case 3:
				listaQuestoesProntas = ativaDesativaQuestoesAleatorias();
			break;

			case 4:
				maxTentativasAluno();
			break;

			case 0:
				menuInicial();
			break;

		}
	
		if(numeroEscolhidoProfessor > 0) {

			voltarMenu(numeroEscolhidoProfessor);

		}

	}
	
	static void voltarMenu(int numeroEscolhidoProfessor) {

		int digitoVoltarContinuar;

		do {
			
			System.out.println("+-----------------------------------------------+");
			System.out.println("Digite 1 para continuar ou 0 para voltar ao menu de edição:");
			System.out.println("1) Alterar Resposta");
			System.out.println("0) Voltar Menu");
			System.out.println("+-----------------------------------------------+");
			digitoVoltarContinuar = recebeLimpaInt();

		}while(digitoVoltarContinuar != 1 && digitoVoltarContinuar != 0);

		if(digitoVoltarContinuar == 1) {
			
			menuProfessor(false, numeroEscolhidoProfessor);

		}else {

			menuProfessor(true, 0);

		}

	}

	
	static String[][] questoesProva() {
		
		String listaQuestoesRespostas[][] = new String[3][10];

		listaQuestoesRespostas[0][0] = "Qual dos seguintes tipos de dados em Java representa números inteiros sem casas decimais?";
		listaQuestoesRespostas[0][1] = "Qual é a saída deste código Java?\n int x = 5;\nSystem.out.println(x++);";
		listaQuestoesRespostas[0][2] = "Em Java, qual é a palavra-chave utilizada para definir uma classe?";
		listaQuestoesRespostas[0][3] = "Qual é a estrutura de controle em Java utilizada para repetir um bloco de código várias vezes?";
		listaQuestoesRespostas[0][4] = "O que o seguinte código Java faz?\n String nome = 'João'\nSystem.out.println(nome.length())";
		listaQuestoesRespostas[0][5] = "Em Java, qual é a forma correta de declarar um array de inteiros chamado 'numeros' com tamanho 5?";
		listaQuestoesRespostas[0][6] = "O que o seguinte código Java faz?\nint resultado = Math.abs(-10);\nSystem.out.println(resultado);";
		listaQuestoesRespostas[0][7] = "Qual é a forma correta de escrever um comentário de várias linhas em Java?";
		listaQuestoesRespostas[0][8] = "Em Java, como você chama um método de uma classe 'MinhaClasse'?";
		listaQuestoesRespostas[0][9] = "Qual é a saída deste código Java? int[] numeros = {1, 2, 3, 4, 5}\nfor (int i = 0; i < numeros.length; i++) {\nSystem.out.print(numeros[i] + ' ')\n}";

		listaQuestoesRespostas[1][0] =
		"A)  String 4 \n"+
		"B)  float 2 \n" + 
		"C)  double 3 \n" + 
		"D)  int 1 \n" ;
		listaQuestoesRespostas[1][1] =
        "A)  4 \n" +
		"B)  5 \n" +
		"C)  6 \n" + 
		"D)  O código resultará em um erro de compilação \n";
		listaQuestoesRespostas[1][2] = 
		"A)  class \n" +
		"B)  public \n" + 
		"C)  static \n" + 
		"D)  void \n";
		listaQuestoesRespostas[1][3] =
		"A)  if \n" + 
		"B)  switch \n" + 
		"C)  for \n"+
		"D)  while \n"; 
		listaQuestoesRespostas[1][4] =
		"A)  Imprime o nome 'João' \n" + 
		"B)  Retorna o tamanho do nome 'João' \n" +
		"C)  Retorna a posição da letra 'o' no nome 'João' \n" + 
		"D)  O código resultará em um erro de compilação \n";
		listaQuestoesRespostas[1][5] =
		"A)  int[] numeros = new int[5]; \n" +
		"B)  int[] numeros = {1, 2, 3, 4, 5}; \n" + 
		"C)  int numeros[] = new int[5]; \n" + 
		"D)  int numeros[] = {1, 2, 3, 4, 5}; \n";
		listaQuestoesRespostas[1][6] =
		"A)  O código resultará em um erro de compilação \n"+
		"B)  Calcula a raiz quadrada de -10 \n" + 
		"C)  Calcula o seno de -10 \n" +
		"D)  Calcula o valor absoluto de -10 \n";  
		listaQuestoesRespostas[1][7] =
		"A)  // Este é um comentário \n"   + 
		"B)  /* Este é um comentário / \n" +
		"C)  // Este é um comentário / \n" + 
		"D)  /* Este é um comentário // \n";
		listaQuestoesRespostas[1][8] =
		"A)  MinhaClasse.metodo(); \n" +								
		"B)  metodo.MinhaClasse(); \n" + 
		"C)  MinhaClasse.metodo; \n" + 
		"D)  metodo.MinhaClasse; \n";
		listaQuestoesRespostas[1][9] =
		"A) O código resultará em um erro de compilação \n" + 
		"B) 5 4 3 2 1 \n" + 
		"C) 1 1 1 1 1 \n" +
		"D) 1 2 3 4 5 \n";

		listaQuestoesRespostas[2][0] = "D";
		listaQuestoesRespostas[2][1] = "B";
		listaQuestoesRespostas[2][2] = "A";
		listaQuestoesRespostas[2][3] = "C";
		listaQuestoesRespostas[2][4] = "B";
		listaQuestoesRespostas[2][5] = "A";
		listaQuestoesRespostas[2][6] = "D";
		listaQuestoesRespostas[2][7] = "B";
		listaQuestoesRespostas[2][8] = "A";
		listaQuestoesRespostas[2][9] = "D";

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

	static float[] controleValorQuestoes(int qtdQuestoes) {

		float listaValoresQuestoes[] = new float[qtdQuestoes];
		float listaValoresPossiveis[] = {0.25f,0.50f,0.75f,1.0f,1.25f,1.50f,1.75f,2.0f};

		Random random = new Random();

		byte valorMaxProva = 10;
		byte somaValorQuestoes = 0;

		while(valorMaxProva != somaValorQuestoes) {
			
			byte controleSomaValores = 0;

			for(int i = 0; i < qtdQuestoes; i++) {

				int posicaoValor = random.nextInt(listaValoresPossiveis.length);
				
				listaValoresQuestoes[i] = listaValoresPossiveis[posicaoValor];
				controleSomaValores += listaValoresQuestoes[i];

			}
			
			somaValorQuestoes = controleSomaValores;
			controleSomaValores = 0;
			
		}

		for (int i = 0; i < listaValoresQuestoes.length; i++) {
			
			System.out.println("----------------------------------------------------------");
			System.out.printf("Valor da questão %d: %.2f\n", i + 1,listaValoresQuestoes[i]);
		
		}

		return listaValoresQuestoes;
	}

	static String[][] ativaDesativaQuestoesAleatorias() {

		String listaQuestoesOriginal[][] = questoesProva();

		boolean btnAtivo = false;
		int numeroEscolhido;

		do {
				
			System.out.println("As questões estão organizadas de forma organica.");
			System.out.println("Digite 1 para ATIVAR o modo de questões aleatórias.");
			System.out.println("1) Ativar");
			System.out.println("2) Manter Desativada");
			numeroEscolhido = recebeLimpaInt();
			
		}while(numeroEscolhido <= 0 || numeroEscolhido > 2);

		if(numeroEscolhido == 1) {
			
			btnAtivo = true;

		}

		listaQuestoesOriginal = AleatorizarQuestoes(btnAtivo, listaQuestoesOriginal);

		return listaQuestoesOriginal;
	}

	static String[][] AleatorizarQuestoes(boolean ativadaDesativada, String listaQuestoesOriginal[][]) {

		if(ativadaDesativada) {

			Random random = new Random();
			int posicaoAtual = listaQuestoesOriginal.length - 1;

			while(posicaoAtual > -1) {
				
				int indiceAleatorio = random.nextInt(posicaoAtual + 1);
				String temp;

				temp = listaQuestoesOriginal[0][posicaoAtual];
				listaQuestoesOriginal[0][posicaoAtual] = listaQuestoesOriginal[0][indiceAleatorio];
				listaQuestoesOriginal[0][indiceAleatorio] = temp;

				temp = listaQuestoesOriginal[1][posicaoAtual];
				listaQuestoesOriginal[1][posicaoAtual] = listaQuestoesOriginal[1][indiceAleatorio];
				listaQuestoesOriginal[1][indiceAleatorio] = temp;

				temp = listaQuestoesOriginal[2][posicaoAtual];
				listaQuestoesOriginal[2][posicaoAtual] = listaQuestoesOriginal[2][indiceAleatorio];
				listaQuestoesOriginal[2][indiceAleatorio] = temp;

				posicaoAtual--;
			}

		}
		
		return listaQuestoesOriginal;
	}

	static int maxTentativasAluno() {

		System.out.println("Digite o maximo de tentativas do aluno:");
	    int maxTentativas = recebeLimpaInt();

		return maxTentativas;  
	}

	static void organizadorProva(String nomeAluno) {

		String listaQuestoesParaUso[][];
		float listaValoresQuestoesParaUso[];
		
		if(listaQuestoesProntas[0][0] == null) {
			
			listaQuestoesParaUso = questoesProva();
			
		}else {
			
			listaQuestoesParaUso = listaQuestoesProntas;
			
		}

		if(listaValoresQuestoesRetornada == null) {
			
			listaValoresQuestoesParaUso = new float[]{1f,1f,1f,1f,1f,1f,1f,1f,1f,1f};

		}else {

			listaValoresQuestoesParaUso = listaValoresQuestoesRetornada;
		
		}

		mostrarProva(nomeAluno, listaQuestoesParaUso, listaValoresQuestoesParaUso);
	}

	static void menuInicialProva(String nomeAluno) {

		// int escolhaMenu;

		// do {

		// 	System.out.printf("(%s) Digite 1 para iniciar ou 0 para queimar a prova:\n", nomeAluno);
		// 	System.out.println("1) INICIAR");
		// 	System.out.println("2) QUEIMAR");
		// 	escolhaMenu = recebeLimpaInt();

		// }while(escolhaMenu <= 0 || escolhaMenu > 2);

		// switch(escolhaMenu) {

		// 	case 1:
		// 		organizadorProva(nomeAluno);
		// 	break;
		
		// 	case 2:
		// 		System.out.println("ANIMAL! ERA MEME, NÃO QUER FAZER A PROVA ENTÃO RECEBA ESSA DP AI!");
		// 	break;

		// }
		organizadorProva(nomeAluno);

	}

	static void mostrarProva(String nomeAluno, String matrizQuestoes[][], float vetorValoresQuestoes[]) {

		System.out.println("-----------------------------------------------------");
		System.out.println("RECEBA ESSA PROVA COM QUESTÕES GENÊNICAS SOBRE JAVA.");
		System.out.println("----------------------- REGAS -----------------------");
		System.out.printf("1 - %s É A PRIMEIRA REGRA DO CLUBE DA LUTA;\n", nomeAluno);
		System.out.printf("2 - %s NÃO PODE COLAR, ANIMAL!;\n", nomeAluno);
		System.out.printf("3 - %s IGNORAR TODA ESTA ABA DE REGRAS;\n", nomeAluno);
		System.out.printf("4 - %s ESSA AQUI É SÓ PARA PARECER QUE TEM MAIS REGRAS!\n", nomeAluno);
		System.out.printf("5 - %s E ESSA É SÓ PARA VOCÊ LER MESMO!\n", nomeAluno);
		System.out.println("-----------------------------------------------------\n");

		int qtdAcertos;

		for(int coluna = 0; coluna < matrizQuestoes[0].length; coluna++) {
			
			String respostaQuestao;

			System.out.println(matrizQuestoes[0][coluna]);
			System.out.println(matrizQuestoes[1][coluna]);
			System.out.printf("Resposta: ");
			respostaQuestao = recebeLimpaString().toUpperCase();
			
			qtdAcertos = checarRespostaMostrar(respostaQuestao, matrizQuestoes, coluna, vetorValoresQuestoes);

		}
		System.out.print("\033\143");
		// FAZER COM QUE SE O CARA ACERTOU, A MESMA POSIÇÃO QUE O FOR DA PERGUNTA QUE ELE ACERTOU
		// SEJÁ ENTREGUE A OUTRO FOR PARA PEGAR O VALOR DA NOTA DO CARA


	}

	static void acertouErrou(boolean acertouErrou, int numbQuestao) {

		if(acertouErrou) {

			System.out.println("-----------------------");
			System.out.printf("RESPOSTA DA QUESTÃO %d\n", numbQuestao + 1);
			System.out.println("***    CORRETA!    ***");
			System.out.println("-----------------------");
		
		}else {

			System.out.println("----------------------");
			System.out.printf("RESPOSTA DA QUESTÃO %d\n", numbQuestao + 1);
			System.err.println("***    ERRADA!    ***");
			System.out.println("----------------------");

		}

	}

	static int checarRespostaMostrar(String respostaQuestao, String matrizQuestoes[][], int coluna, float vetorValoresQuestoes[]) {

		boolean acertouErrou = false;
		int qtdAcertos = 0;

		if(respostaQuestao.equals(matrizQuestoes[2][coluna])) {
			
			calcularNotaAluno(coluna, vetorValoresQuestoes);
			acertouErrou = true;
			qtdAcertos++;

		}

		acertouErrou(acertouErrou, coluna);
		return qtdAcertos;
	}

	static float calcularNotaAluno(int coluna, float vetorValoresQuestoes[]) {

		float notaAluno = 0;

		float notaRecebidaQuestao = vetorValoresQuestoes[coluna];
		notaAluno += notaRecebidaQuestao;

		// ARRUMAR AQUI NÃO SE ESTÁ PRONTO

		return notaAluno;
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
			
			System.out.println("****** CONTEÚDO DA PROVA: JAVA ******\n");

			System.out.println("Selecione a opção correspondente:");

			System.out.println("1) Professor");
			System.out.println("2) Aluno");

			numeroEscolhido = recebeLimpaInt();

		}while(numeroEscolhido <= 0 || numeroEscolhido > 2);

		questoesProva();
		authTipoUsuario(numeroEscolhido);
	}

	public static void main(String[] args) {

		menuInicial(); // :) 

	}

}
