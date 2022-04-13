package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {
	
	
	
	public static void main(String[] args) {
	      AppRestaUm.executaJogo(null, null);
	      
	   }
	   
	   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
	      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
	      Tabuleiro tab = new Tabuleiro();
	      Peca p = new Peca();
	      String strlist[];
	      String source = "", target = "";
	      
	      String commands[] = tk.retrieveCommands();
	      
	      for (int l = 0; l < commands.length; l++)
	         System.out.println(commands[l]);
	      
	      char board[][] = {
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
	         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
	         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
	         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
	      };
	            
	      tk.writeBoard("Tabuleiro inicial", board);
	      for(int i = 0; i < board.length; i++) {
	    	  for(int j = 0; j < board[i].length; j++) {
	    		  tab.inserePecas(new Peca(), i, j, board[i][j]);
	    	  }
	      }
	      
	      for (int l = 0; l < commands.length; l++)
	    	  if(tab.comandoValido(commands[l])) {
	    		  strlist = commands[l].split(":");
	    		  source = strlist[0];
	    		  target = strlist[1];
	    		  tab.alteraTabuleiro(commands[l]);
	    		  tab.newBoard(board); // altera a matriz de chars baseado no obj tabuleiro para que se possa usar a função writeBoard do toolKit
	    		  tk.writeBoard("source: "+source+"; target: "+target, board);
	    	  }
	      tk.stop();
	   }

}
