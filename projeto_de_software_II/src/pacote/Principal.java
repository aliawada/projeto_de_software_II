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

import arquivos.Deserialize;
import arquivos.ManipuladorArquivo;
import arquivos.RandomAcessFile;
import arquivos.Serialize;
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
	    JMenu figureMenu = new JMenu("Figure");
	    JMenuItem figurePonto = new JMenuItem("Ponto");
	    JMenuItem figureLinha = new JMenuItem("Linha");
	    
		frame.add(status, BorderLayout.SOUTH);
		frame.add(paineldesenhar, BorderLayout.CENTER);
		frame.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newAction);
	    fileMenu.add(openAction);
	    fileMenu.add(saveAction);
	    fileMenu.addSeparator();
	    fileMenu.add(exitAction);	  
	    menuBar.add(figureMenu);
	    figureMenu.add(figurePonto);
	    figureMenu.add(figureLinha);
	    
	    
		saveAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String string;   
			    Iterador<Ponto> it = points.getInicio();
				Ponto ponto;	
				if(e.getSource() == saveAction) {	
					int option = tipoArquivo();
					
					//Arquivo Texto
				    if(option == 0) {
						String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto que deseja salvar?", JOptionPane.INFORMATION_MESSAGE);
						File file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
						if(!file.exists()) {
							JOptionPane.showMessageDialog(null, "Arquivo de Texto não existe!");
						} else {
						while((ponto = it.proximo()) != null) {
						string = String.format("Ponto %d %d\r\n", ponto.x,ponto.y);
					    ManipuladorArquivo.escritor(file, string);
						}
					  }
				    }
				    
				    //Arquivo Serializable
				    if(option == 1) {
				    	String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Serializado que deseja salvar?", JOptionPane.INFORMATION_MESSAGE);
						File file = new File(System.getProperty("user.dir") + "/" +  path + ".ser");
						if(!file.exists()) {
							JOptionPane.showMessageDialog(null, "Arquivo Serializado não existe!");
						} else {
							Serialize.serialize(file);
						}
				    }
				    
				    //Arquivo Binário
				    if(option == 2) {
				    	String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Binário que deseja salvar?", JOptionPane.INFORMATION_MESSAGE);
						File file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
						if(!file.exists()) {
							JOptionPane.showMessageDialog(null, "Arquivo Binário não existe!");
						} else {
							RandomAcessFile.escreverRAF(file);
						}
				    }
				    
				    //Exit
				    if(option == -1 || option == 3) {
				    	JOptionPane.showMessageDialog(null, "Não foi possível SALVAR! o arquivo");
				    }
				    
			 }
			}
		  });	
        
		
        newAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == newAction) {
					int option = tipoArquivo();
					//Arquivo Texto
				    if(option == 0) {
					try {
						String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto que deseja criar?", JOptionPane.INFORMATION_MESSAGE);
						File newFile = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
						newFile.createNewFile();
						points.limparLista();
						ManipuladorArquivo.leitor(newFile);
						frame.repaint();
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
				   }
					
					 //Arquivo Serializable
				    if(option == 1) {
				    	try {
							String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto que deseja criar?", JOptionPane.INFORMATION_MESSAGE);
							File newFile = new File(System.getProperty("user.dir") + "/" +  path + ".ser");
							newFile.createNewFile();
							points.limparLista();
							Serialize.serialize(newFile);
							frame.repaint();
						} catch (IOException e1) {
							e1.printStackTrace();
						}	
							
				    }
				    
				    //Arquivo Binário
				    if(option == 2) {
				    	try {
							String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Binário que deseja criar?", JOptionPane.INFORMATION_MESSAGE);
							File newFile = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
							newFile.createNewFile();
							points.limparLista();
							RandomAcessFile.escreverRAF(newFile);
							frame.repaint();
						} catch (IOException e1) {
							e1.printStackTrace();
						}	
				    }
				    
				    //Exit
				    if(option == -1 || option == 3) {
				    	JOptionPane.showMessageDialog(null, "Não foi possível CRIAR! um novo Arquivo");
				    }
				    
				    
		      }	
			}
		  });	
        
       openAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == openAction) {
					int option = tipoArquivo();
					//Arquivo Texto
				    if(option == 0) {
					String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto que deseja abrir?", JOptionPane.INFORMATION_MESSAGE);
					File openFile = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
						if(!openFile.exists()) {
							JOptionPane.showMessageDialog(null, "Arquivo não existe!");
						} else {
						points.limparLista();
						ManipuladorArquivo.leitor(openFile);
						frame.repaint();
						}		
				    }
				
					 //Arquivo Serializable
				    if(option == 1) {
				    	String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Serializado que deseja abrir?", JOptionPane.INFORMATION_MESSAGE);
						File openFile = new File(System.getProperty("user.dir") + "/" +  path + ".ser");
						if(!openFile.exists()) {
							JOptionPane.showMessageDialog(null, "Arquivo não existe!");
						} else {
							points.limparLista();
							Deserialize.deserialize(openFile);
							frame.repaint();
						}
				    }
				    
				    //Arquivo Binário
				    if(option == 2) {
				    	String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Binário que deseja abrir?", JOptionPane.INFORMATION_MESSAGE);
						File openFile = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
							if(!openFile.exists()) {
								JOptionPane.showMessageDialog(null, "Arquivo não existe!");
							} else {
							points.limparLista();
							RandomAcessFile.lerRAF(openFile);
							frame.repaint();
							}		
				    }
				    
				    //Exit
				    if(option == -1 || option == 3) {
				    	JOptionPane.showMessageDialog(null, "Não foi possível ABRIR! um novo Arquivo");
				    }
			    
			    
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
	
	public static int tipoArquivo() {
		
		String[] options = new String[] {"Texto", "Serialize", "Binário"};
		
	    int response = JOptionPane.showOptionDialog(null, "Tipo de Arquivo?", "Options",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	        null, options, options[0]);
	    
	    return response;
	}
	
	public static void main(String[] args) {
			Principal.getPrincipal();	
	}

}
