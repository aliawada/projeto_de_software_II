package pacote;

import java.awt.*;
import javax.swing.*;

public class MeuFrame extends JFrame{
	JLabel label;
	public MeuFrame(){
		super("Janela de Desenhar");
		setLayout(new FlowLayout());
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
}
