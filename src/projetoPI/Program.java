package projetoPI;

import java.util.Scanner;

public class Program {

	static double[] notasQuestoes = new double[10];
	static char tipoUsuario;

	public static char authEntradaDoUsuario(char TipoDeUsuario) {

		Scanner sc = new Scanner(System.in);
		char UsuarioAutenticado = ' ';
 
		switch(TipoDeUsuario) { 
		
			case '1':
				int senhaProfessor = 123;
				int senhaProfessorRecebida;
				int i = 0;

				do {
					System.out.println("Digite a senha para continuar!");
					System.out.println("Senha: 123");
					senhaProfessorRecebida = sc.nextInt();

					if(senhaProfessorRecebida == senhaProfessor) {
					
						UsuarioAutenticado = '1';
						i = 3;
	
					}else {
	
						int calc = 3 - (i + 1);
						System.out.printf("Senha incorreta, você tem %d tentativas. \n", calc);
	
					}

					i++;
				}while(i < 3);

			break;
						
			case '2':

				UsuarioAutenticado = '2';
		
			break;

		}

		return(UsuarioAutenticado);
	}

	public static char MenuEdicaoProva() {

		Scanner sc = new Scanner(System.in);
		char OpcoesEditarProva = ' ';

		if(authEntradaDoUsuario(tipoUsuario) == '1') {

			do {

				System.out.println("\n\nMENU DE EDIÇÃO DA PROVA!");
				System.out.println("Escolha uma das opções a baixo para a editar da prova.\n");

				System.out.println("1) Quantidade de questões");
				System.out.println("2) Valor das questões");
				System.out.println("3) Mode de ordens Aleatórias");
				System.out.println("4) Número de Tentativas");

				OpcoesEditarProva = sc.next().charAt(0);

			}while(OpcoesEditarProva != '1' && OpcoesEditarProva != '2' && OpcoesEditarProva != '3' && OpcoesEditarProva != '4');

		}
		return OpcoesEditarProva;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
			tipoUsuario = sc.next().charAt(0);

		}while(tipoUsuario != '1' && tipoUsuario != '2');

		System.out.print("\033\143");
		
		switch(MenuEdicaoProva()) {
			case '1':

				System.out.println("Digite o número de questões:");
				System.out.println("Limite Máximo: bloqueado em 20 questões. ");

			break;

			case '2':

				int controle = 0;

				do {
					System.out.printf("Digite valor da questão %d: ", controle + 1);
					notasQuestoes[controle] = sc.nextDouble();

					controle++;
				}while(controle < notasQuestoes.length);

			break;

			case '3':

				System.out.println("Digite 1 para ativar embaralhamento automático!");

			break;
			
			case '4':

				System.out.println("Digite o número de tentativas para refezer a prova!");

			break;
		}

		if(tipoUsuario == '2' && authEntradaDoUsuario(tipoUsuario) == '2') {

			System.out.println("A");

		}


		sc.close();
	}
}
