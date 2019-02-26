package pacote;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Principal {

	public static void main(String[] args) {

		MeuFrame frame = new MeuFrame();

		JLabel status = new JLabel("Arraste o mouse para desenhar");
		frame.add(status, BorderLayout.SOUTH);
		
		PainelDesenhar paineldesenhar = new PainelDesenhar(status);
		frame.add(paineldesenhar, BorderLayout.CENTER);

	}

}
