package pacote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import arquivos.ManipuladorArquivo;
import lista.encadeada.Iterador;

public class MeuFrame extends JFrame{
	
	public MeuFrame() {
		
		super("Trabalho PSW II");
		
		this.setSize(800,400);
		this.setLocation(450,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
}