package pacote;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		MeuFrame frame = new MeuFrame();
		frame.setVisible(true);
		
		int x = Integer.parseInt(JOptionPane.showInputDialog("Forne�a o valor de x: "));
		int y = Integer.parseInt(JOptionPane.showInputDialog("Forne�a o valor de y: "));	

	}

}
