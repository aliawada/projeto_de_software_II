package pacote;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MeuFrame extends JFrame{
	
	public MeuFrame(Documento doc) {
		
		super("Trabalho PSW II");
		
		this.setSize(800,600);
		this.setLocation(450,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel status = new JLabel("Arraste o mouse para desenhar");
		PainelDesenhar paineldesenhar = new PainelDesenhar(status, doc);
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
	    JMenu propriedadesMenu = new JMenu("Propriedades");
	    JMenuItem colors = new JMenuItem("Cores");
	    
	    
		this.add(status, BorderLayout.SOUTH);
		this.add(paineldesenhar, BorderLayout.CENTER);
		this.setJMenuBar(menuBar);
		this.add(new JLabel("Pressione a Tecla DELETE para apagar o ultimo registro"), BorderLayout.NORTH);
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
	    menuBar.add(propriedadesMenu);
	    propriedadesMenu.add(colors);
	    
	    colors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == colors) {
					int response = corFormas();
					  
				   	  if(response == 0) {
				   		  paineldesenhar.color = Color.red;
					  }
				   	  else if(response == 1) {
				   		paineldesenhar.color = Color.green;
				   	  }
				   	  else if(response == 2) {
				   		paineldesenhar.color = Color.blue;
				   	  }
				   	  else if(response == 3) {
				   		paineldesenhar.color = Color.black;
				   	  }
				   	  else if(response == 4) {
				   		paineldesenhar.color = Color.yellow;
				   	  }
				}		
			}
		});  
	    
		saveAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == saveAction) {	
					Principal.getPrincipal().getDocumentoAtivo().salvarFormas();
					paineldesenhar.repaint();
			 }
			}
		  });	
        
		
        newAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == newAction) {
					Principal.getPrincipal().getDocumentoAtivo().novoArquivo();
					paineldesenhar.repaint();
		      }	
			}
		  });	
        
       openAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == openAction) {
					Principal.getPrincipal().getDocumentoAtivo().lerFormas();
					paineldesenhar.repaint();
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
        
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
               if (event.getKeyCode() == KeyEvent.VK_DELETE){
            	   Principal.getPrincipal().getDocumentoAtivo().crtlZ();
            	   paineldesenhar.repaint();
               }
            }        });
        
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
					JOptionPane.showMessageDialog(null, "Click em 3 pontos diferentes para desenhar um Retangulo!\n"
							+ "1- Onde começa\n" + "2- width\n" + "3- height");
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
	
	public static int corFormas() {
		String[] options = new String[] {"<html><font color=red face=arial><b> Vermelho", 
										 "<html><font color=green face=arial><b> Verde", 
										 "<html><font color=blue face=arial><b> Azul", 
										 "<html><font color=black face=arial><b> Preto", 
										 "<html><font color=yellow face=arial><b> Amarelo",
										 "<html><font color=white face=arial><b> Branco"};
		
	    int response = JOptionPane.showOptionDialog(null, "Cor das Formas?", "Options",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	        null, options, options[0]);
	    return response;
	}	
	
}