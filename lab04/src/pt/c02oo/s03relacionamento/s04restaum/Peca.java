package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	private int status; // 0 == vazio; 1 == ha peca; 2 == peca retirada
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
}
