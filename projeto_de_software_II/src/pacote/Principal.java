package pacote;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Principal {

	public static void main(String[] args) {
		
		MeuFrame frame = new MeuFrame("Painel de Desenhar");
		
		PainelDesenhar paineldesenhar = new PainelDesenhar();
		frame.add(paineldesenhar,BorderLayout.CENTER);
		
		JLabel status = new JLabel("Arraste o mouse para desenhar");
		frame.add(status,BorderLayout.SOUTH);
	}

}
