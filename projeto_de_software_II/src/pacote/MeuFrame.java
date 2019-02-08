package pacote;

import java.awt.*;
import javax.swing.*;

public class MeuFrame extends JFrame{
	JLabel label;
	public MeuFrame(){
		super("Nova Janela");
		setLayout(new FlowLayout());
		setSize(400,300);
		label = new JLabel("Texto");
		add(label);
		add(new JLabel("Texto 2"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
}
