package arquivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import lista.encadeada.Iterador;
import pacote.FormaGeometrica;
import pacote.Ponto;
import pacote.Principal;

public class RandomAcessFile {
	private static RandomAccessFile raf;
	public static void escreverRAF(File file) {
		
		try {
			 raf = new RandomAccessFile(file,"rw");
			
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo Inexistente");
			System.exit(0);
		}
		
		try {
			Iterador<FormaGeometrica> it = Principal.getPrincipal().getIterador();
	        FormaGeometrica forma;
			
	        while((forma = it.proximo()) != null) {
	        String string = forma.toString();
	        raf.writeByte(1);
			raf.writeInt(ponsto.x);
			raf.writeInt(ponto.y);
	        }
	      raf.close();
		} catch (IOException e) {
		System.out.println("Erro escrevendo no arquivo");
		}
	}
	
	public static void lerRAF(File file) {
        
		try {
			 raf = new RandomAccessFile(file,"r");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo Inexistente");
		}

		Ponto ponto = new Ponto();
		
	 while(true) {	
		 	try {     
		      raf.readByte();
		      ponto.x = raf.readInt();
		      ponto.y = raf.readInt();
		      Principal.getPrincipal().inserirFim(new Ponto(ponto.x, ponto.y));
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
