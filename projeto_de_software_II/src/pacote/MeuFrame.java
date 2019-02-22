package pacote;

import javax.swing.JFrame;

public class MeuFrame extends JFrame{
	
	public MeuFrame() {
		
		super("Meu Frame");
		
		this.setSize(500,500);
		this.setLocation(450,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
}
