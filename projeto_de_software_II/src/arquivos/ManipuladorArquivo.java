package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {
    public static void leitor(String path) {
	       try {
	       BufferedReader buffRead = new BufferedReader(new FileReader(path));
	        String linha = "";
	        while (true) {
	            if (linha != null) {
	                System.out.println(linha);
	 
	            } else
	                break;
	            linha = buffRead.readLine();
	        }
	        buffRead.close();
	    } catch (IOException e){
	    	e.printStackTrace();
	    }
	   }
	 
	    public static void escritor(String path, String string)  {
			try {
				BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path,true));
				buffWrite.append(string + "\n");
		        buffWrite.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
	    }
}