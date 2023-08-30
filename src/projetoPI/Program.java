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
	static int qtdQuestoesPronta = 0;

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
				System.out.println("4) MÉDIA DA PROVA");
				System.out.println("+-----------------------------------------------+");
				System.out.println("0) SALVAR E VOLTAR");
				System.out.println("+-----------------------------------------------+");
	
				numeroEscolhidoProfessor = recebeLimpaInt();
	
			}while(numeroEscolhidoProfessor < 0 || numeroEscolhidoProfessor > 4);	
			
		}else {

			numeroEscolhidoProfessor = numeroEscolhido;
			
		}
		
		int qtdQuestoes = 0;
		qtdQuestoes = qtdQuestoesPronta;

		switch(numeroEscolhidoProfessor) {
			case 1:
				quantidadeQuestoes();
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
				mediaProva();
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
		listaQuestoesRespostas[0][1] = "Qual é a saída deste código Java?\nint x = 5;\nSystem.out.println(x++);";
		listaQuestoesRespostas[0][2] = "Em Java, qual é a palavra-chave utilizada para definir uma classe?";
		listaQuestoesRespostas[0][3] = "Qual é a estrutura de controle em Java utilizada para repetir um bloco de código várias vezes?";
		listaQuestoesRespostas[0][4] = "O que o seguinte código Java faz?\nString nome = 'João'\nSystem.out.println(nome.length());";
		listaQuestoesRespostas[0][5] = "Em Java, qual é a forma correta de declarar um array de inteiros chamado 'numeros' com tamanho 5?";
		listaQuestoesRespostas[0][6] = "O que o seguinte código Java faz?\nint resultado = Math.abs(-10);\nSystem.out.println(resultado);";
		listaQuestoesRespostas[0][7] = "Qual é a forma correta de escrever um comentário de várias linhas em Java?";
		listaQuestoesRespostas[0][8] = "Qual é o método utilizado para ler uma entrada do tipo String do teclado em Java?";
		listaQuestoesRespostas[0][9] = "Qual é a saída deste código Java? int[] numeros = {1, 2, 3, 4, 5}\nfor (int i = 0; i < numeros.length; i++) {\n System.out.print(numeros[i] + ' ');}";

		listaQuestoesRespostas[1][0] =
		"A) String \n"+
		"B) float \n" + 
		"C) double \n" + 
		"D) int \n" ;
		listaQuestoesRespostas[1][1] =
        "\nA) 4 \n" +
		"B) 5 \n" +
		"C) 6 \n" + 
		"D) O código resultará em um erro de compilação \n";
		listaQuestoesRespostas[1][2] = 
		"A) class \n" +
		"B) public \n" + 
		"C) static \n" + 
		"D) void \n";
		listaQuestoesRespostas[1][3] =
		"A) if \n" + 
		"B) switch \n" + 
		"C) for \n"+
		"D) else \n"; 
		listaQuestoesRespostas[1][4] =
		"\nA) Imprime o nome 'João' \n" + 
		"B) Retorna o tamanho do nome 'João' \n" +
		"C) Retorna a posição da letra 'o' no nome 'João' \n" + 
		"D) O código resultará em um erro de compilação \n";
		listaQuestoesRespostas[1][5] =
		"A) int[] numeros = new int[5]; \n" +
		"B) int[] numeros = {1, 2, 3, 4, 5}; \n" + 
		"C) []int numeros = new int[5]; \n" + 
		"D) int numeros[] = {1, 2, 3, 4, 5}; \n";
		listaQuestoesRespostas[1][6] =
		"\nA) O código resultará em um erro de compilação \n"+
		"B) Calcula a raiz quadrada de -10 \n" + 
		"C) Calcula o seno de -10 \n" +
		"D) Calcula o valor absoluto de -10 e imprime na tela o resultado 10 \n";  
		listaQuestoesRespostas[1][7] =
		"A) // Este é um comentário \n"   + 
		"B) /* Este é um comentário */ \n" +
		"C) // Este é um comentário / \n" + 
		"D) /* Este é um comentário // \n";
		listaQuestoesRespostas[1][8] =
		"A) nextLine(); \n" +								
		"B) readLine(); \n" + 
		"C) getInput(); \n" + 
		"D) readInput(); \n";
		listaQuestoesRespostas[1][9] =
		"\nA) O código resultará em um erro de compilação \n" + 
		"B) 5 4 3 2 1 \n" + 
		"C) 1 1 1 1 1 \n" +
		"D) 1 2 3 4 5 \n";

		listaQuestoesRespostas[2][0] = "D";
		listaQuestoesRespostas[2][1] = "C";
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

	static void quantidadeQuestoes() {

		int qtdQuestoes = 0;

		System.out.println("Digite a quantidade de questões de 1 a 10");
		qtdQuestoes = recebeLimpaInt();

		while(qtdQuestoes < 1 || qtdQuestoes > 10){

			System.out.println("Opção invalida! digite um valor entre 1 e 10");
			qtdQuestoes = recebeLimpaInt();

		}

		System.out.println("Quantidade de questões adicionada com sucesso!");
		System.out.printf("VALOR: %d\n", qtdQuestoes);
		
		qtdQuestoesPronta = qtdQuestoes;	
	}	

	static float[] controleValorQuestoes(int qtdQuestoes) {

		float listaValoresQuestoes[] = new float[qtdQuestoes];
		float listaValoresPossiveis[] = {0.25f,0.50f,0.75f,1.0f,1.25f,1.50f,1.75f,2.0f,2.50f,3.0f,3.50f,5.0f,10.0f};

		Random random = new Random();

		float valorMaxProva = 10;
		float somaValorQuestoes = 0;

		while(somaValorQuestoes != valorMaxProva) {
			
			float controleSomaValores = 0;
					
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
			
			System.out.println("Modo de questões aleatórias ativado!");
			btnAtivo = true;

		}else {

			System.out.println("Modo de questões aleatórias desativado!");

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

	static double numeroMediaProva = 0;

	static void mediaProva() {

		do {

			System.out.println("Digite a nota mínima que o aluno deve alcançar na prova: ");
			numeroMediaProva = recebeLimpaDouble();

		}while(numeroMediaProva < 1 || numeroMediaProva > 10);

		System.out.println("Nova média da prova adicionada!");
		System.out.printf("VALOR: %.2f\n", numeroMediaProva);

	}

	static void organizadorProva(String nomeAluno) {

		String listaQuestoesParaUso[][];
		float listaValoresQuestoesParaUso[];
		double mediaProva;
		int qtdQuestoes;
		
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

		if(numeroMediaProva == 0) {

			mediaProva = 6;

		}else {

			mediaProva = numeroMediaProva;

		}

		if(qtdQuestoesPronta == 0) {

			qtdQuestoes = 10;
		
		}else {

			qtdQuestoes = qtdQuestoesPronta;

		}

		mostrarProva(nomeAluno, listaQuestoesParaUso, listaValoresQuestoesParaUso, mediaProva, qtdQuestoes);
	}

	static void menuInicialProva(String nomeAluno) {

		int escolhaMenu;

		do {

			System.out.printf("(%s) Digite 1 para iniciar ou 0 para queimar a prova:\n", nomeAluno);
			System.out.println("1) INICIAR");
			System.out.println("2) QUEIMAR");
			escolhaMenu = recebeLimpaInt();

		}while(escolhaMenu <= 0 || escolhaMenu > 2);

		switch(escolhaMenu) {

			case 1:
				organizadorProva(nomeAluno);
			break;
		
			case 2:
				System.out.println("-------------------------------------------------------------------");
				System.out.println("ANIMAL! ERA MEME, NÃO QUER FAZER A PROVA ENTÃO RECEBA ESSA DP AI!");
				System.out.println("-------------------------------------------------------------------");
			break;

		}

	}

	static void mostrarProva(String nomeAluno, String matrizQuestoes[][], float vetorValoresQuestoes[], double mediaProva, int qtdQuestoes) {

		System.out.println("-----------------------------------------------------");
		System.out.println("RECEBA ESSA PROVA COM QUESTÕES GENÉRICAS SOBRE JAVA.");
		System.out.println("----------------------- REGAS -----------------------");
		System.out.printf("1 - %s É A PRIMEIRA REGRA DO CLUBE DA LUTA;\n", nomeAluno);
		System.out.printf("2 - %s NÃO PODE COLAR, ANIMAL!;\n", nomeAluno);
		System.out.printf("3 - %s IGNORAR TODA ESTA ABA DE REGRAS;\n", nomeAluno);
		System.out.printf("4 - %s ESSA AQUI É SÓ PARA PARECER QUE TEM MAIS REGRAS!\n", nomeAluno);
		System.out.printf("5 - %s E ESSA É SÓ PARA VOCÊ LER MESMO!\n", nomeAluno);
		System.out.println("-----------------------------------------------------\n");
		System.out.printf("A média a ser alcançada é de: %.1f pontos.\n\n", mediaProva);

		float notaAlunoFinal = 0f;
		int qtdAcertos = 0;
		int qtdErros = 0;
		String questoesVouF[] = new String[qtdQuestoes];
		
		for(int coluna = 0; coluna < qtdQuestoes; coluna++) {
			
			String respostaQuestao;
			boolean respostaVouF;

			do {
	
				System.out.printf("%d) %s (%.2f)\n", coluna + 1, matrizQuestoes[0][coluna], vetorValoresQuestoes[coluna]);
				System.out.println(matrizQuestoes[1][coluna]);
				System.out.printf("Resposta: ");
				respostaQuestao = recebeLimpaString().toUpperCase();
				
			}while(!respostaQuestao.equals("A") && !respostaQuestao.equals("B") && !respostaQuestao.equals("C") && !respostaQuestao.equals("D"));
			
			respostaVouF = checarRespostaMostrar(respostaQuestao, matrizQuestoes, coluna);
			notaAlunoFinal += calcularNotaAluno(respostaVouF, coluna, vetorValoresQuestoes);
			qtdAcertos += qtdDeAcertos(respostaVouF);
			
			questoesVouF[coluna] = questoesCertas(respostaVouF);
			
		}

		qtdErros = qtdQuestoes - qtdAcertos;
		String textAprovadoReprovado = alunoAprovadoReprovado(notaAlunoFinal, mediaProva);

		System.out.println("\n//////--------------------------------//////");
		for(int i = 0; i < questoesVouF.length; i++) {
			
			System.out.printf("%d) %s \n", i + 1, questoesVouF[i]);

		}
		System.out.println("//////--------------------------------//////\n");

		System.out.println("***--------------------------------***");
		System.out.printf("Você acertou %d questões. \n", qtdAcertos);
		System.out.printf("Você errou %d questões. \n", qtdErros);
		System.out.println("***--------------------------------***\n");

		System.out.println("***--------------------------------***");
		System.out.printf("Sua nota foi de: %.2f \n", notaAlunoFinal);
		System.out.printf("Você foi: %s! \n", textAprovadoReprovado);
		System.out.println("***--------------------------------***\n");

	}

	static void acertouErrou(boolean acertouErrou, int numbQuestao) {

		if(acertouErrou) {

			System.out.println("-----------------------");
			System.out.printf("RESPOSTA DA QUESTÃO %d\n", numbQuestao + 1);
			System.out.println("***    CORRETA!    ***");
			System.out.println("-----------------------\n");
		
		}else {

			System.out.println("----------------------");
			System.out.printf("RESPOSTA DA QUESTÃO %d\n", numbQuestao + 1);
			System.err.println("***    ERRADA!    ***");
			System.out.println("----------------------\n");

		}

	}

	static boolean checarRespostaMostrar(String respostaQuestao, String matrizQuestoes[][], int coluna) {

		boolean acertouErrou = false;

		if(respostaQuestao.equals(matrizQuestoes[2][coluna])) {
			
			acertouErrou = true;

		}

		acertouErrou(acertouErrou, coluna);

		return acertouErrou;
	}

	static float calcularNotaAluno(boolean respostaVouF, int coluna, float vetorValoresQuestoes[]) {

		float notaRecebidaQuestao = 0f;

		if(respostaVouF) {

			notaRecebidaQuestao = vetorValoresQuestoes[coluna];

		}

		return notaRecebidaQuestao;
	}

	static int qtdDeAcertos(boolean respostaVouF) {

		int qtdCorreta = 0;

		if(respostaVouF) {
			
			qtdCorreta++;
			
		}

		return qtdCorreta;
	}

	static String questoesCertas(boolean respostaVouF) {

		String textVouF;

		if(respostaVouF) {
			
			textVouF = "ACERTOU";
			
		}else {

			textVouF = "ERROU";
			
		}

		return textVouF;
	}

	static String alunoAprovadoReprovado(float notaAlunoFinal, double mediaProva) {

		String textAprovadoReprovado;

		if(notaAlunoFinal >= mediaProva) {
			
			textAprovadoReprovado = "APROVADO";
			
		}else {

			textAprovadoReprovado = "REPROVADO";
			
		}

		return textAprovadoReprovado;
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