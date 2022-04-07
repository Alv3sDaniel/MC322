package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	String acoes = "";
    int tamAqua, tamLom, pInic;
    String aquario;
    boolean esquerda;

    public AquarioLombriga(String entrada){
    	String ac ="";
        int tAqua = 0, tLom = 0, pi = 0;
		
		String aux1 = "", aux2 = "", aux3 = "" , aux4 = "";
		for(int i = 0; i < entrada.length(); i++){
		    if(i<2){
		        aux1 = aux1 + entrada.charAt(i);
		    }
		    else if(i >=2 && i < 4){
		        aux2 = aux2 + entrada.charAt(i);
		    }
		    else if(i >= 4 && i < 6){
		        aux3 = aux3 + entrada.charAt(i);
		    }
		    else{
		        aux4 = aux4 + entrada.charAt(i);
		    }
		}
		tAqua = Integer.parseInt(aux1);
		tLom = Integer.parseInt(aux2);
		pi = Integer.parseInt(aux3);
		ac = aux4;
		
		if(((pi + tLom)-1) > tAqua || pi > tAqua) {
			pi = 1;
		}
		if(tLom > tAqua) {
			tLom = tAqua;
		}
    	
        this.tamAqua = tAqua;
        this.tamLom = tLom;
        this.pInic = pi;
        this.acoes = ac;
        esquerda = true;
    }

    public String apresenta() {
    	int cont = 0;
    	aquario = "";
    	
    	if(esquerda == true){
    		for(int i = 0; i < tamAqua; i++) {
    			if(i == pInic-1 && cont < tamLom ) {
    				aquario += "0";
    				cont++;
    			}
    			else if(i >= pInic-1 && cont < tamLom ) {
    				aquario += "@";
    				cont++;
    			}
    			else {
    				aquario += "#";
    			}
        	}
    	}
    	if(esquerda == false){
    		for(int i = 0; i < tamAqua; i++) {
    			if(i == pInic-1 && cont < tamLom ) {
    				aquario += "0";
    				cont++;
    			}
    			else if((pInic-1)-i < tamLom && cont < tamLom ) {
    				aquario += "@";
    				cont++;
    			}
    			else {
    				aquario += "#";
    			}
        	}
    	}
    	
    	return aquario;
    }
    
    public void virar(){
    	if(esquerda == true){
    		esquerda = false;
    		pInic = (pInic + tamLom) - 1;
    	}
    	else {
    		esquerda = true;
    		pInic = (pInic - tamLom) + 1;
    	}
    }
    
    public void crescer() {
    	if(esquerda == true && ((pInic + tamLom)-1) < tamAqua) {
    		tamLom++;
    	}
    	else if(esquerda == false && tamLom < pInic ) {
    		tamLom++;
    	}
    }
    
    public void mover() {
    	if(esquerda == true ) {
    		if(pInic != 1) {
    			pInic = pInic - 1;
    		}
    		else {
    			virar();
    		}
    	}
    	else{
    		if(pInic != tamAqua) {
    			pInic = pInic + 1;
    		}
    		else {
    			virar();
    		}
    	}
    }
}
