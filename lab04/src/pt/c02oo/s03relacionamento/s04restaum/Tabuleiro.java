package pt.c02oo.s03relacionamento.s04restaum;
//declarar parametros
public class Tabuleiro {
	Peca tab[][];
	
	public Tabuleiro() {
		tab = new Peca[7][7];
	}
	
	public void inserePecas(Peca p, int pos_i, int pos_j, char tipo) {
		tab[pos_i][pos_j] = p;
		if(tipo == ' ') {
			p.setStatus(0);
		}
		else if(tipo == 'P') {
			p.setStatus(1);
		}
		else {
			p.setStatus(2);
		}
	}
	
	public boolean comandoValido(String entrada) {
		String[] list;
		int colIni = 0, linIni = 0, colFim = 0, linFim = 0;
		int colMeio,linMeio;
		boolean movimento_valido = false;
		
		list = entrada.split(":");
		
		for(int i = 0; i < list.length; i++) {			
			if(i == 0) {
				colIni = list[i].charAt(0) - 97;
				linIni = list[i].charAt(1) - 49;
			}
			else if(i == 1) {
				colFim = list[i].charAt(0) - 97;
				linFim = list[i].charAt(1) - 49;
			}
		}
		
		if(colIni == colFim) {
			colMeio = colIni;
		}
		else if(colIni < colFim) {
			colMeio = colIni + 1;
		}
		else {
			colMeio = colIni - 1;
		}
		
		if(linIni == linFim) {
			linMeio = linIni;
		}
		else if(linIni < linFim) {
			linMeio = linIni + 1;
		}
		else {
			linMeio = linIni - 1;
		}
		
		if(tab[linFim][colFim].getStatus() == 2 && tab[linMeio][colMeio].getStatus() == 1) {
			movimento_valido = true;
		}
		return movimento_valido;
	}
	
	public void alteraTabuleiro(String entrada) {
		String[] list;
		int colIni = 0, linIni = 0, colFim = 0, linFim = 0;
		int colMeio,linMeio;
		
		list = entrada.split(":");
		
		for(int i = 0; i < list.length; i++) {			
			if(i == 0) {
				colIni = list[i].charAt(0) - 97;
				linIni = list[i].charAt(1) - 49;
			}
			else if(i == 1) {
				colFim = list[i].charAt(0) - 97;
				linFim = list[i].charAt(1) - 49;
			}
		}
		
		if(colIni == colFim) {
			colMeio = colIni;
		}
		else if(colIni < colFim) {
			colMeio = colIni + 1;
		}
		else {
			colMeio = colIni - 1;
		}
		
		if(linIni == linFim) {
			linMeio = linIni;
		}
		else if(linIni < linFim) {
			linMeio = linIni + 1;
		}
		else {
			linMeio = linIni - 1;
		}
		
		if(tab[linFim][colFim].getStatus() == 2 && tab[linMeio][colMeio].getStatus() == 1) {
			tab[linIni][colIni].setStatus(2); 
			tab[linMeio][colMeio].setStatus(2);
			tab[linFim][colFim].setStatus(1);
		}
	}
	
	public void newBoard(char board[][]) {
		for(int i = 0; i < tab.length; i++) {
			for(int j = 0; j < tab[i].length; j++) {
				if(tab[i][j].getStatus() == 0) {
					board[i][j] = ' ';
				}
				else if(tab[i][j].getStatus() == 1) {
					board[i][j] = 'P';
				}
				else {
					board[i][j] = '-';
				}
			}
		}
	}
}
