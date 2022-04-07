package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	AquarioLombriga aquaLom;
	String acoes;
	int acoes_realizadas = 0;
	
	public Animacao(String acoes) {
		this.acoes = acoes;
	}
	
	void conecta(AquarioLombriga aquaLom) {
		this.aquaLom = aquaLom;
	}
		
	
	public void passo() {
		if(acoes.charAt(acoes_realizadas) == 'M') {
			aquaLom.mover();
			acoes_realizadas++;
		}
		else if(acoes.charAt(acoes_realizadas) == 'C') {
			aquaLom.crescer();
			acoes_realizadas++;
		}
		else if(acoes.charAt(acoes_realizadas) == 'V') {
			aquaLom.virar();
			acoes_realizadas++;
		}
	}
	
	public String apresenta() {
		return aquaLom.apresenta();
	}
}
