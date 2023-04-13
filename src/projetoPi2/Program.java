package projetoPi2;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int valorNota =0 ;
		int somaNota =+ valorNota;
		
		System.out.println("+-----------------------------------------------+");
		System.out.println("|                                               |");
		System.out.println("|                 SEJA BEM - VINDO              |");
		System.out.println("|                                               |");
		System.out.println("+-----------------------------------------------+\n");
		
		System.out.println("******* Prova de Logica de Programação (JAVA) *******\n");

		
		
		
		System.out.println("Você é Professor ou Aluno?/n");

		System.out.println("1) Professor");
		
		System.out.println("2) Aluno");
		
		int pergunta = sc.nextInt();
		
		switch(pergunta) { 
		
		case 1:
			System.out.println("Opa, voce podera alterar algumas regras da prova.\n"
					+ "Por exemplo: "
					+ "Quanto vale cada pergunta e quantas tentativas o aluno podera realizar a prova.");
			
			break;
		
		case 2: System.out.println("Boa sorte aluno");
		break;
		}
		
		if (pergunta == 1) {
			
			System.out.println("Defina quanto vale cada pergunta, teremos um total de 5 questões");
		  valorNota = sc.nextInt();
		} 
		
		System.out.println();
	
	    System.out.println("Digite o seu nome:");
		
		String nomeAluno = sc.nextLine();
		
		System.out.printf("Bom, %s iremos começar a prova e desejo boa sorte *_*\n", nomeAluno);
		
		System.out.println(valorNota);
		
		sc.close();
	}

}
