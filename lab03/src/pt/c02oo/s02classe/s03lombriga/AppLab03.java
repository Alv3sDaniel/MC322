package pt.c02oo.s02classe.s03lombriga;

public class AppLab03 {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < lombrigas.length; l++)
         System.out.println(lombrigas[l]);
      
      for(int i = 0; i < lombrigas.length; i++ ){
    	  AquarioLombriga aquarioLombriga = new AquarioLombriga(lombrigas[i]);
    	  Animacao animacao = new Animacao(aquarioLombriga.acoes);
    	  
    	  animacao.conecta(aquarioLombriga);
    	  
    	  tk.gravaPasso("=====");
    	  tk.gravaPasso(aquarioLombriga.apresentar());
          while(animacao.acoes_realizadas < animacao.acoes.length()) {
        	  animacao.passo();
        	  tk.gravaPasso(animacao.apresentar());
          }
      }
      tk.stop();
   }
}
