package projetoPI;


import java.util.Scanner;

public class Program {

	static double valorNota;
	static boolean usuarioProfessor = false;
	static boolean usuarioAluno = false;
	static double[] notasQuestoes = new double[10];
 
	public static void authEntradaDoUsuario(char TipoDeUsuario) {

		Scanner sc = new Scanner(System.in);

		switch(TipoDeUsuario) { 
		
			case '1':
				int senhaProfessor;

				System.out.println("Digite a senha para continuar!");
				senhaProfessor = sc.nextInt();

				if(senhaProfessor == 123) {
					
					usuarioProfessor = true;

				}else {

					System.out.println("Senha incorreta tente novamente mais tarde!");

				}

			break;
						
			case '2':

				usuarioAluno = true;
		
			break;

		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char tipoUsuario;

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

		authEntradaDoUsuario(tipoUsuario);
		
		System.out.print("\033\143");

		char OpcoesEditarProva;
		
	if(usuarioProfessor) {

			do {

				System.out.println("\n\nMENU DE EDIÇÃO DA PROVA!");
				System.out.println("Escolha uma das opções a baixo para a editar da prova.\n");

				System.out.println("1) Quantidade de questões");
				System.out.println("2) Valor das questões");
				System.out.println("3) Mode de ordens Aleatórias");
				System.out.println("4) Número de Tentativas");

				OpcoesEditarProva = sc.next().charAt(0);

			}while(OpcoesEditarProva != '1' && OpcoesEditarProva != '2' && OpcoesEditarProva != '3' && OpcoesEditarProva != '4');

			switch(OpcoesEditarProva) {
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

		}
		sc.close();
	}
}
