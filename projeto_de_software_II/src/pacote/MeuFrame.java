package pacote;

import java.awt.BorderLayout;
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

import connection.ConexaoMySQL;
import dao.DesenhoDAO;
import entidades.Desenho;
import formas.Circulo;
import formas.Linha;
import formas.Ponto;
import formas.PontoRepeticao;
import formas.Quadrado;
import formas.Retangulo;
import lista.encadeada.ListaEncadeada;
import visualizacao.FrameBancoDeDados;

@SuppressWarnings("serial")
public class MeuFrame extends JFrame{
	private ConexaoMySQL mysql = new ConexaoMySQL();
		
	PainelDesenhar paineldesenhar;
	Desenho desenhoAberto;
	 
	public MeuFrame(Documento doc) {
		
		super("Trabalho PSW II");
		
		this.setSize(800,600);
		this.setLocation(450,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel status = new JLabel("Arraste o mouse para desenhar");
		paineldesenhar = new PainelDesenhar(status, doc);
		PainelTexto paineltexto = new PainelTexto(doc);
		FrameBancoDeDados frameBD = new FrameBancoDeDados(this, mysql);
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newAction = new JMenuItem("New");
	    JMenuItem openAction = new JMenuItem("Open");
	    JMenuItem saveAction = new JMenuItem("Save");
	    JMenuItem exitAction = new JMenuItem("Exit");  
	    JMenu figureMenu = new JMenu("Figure");
	    JMenuItem figurePonto = new JMenuItem("Ponto");
	    JMenuItem figureLinha = new JMenuItem("Linha");
	    JMenuItem figureTriangle = new JMenuItem("Quadrado");
	    JMenuItem figureRectangle = new JMenuItem("Retangulo");
	    JMenuItem figureCircle = new JMenuItem("Circulo");
	    JMenuItem figurePencil = new JMenuItem("Repetição");
	    JMenu bdMenu = new JMenu("BD");
	    JMenuItem readBD = new JMenuItem("ler BD");
	    JMenuItem saveBD = new JMenuItem("salvar BD");
	    
		this.add(status, BorderLayout.SOUTH);
		this.add(paineldesenhar, BorderLayout.CENTER);
		this.setJMenuBar(menuBar);
		this.add(new JLabel("Pressione a Tecla DELETE para apagar o ultimo registro"), BorderLayout.NORTH);
		this.add(paineltexto, BorderLayout.WEST);
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
	    figureMenu.add(figurePencil);
	    menuBar.add(bdMenu);
	    bdMenu.add(readBD);
	    bdMenu.add(saveBD);
	    
	    paineltexto.setEditable(false);
	   
	    
	    doc.adicionaOuvinte(paineldesenhar);
	    doc.adicionaOuvinte(paineltexto);
	    
	    
		saveAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == saveAction) {	
					doc.salvarFormas();
					paineldesenhar.repaint();
			 }
			}
		  });	
        
		
        newAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == newAction) {
					doc.novoArquivo();
					paineldesenhar.repaint();
		      }	
			}
		  });	
        
       openAction.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == openAction) {
					doc.lerFormas();
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
            	   doc.crtlZ();
            	   doc.atualizaOuvinte();
               }
            }        });
        
        figurePonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figurePonto) {
					paineldesenhar.novaFormaGeometrica(new Ponto());
		      }
			}
		});
        
        figureLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureLinha) {
					paineldesenhar.novaFormaGeometrica(new Linha());
				}
			}
		});
        
        figureTriangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureTriangle) {
					paineldesenhar.novaFormaGeometrica(new Quadrado());
				}	
			}
		});  
        
        figureRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureRectangle) {
					paineldesenhar.novaFormaGeometrica(new Retangulo());
				}		
			}
		}); 
        
        figureCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figureCircle) {
					paineldesenhar.novaFormaGeometrica(new Circulo());
				}		
			}
		}); 
        
        figurePencil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == figurePencil) {
					paineldesenhar.novaFormaGeometrica(new PontoRepeticao());
				}		
			}
		}); 
        
        readBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == readBD) {
					doc.abrirFrameBD(frameBD);
				}		
			}
		});   
        
        saveBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == saveBD) {
					jMenuItemArqBdSalvarActionPerformed(e);
				}		
			}
		}); 
		
	}
	
	public void abreDesenho(Desenho desenho) {
		   
	    desenhoAberto = desenho;
	    
	    setTitle( desenho.getNome() );

        Principal.getPrincipal().getDocumentoAtivo().setListaFormas( new ListaEncadeada<>() );

        ListaEncadeada<FormaGeometrica> listaFormas = Fabrica.gerarFormasGeometricas( desenho );   
        
        Principal.getPrincipal().getDocumentoAtivo().setListaFormas(listaFormas);
        
        paineldesenhar.doc.atualizaOuvinte();
	  
   }
	
	public void jMenuItemArqBdSalvarActionPerformed(java.awt.event.ActionEvent evt) {

        if (desenhoAberto == null){
            jMenuItemArqBdSalvarComo(evt);
        }else{
            Desenho d_aux = Fabrica.criarDesenhoDao(Principal.getPrincipal().getDocumentoAtivo(), desenhoAberto.getNome());
            d_aux.setId( desenhoAberto.getId() );

            mysql.conectar();

            if (new DesenhoDAO(mysql.getConexao()).atualizarDesenho( d_aux )){
                desenhoAberto = new DesenhoDAO(mysql.getConexao()).consultaId( d_aux.getId() );
                setTitle( desenhoAberto.getNome()  );

               JOptionPane.showMessageDialog(null, desenhoAberto.getNome()+ " atualizado!");
            }else{
            	JOptionPane.showMessageDialog(null, DesenhoDAO.getInfo() );
            }
            mysql.desconectar();
        }
    }

    public void jMenuItemArqBdSalvarComo(java.awt.event.ActionEvent evt) {
        String nome = JOptionPane.showInputDialog(null,"Insira o nome do desenho:");

        if (nome != null){
            Desenho desenho = Fabrica.criarDesenhoDao(Principal.getPrincipal().getDocumentoAtivo(), nome);

            mysql.conectar();

            if (new DesenhoDAO(mysql.getConexao()).inserirDesenho(desenho)){
                desenhoAberto = new DesenhoDAO(mysql.getConexao()).consultaId(DesenhoDAO.last_genKey);
                setTitle( desenhoAberto.getNome() );

                JOptionPane.showMessageDialog(null, nome + " salvo no Banco de Dados!");
            }else{
            	JOptionPane.showMessageDialog(null, DesenhoDAO.getInfo() );
            }

            mysql.desconectar();
        }
    }

	
}