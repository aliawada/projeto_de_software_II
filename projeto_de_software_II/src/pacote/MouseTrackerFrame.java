package pacote;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseTrackerFrame extends JFrame {
	
	private final JPanel mousePanel;
	private final JLabel statusBar;
	
	public MouseTrackerFrame(){
		super("Painel");
		
		mousePanel = new JPanel();
		mousePanel.setBackground(Color.white);
		add(mousePanel, BorderLayout.CENTER);
		
		statusBar = new JLabel("Barra de Status");
		add(statusBar, BorderLayout.SOUTH);
	}
	
}
