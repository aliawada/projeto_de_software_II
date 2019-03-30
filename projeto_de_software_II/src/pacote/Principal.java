package pacote;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	private ListaEncadeada<FormaGeometrica> lista = new ListaEncadeada<FormaGeometrica>();
	
	
	public void inserirFim(FormaGeometrica forma) {
		this.lista.inserirFim(forma);
	}
	
	public Iterador<FormaGeometrica> getIterador() {
		return this.lista.getInicio();
	}
	
	public Integer getTamanho() {
		return this.lista.getTamanho();
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
	    JMenuItem figureTriangle = new JMenuItem("Triangulo");
	    JMenuItem figureRectangle = new JMenuItem("Retangulo");
	    JMenuItem figureCircle = new JMenuItem("Circulo");
	    
		frame.add(status, BorderLayout.SOUTH);
		frame.add(paineldesenhar, BorderLayout.CENTER);
		frame.setJMenuBar(menuBar);
		frame.add(new JLabel("Pressione a Tecla DELETE para apagar o ultimo registro"), BorderLayout.NORTH);
		menuBar.add(fileMenu);
		fileMenu.add(newAction);
	    fileMenu.add(openAction);
	    fileMenu.add(saveAction);
	    fileMenu.addSeparator();
	    fileMenu.add(exitAction);	  
	    menuBar.add(figureMenu);
	    figureMenu.add(figurePonto);
	    figureMenu.add(figureLinha);
	    figureMenu.add(figureTriangle);
	    figureMenu.add(figureRectangle);
	    figureMenu.add(figureCircle);
	    
		saveAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
					
				if(e.getSource() == saveAction) {	
					int option = tipoArquivo();
					
					//Arquivo Texto
				    if(option == 0) {
						String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto que deseja salvar?", JOptionPane.INFORMATION_MESSAGE);
						File file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
						if(!file.exists()) {
							JOptionPane.showMessageDialog(null, "Arquivo de Texto não existe!");
						} else {
					    ManipuladorArquivo.escritor(file);
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
						lista.limparLista();
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
							lista.limparLista();
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
							lista.limparLista();
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
						lista.limparLista();
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
							lista.limparLista();
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
							lista.limparLista();
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
        
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
               if (event.getKeyCode() == KeyEvent.VK_DELETE){
            	   lista.removerFim();
            	   paineldesenhar.repaint();
               }
            }
        });
        
        figurePonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figurePonto) {
					paineldesenhar.controlePonto = true;
					paineldesenhar.controleLinha = false;
					paineldesenhar.controleTriangulo = false;
					paineldesenhar.controleRetangulo = false;
					paineldesenhar.controleCirculo = false;
		      }
			}
		});
        
        figureLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureLinha) {
					paineldesenhar.controlePonto = false;
					paineldesenhar.controleLinha = true;
					paineldesenhar.controleTriangulo = false;
					paineldesenhar.controleRetangulo = false;	
					paineldesenhar.controleCirculo = false;
					JOptionPane.showMessageDialog(null, "Pressione e Solte para desenhar uma Linha!");
				}
			}
		});
        
        figureTriangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureTriangle) {
					paineldesenhar.controlePonto = false;
					paineldesenhar.controleLinha = false;
					paineldesenhar.controleTriangulo = true;
					paineldesenhar.controleRetangulo = false;	
					paineldesenhar.controleCirculo = false;
					JOptionPane.showMessageDialog(null, "Click em 3 pontos diferentes para desenhar um Triangulo!");
				}	
			}
		});  
        
        figureRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureRectangle) {
					paineldesenhar.controlePonto = false;
					paineldesenhar.controleLinha = false;
					paineldesenhar.controleTriangulo = false;
					paineldesenhar.controleRetangulo = true;	
					paineldesenhar.controleCirculo = false;
					JOptionPane.showMessageDialog(null, "Pressione e Solte para desenhar uma diagonal, depois forneça um sen e cos!");
				}		
			}
		}); 
        
        figureCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureCircle) {
					paineldesenhar.controlePonto = false;
					paineldesenhar.controleLinha = false;
					paineldesenhar.controleTriangulo = false;
					paineldesenhar.controleRetangulo = false;
					paineldesenhar.controleCirculo = true;
					JOptionPane.showMessageDialog(null, "Pressione no Ponto Central, arraste e solte para determinar o radiano e desenhar um Circulo!");
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
