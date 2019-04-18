package arquivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import formas.Circulo;
import formas.Linha;
import formas.Ponto;
import formas.Retangulo;
import formas.Triangulo;
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
				else if(parts[0].equals("Triangulo")) {
					doc.inserirFim(new Triangulo(new Linha(new Ponto(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])), 
																				new Ponto(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))),
																	  new Linha(new Ponto(Integer.valueOf(parts[5]), Integer.valueOf(parts[6])), 
																			  	new Ponto(Integer.valueOf(parts[7]), Integer.valueOf(parts[8]))),
																	  new Linha(new Ponto(Integer.valueOf(parts[9]), Integer.valueOf(parts[10])), 
																			  	new Ponto(Integer.valueOf(parts[11]), Integer.valueOf(parts[12])))));
				}
				else if(parts[0].equals("Retangulo")) {
					doc.inserirFim(new Retangulo(new Ponto(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])), 
																	  Integer.valueOf(parts[3]), Integer.valueOf(parts[4])));
				}
				else if(parts[0].equals("Circulo")) {
					doc.inserirFim(new Circulo(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), Integer.valueOf(parts[3])));
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