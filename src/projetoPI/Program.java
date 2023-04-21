package projetoPI;

import java.util.Scanner;

public class Program {

	static double valorNota;
	static double[] notasQuestoes = new double[10];
 
	public static void entradaDoUsuario(char tipoDeUsuario) {

		Scanner es = new Scanner(System.in);

		switch(tipoDeUsuario) { 
		
			case '1':

				char OpcoesEditarProva;

				do {

					System.out.println("\n\nEscolha uma das opções a baixo para a edição da prova.\n");

					System.out.println("1) Valor das questões");
					System.out.println("2) Ordens Aleatórias");
					System.out.println("3) Número de Tentativas");
					OpcoesEditarProva = es.next().charAt(0);

				}while(OpcoesEditarProva != '1' && OpcoesEditarProva != '2' && OpcoesEditarProva != '3');

				switch(OpcoesEditarProva) {
					case '1':

						int controle = 0;

						do {
							
							System.out.printf("Digite valor da questão %d: ", controle + 1);
							notasQuestoes[controle] = es.nextDouble();

							controle++;
						}while(controle < notasQuestoes.length);

					break;

					case '2':

						System.out.println("2");

					break;
					
					case '3':

						System.out.println("3");

					break;
				}

			break;
						
			case '2':

				System.out.println("Boa sorte aluno");

			break;

			default:
			

		}
		es.close();
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char tipoUsuario;

		do {

			System.out.println("+-----------------------------------------------+");
			System.out.println("|                                               |");
			System.out.println("|                 SEJA BEM - VINDO              |");
			System.out.println("|                                               |");
			System.out.println("+-----------------------------------------------+\n");
			
			System.out.println("******* Prova de Logica de Programação (JAVA) *******\n");
	
			System.out.println("Você é um Professor ou um Aluno?");
	
			System.out.println("1) Professor");
			System.out.println("2) Aluno");
	
			tipoUsuario = sc.next().charAt(0);

		}while(tipoUsuario != '1' && tipoUsuario != '2');

		
		entradaDoUsuario(tipoUsuario);

		// valorNota =  0;
		// double somaNota =+ valorNota;
		
		// System.out.println("Você é Professor ou Aluno?");

		// System.out.println("1) Professor");
		
		// System.out.println("2) Aluno");
		
		// int pergunta = sc.nextInt();
		
		// switch(pergunta) { 
		
		// case 1:
		// 	System.out.println("Opa, voce podera alterar algumas regras da prova.\n"
		// 			+ "Por exemplo: "
		// 			+ "Quanto vale cada pergunta e quantas tentativas o aluno podera realizar a prova.");
			
		// 	break;
		
		// case 2: System.out.println("Boa sorte aluno");
		// break;
		// }
		
		// if (pergunta == 1) {
			
		// 	System.out.println("Defina quanto vale cada pergunta, teremos um total de 5 questões");
		//   valorNota = sc.nextInt();
		// } 
		
		// System.out.println();
	
	    // System.out.println("Digite o seu nome:");
		
		// String nomeAluno = sc.nextLine();
		
		// System.out.printf("Bom, %s iremos começar a prova e desejo boa sorte *_*\n", nomeAluno);
		
		// System.out.println(valorNota);
		
		sc.close();
	}

}
