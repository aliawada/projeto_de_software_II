package arquivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import pacote.Ponto;
import pacote.Principal;

public class Deserialize
{
	public static void deserialize(File file) {
      try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)))
      {
         while(true) {
        	 Principal.getPrincipal().inserirFim( (Ponto) in.readObject() );
         }
      }  catch (EOFException ex){
    	    //fim da leitura aqui
      } catch (Exception ex) {
          ex.printStackTrace();
      }

}
}