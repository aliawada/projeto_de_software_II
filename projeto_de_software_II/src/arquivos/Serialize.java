package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import lista.encadeada.Iterador;
import pacote.Documento;
import pacote.FormaGeometrica;

public class Serialize
{	
	public static void serialize(File file, Documento doc) {
      try
      {
         FileOutputStream fileOut = new FileOutputStream(file);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
      
 		 Iterador<FormaGeometrica> it = doc.getIterador();
 		 FormaGeometrica forma;
         
 		 while((forma = it.proximo()) != null) {
         out.writeObject(forma.getClass().getSimpleName() + " " + forma.toStringArq());
         
 		 }
 		 
         out.close();
         fileOut.close();
      } catch(IOException i) {
          i.printStackTrace();
      }
	}
}