package arquivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import formas.Circulo;
import formas.Linha;
import formas.Ponto;
import formas.Quadrado;
import formas.Retangulo;
import pacote.Documento;

public class Deserialize
{
	public static void deserialize(File file, Documento doc) {
      try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)))
      {
    	 String string;
         while((string = (String) in.readObject()) != null) {
        	 
        	 String[] parts = string.split(" ");
        	 
        	 if(parts[0].equals("Ponto")){
					doc.inserirFim(new Ponto(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])));
				}
				else if(parts[0].equals("Linha")){
					doc.inserirFim(new Linha(new Ponto(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])), 
																  new Ponto(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))));
				}
				else if(parts[0].equals("Quadrado")) {
					doc.inserirFim(new Quadrado(new Ponto(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])),
												 new Ponto(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))));
				}
				else if(parts[0].equals("Retangulo")) {
					doc.inserirFim(new Retangulo(new Ponto(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])), 
												 new Ponto(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))));
				}
				else if(parts[0].equals("Circulo")) {
					doc.inserirFim(new Circulo(new Ponto(Integer.valueOf(parts[1]) , Integer.valueOf(parts[2])), 
											   new Ponto(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))));
				}
         }
         in.close();
      }  catch (EOFException ex){
    	    //fim da leitura aqui
      } catch (Exception ex) {
          ex.printStackTrace();
      }

}
}