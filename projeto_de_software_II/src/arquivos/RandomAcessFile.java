package arquivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import formas.Circulo;
import formas.Linha;
import formas.Ponto;
import formas.Quadrado;
import formas.Retangulo;
import lista.encadeada.Iterador;
import pacote.Documento;
import pacote.FormaGeometrica;

public class RandomAcessFile {
	private static RandomAccessFile raf;
	public static void escreverRAF(File file, Documento doc) {
		
		try {
			 raf = new RandomAccessFile(file,"rw");
			
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo Inexistente");
			System.exit(0);
		}
		
		try {
			Iterador<FormaGeometrica> it = doc.getIterador();
	        FormaGeometrica forma;
			
	        while((forma = it.proximo()) != null) {
	        String string = forma.getClass().getSimpleName() + " " + forma.toStringArq();
	        String[] parts = string.split(" ");
	        
	        if(parts[0].equals("Ponto")){
	        	raf.writeByte(1);
				raf.writeInt(Integer.valueOf(parts[1]));
				raf.writeInt(Integer.valueOf(parts[2]));
			}
			else if(parts[0].equals("Linha")){
				raf.writeByte(2);
				raf.writeInt(Integer.valueOf(parts[1]));
				raf.writeInt(Integer.valueOf(parts[2]));
				raf.writeInt(Integer.valueOf(parts[3]));
				raf.writeInt(Integer.valueOf(parts[4]));
			}
			else if(parts[0].equals("Quadrado")) {
				raf.writeByte(3);
				raf.writeInt(Integer.valueOf(parts[1]));
				raf.writeInt(Integer.valueOf(parts[2]));
				raf.writeInt(Integer.valueOf(parts[3]));
				raf.writeInt(Integer.valueOf(parts[4]));
			}
			else if(parts[0].equals("Retangulo")) {
				raf.writeByte(4);
				raf.writeInt(Integer.valueOf(parts[1]));
				raf.writeInt(Integer.valueOf(parts[2]));
				raf.writeInt(Integer.valueOf(parts[3]));
				raf.writeInt(Integer.valueOf(parts[4]));
			}
			else if(parts[0].equals("Circulo")) {
				raf.writeByte(5);
				raf.writeInt(Integer.valueOf(parts[1]));
				raf.writeInt(Integer.valueOf(parts[2]));
				raf.writeInt(Integer.valueOf(parts[3]));
				raf.writeInt(Integer.valueOf(parts[4]));
			}
	      }
	      raf.close();
		} catch (IOException e) {
		System.out.println("Erro escrevendo no arquivo");
		}
	}
	
	public static void lerRAF(File file, Documento doc) {
        
		try {
			 raf = new RandomAccessFile(file,"r");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo Inexistente");
		}
		
	 while(true) {	
		 	try {     
		      byte forma = raf.readByte();
		      if(forma == 1) {
		    	  doc.inserirFim(new Ponto(raf.readInt(), raf.readInt()));
		      }
		      else if(forma == 2) {
		    	  doc.inserirFim(new Linha(new Ponto(raf.readInt(), raf.readInt()),
						  		 		   new Ponto(raf.readInt(), raf.readInt())));
		      }
		      else if(forma == 3) {
		    	  doc.inserirFim(new Quadrado(new Ponto(raf.readInt(), raf.readInt()),
		    			  					  new Ponto(raf.readInt(), raf.readInt())));
		      }
		      else if(forma == 4) {
		    	  doc.inserirFim(new Retangulo(new Ponto(raf.readInt(), raf.readInt()), 
						  					   new Ponto(raf.readInt(), raf.readInt())));
		      }
		      else if(forma == 5) {
		    	  doc.inserirFim(new Circulo(new Ponto(raf.readInt(), raf.readInt()),
		    			                     new Ponto(raf.readInt(), raf.readInt())));
		      }
			  } catch (EOFException e) {
				break;
			  } catch (IOException e) {
				break;
			  }
	 	}	
	 try {
	 		 raf.close();
	 	 } catch(IOException e) {
	 		 e.printStackTrace();
	 	 }
 }
}
