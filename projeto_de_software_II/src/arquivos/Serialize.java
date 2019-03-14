package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import lista.encadeada.Iterador;
import pacote.Ponto;
import pacote.Principal;

public class Serialize
{	
	public static void serialize(File file) {
      try
      {
         FileOutputStream fileOut = new FileOutputStream(file);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
      
 		 Iterador<Ponto> it = Principal.getPrincipal().getIterador();
         Ponto ponto;
         
 		 while((ponto = it.proximo()) != null) {
         out.writeObject(new Ponto(ponto.x,ponto.y));
 		 }
 		 
         out.close();
         fileOut.close();
      } catch(IOException i) {
          i.printStackTrace();
      }
	}
}