package pacote;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import arquivos.ManipuladorArquivo;
import lista.encadeada.Iterador;
import lista.encadeada.ListaEncadeada;

public final class Principal {
	
	private static Principal principal = new Principal();
	private ListaEncadeada<Ponto> points = new ListaEncadeada<Ponto>();
	
	public void inserirFim(Ponto ponto) {
		this.points.inserirFim(ponto);
	}
	
	public Iterador<Ponto> getIterador() {
		return this.points.getInicio();
	}
	
	public Integer getTamanho() {
		return this.points.getTamanho();
	}
	
	private Principal() {
		MeuFrame frame = new MeuFrame();
		JLabel status = new JLabel("Arraste o mouse para desenhar");
		PainelDesenhar paineldesenhar = new PainelDesenhar(status);
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newAction = new JMenuItem("New");
	    JMenuItem openAction = new JMenuItem("Open");
	    JMenuItem saveAction = new JMenuItem("Save");
	    JMenuItem exitAction = new JMenuItem("Exit");
	   
		frame.add(status, BorderLayout.SOUTH);
		frame.add(paineldesenhar, BorderLayout.CENTER);
		frame.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newAction);
	    fileMenu.add(openAction);
	    fileMenu.add(saveAction);
	    fileMenu.addSeparator();
	    fileMenu.add(exitAction);	
	
		saveAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String string;   
			    Iterador<Ponto> it = points.getInicio();
				Ponto ponto;	
				if(e.getSource() == saveAction) {
					String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto que deseja salvar?", JOptionPane.INFORMATION_MESSAGE);
					File file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
					while((ponto = it.proximo()) != null) {
					string = String.format("Ponto %d %d\r\n", ponto.x,ponto.y);
				    ManipuladorArquivo.escritor(file, string);
		      }
			 }
			}
		  });	
        
		
        newAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == newAction) {
					try {
						String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto que deseja criar?", JOptionPane.INFORMATION_MESSAGE);
						File newFile = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
						newFile.createNewFile();
						points.limparLista();
						ManipuladorArquivo.leitor(newFile, points);
						SwingUtilities.updateComponentTreeUI(frame);
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
		      }	
			}
		  });	
        
       openAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == openAction) {
					String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto que deseja abrir?", JOptionPane.INFORMATION_MESSAGE);
					File openFile = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
					points.limparLista();
					ManipuladorArquivo.leitor(openFile, points);
					SwingUtilities.updateComponentTreeUI(frame);
		      }	
			}
		  });	
        
        exitAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == exitAction) {
					System.exit(0);
		      }	
			}
		  });
        
		
	}
	
	public static Principal getPrincipal() {
		if(Principal.principal == null)
			Principal.principal = new Principal();
		return Principal.principal;
	}
	
	
	
	public static void main(String[] args) {
			Principal.getPrincipal();	
	}

}
