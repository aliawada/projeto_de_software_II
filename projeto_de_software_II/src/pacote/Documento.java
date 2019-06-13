package pacote;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import arquivos.Deserialize;
import arquivos.ManipuladorArquivo;
import arquivos.RandomAcessFile;
import arquivos.Serialize;
import lista.encadeada.Iterador;
import lista.encadeada.ListaEncadeada;
import visualizacao.FrameBancoDeDados;

public class Documento {
	
	private ListaEncadeada<FormaGeometrica> lista;
	
	private ListaEncadeada<OuvintePaineis> listaOuvintes;
	
	File file;
	
	
	public Documento(){
		this.lista = new ListaEncadeada<FormaGeometrica>();
		this.listaOuvintes = new ListaEncadeada<OuvintePaineis>();
	}
	
	public void inserirFim(FormaGeometrica forma) {
		this.lista.inserirFim(forma);
		atualizaOuvinte();
	}
	
	public Iterador<FormaGeometrica> getIterador() {
		return this.lista.getInicio();	
	}
	
	public Integer getTamanho() {
		return this.lista.getTamanho();
	}
	
	public ListaEncadeada<FormaGeometrica> getListaFormas() {
        return lista;
    }
    public void setListaFormas(ListaEncadeada<FormaGeometrica> lista) {
        this.lista = lista;
    }
	
	// Metodo Attach(Observer) do padrão Observer
		public void adicionaOuvinte(OuvintePaineis view) {
			listaOuvintes.inserirFim(view);
			atualizaOuvinte();
		}

		// Metodo Detach(Observer) do padrão Observer
		public void removeOuvinte(OuvintePaineis view) {
			listaOuvintes.removerOuvinte(view);
			atualizaOuvinte();
		}
	
	public void atualizaOuvinte() {
		Iterador<OuvintePaineis> i = listaOuvintes.getInicio();
		OuvintePaineis view;
		while ((view = (OuvintePaineis) i.proximo()) != null) {
			// Invoca o metodo Update do objeto Observer
			view.atualizar();
		}
	}
 
	   
	   public void salvarFormas(){
		   int option = tipoArquivo();
			
			//Arquivo Texto
		    if(option == 0) {
				try {
					   if(this.file == null) {
			    		String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto?", JOptionPane.INFORMATION_MESSAGE);
			    		this.file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
			    		this.file.createNewFile();
			    		ManipuladorArquivo.escritor(this.file, this);
			    	} else {
			    		ManipuladorArquivo.escritor(this.file, this);
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			  }
		    
		    //Arquivo Serializable
		    if(option == 1) {
		    	try {
		    	if(this.file == null) {
		    	String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Serializado que deseja salvar?", JOptionPane.INFORMATION_MESSAGE);
				this.file = new File(System.getProperty("user.dir") + "/" +  path + ".ser");
				this.file.createNewFile();
				Serialize.serialize(this.file, this);
				} else {
					Serialize.serialize(file, this);
				}
				} catch(Exception e) {
					e.printStackTrace();
				}
		    }
		    
		    //Arquivo Binário
		    if(option == 2) {
		    	try {
			    if(this.file == null) {
		    	String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Binário que deseja salvar?", JOptionPane.INFORMATION_MESSAGE);
				this.file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
				this.file.createNewFile();
				RandomAcessFile.escreverRAF(this.file, this);
				} else {
					RandomAcessFile.escreverRAF(this.file, this);
				}
			    } catch(Exception e) {
					e.printStackTrace();
				}
		    }
		    
		    //Exit
		    if(option == -1 || option == 3) {
		    	JOptionPane.showMessageDialog(null, "Não foi possível SALVAR! o arquivo");
		    }
	   }
	   
	   public void lerFormas(){
		   int option = tipoArquivo();
				//Arquivo Texto
			    if(option == 0) {
				String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto que deseja abrir?", JOptionPane.INFORMATION_MESSAGE);
				this.file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
				if(!this.file.exists()) {
					JOptionPane.showMessageDialog(null, "Arquivo não existe!");
					this.file = null;
				} else {
				lista.limparLista();
				ManipuladorArquivo.leitor(this.file, this);
				}		
		    }
		
			 //Arquivo Serializable
		    if(option == 1) {
		    	String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Serializado que deseja abrir?", JOptionPane.INFORMATION_MESSAGE);
				this.file = new File(System.getProperty("user.dir") + "/" +  path + ".ser");
				if(!this.file.exists()) {
					JOptionPane.showMessageDialog(null, "Arquivo não existe!");
					this.file = null;
				} else if(this.file.exists()) {
					lista.limparLista();
					Deserialize.deserialize(this.file, this);
				}
		    }
		    
		    //Arquivo Binário
		    if(option == 2) {
		    	String path = JOptionPane.showInputDialog(null,"Nome do Arquivo Binário que deseja abrir?", JOptionPane.INFORMATION_MESSAGE);
				this.file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
					if(!this.file.exists()) {
						JOptionPane.showMessageDialog(null, "Arquivo não existe!");
						this.file = null;
					} else {
					lista.limparLista();
					RandomAcessFile.lerRAF(this.file, this);
					
					}		
		    }
		    
		    //Exit
		    if(option == -1 || option == 3) {
		    	JOptionPane.showMessageDialog(null, "Não foi possível ABRIR! um novo Arquivo");
		    }
	   }
	   
	   public void novoArquivo(){
		   int option = tipoArquivo();
			//Arquivo Texto
		    if(option == 0) {
			try {
				String path = JOptionPane.showInputDialog(null,"Nome do Arquivo de Texto que deseja criar?", JOptionPane.INFORMATION_MESSAGE);
				this.file = new File(System.getProperty("user.dir") + "/" +  path + ".txt");
				this.file.createNewFile();
				lista.limparLista();
				ManipuladorArquivo.leitor(this.file, this);
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
					Serialize.serialize(newFile, this);
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
					RandomAcessFile.escreverRAF(newFile, this);
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
		    }
		    
		    //Exit
		    if(option == -1 || option == 3) {
		    	JOptionPane.showMessageDialog(null, "Não foi possível CRIAR! um novo Arquivo");
		    }
	   }
	  
	   public void abrirFrameBD(FrameBancoDeDados frameBD) {
	        frameBD.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	            	frameBD.dispose();
	            }
	        });
	        frameBD.setVisible(true);
	   }
	   
	   
	   
	   public void crtlZ(){
		   lista.removerFim();
	   }
	   
	   public static int tipoArquivo() {
			
			String[] options = new String[] {"Texto", "Serialize", "Binário"};
			
		    int response = JOptionPane.showOptionDialog(null, "Tipo de Arquivo?", "Options",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[0]);
		    
		    return response;
		}
	
}
