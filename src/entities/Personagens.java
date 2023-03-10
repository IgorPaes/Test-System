package entities;

import projetoPi.Main;

public class Personagens {

	public String  name;
	public String  poder;
	public String  cor;
	
	Main personagem = new Main();
	
public String toString() {
	if (name.equals("andre")) {
		
		return "Poder do Ar";
	}
	else if (name.equals("igor")){
		
		return "Poder da Agua";
	}
	
	else if (name.equals("erike")) {
		return "Poder da Fogo";
	}
	
	else if (name.equals("guilherme")) {
		return "Poder da Mente";
	}
	
	else if (name.equals("thomaz")) {
		return "Poder da Terra";
	}
	
	else  {
		
		return "Não temos esse personagem, escolha o personhagem correto!!"   ; 
	}
	
	
}
	
}
