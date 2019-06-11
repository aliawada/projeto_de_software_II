package pacote;

import manipuladores.ManipuladorForma;

public interface FormaGeometrica {
		
	String toString();
	String toTextLine();
    String toTextLineBD();
    String getStrPosition();
    String toStringArq();
    
	ManipuladorForma getManipulador();
	
	
}
