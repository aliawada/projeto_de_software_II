package pacote;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MeuFrame extends JFrame implements ActionListener {
	
	private final JMenuItem item1 = new JMenuItem("1 op");
	private final JMenuItem item2 = new JMenuItem("2 op");
	
	public MeuFrame(String titulo) {
		JFrame frame = new JFrame(titulo);
		
		JMenuBar barramenu = new JMenuBar();
		JMenu menu1 = new JMenu("File");
		
		barramenu.add(menu1);
		
		item1.addActionListener(this);
		item2.addActionListener(this);
		
		menu1.add(item1);
		menu1.add(item2);
		
		frame.setJMenuBar(barramenu);	
		
		frame.setSize(400,400);
		frame.setLocation(450,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public void actionPerformed(ActionEvent E) {
		if(E.getSource() == item1) {
			
		}
		if(E.getSource() == item2) {
			System.exit(0);
		}
	}
	
}
