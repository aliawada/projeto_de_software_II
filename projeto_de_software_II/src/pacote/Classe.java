package pacote;

import javax.swing.JOptionPane;

public class Classe {
	public static void main(String[] args) {
		
		float x = Float.parseFloat(JOptionPane.showInputDialog("Forne�a o primeiro valor: "));
		float y = Float.parseFloat(JOptionPane.showInputDialog("Forne�a o segundo valor: "));	
		
		JOptionPane.showMessageDialog(null, "A soma dos valores � " + (x + y) ,"Calculadora",JOptionPane.DEFAULT_OPTION);

	}
}
