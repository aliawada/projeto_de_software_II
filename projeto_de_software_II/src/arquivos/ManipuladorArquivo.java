package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import pacote.Ponto;
import pacote.Principal;

public class ManipuladorArquivo {
		
		public static void leitor(File file) {
			String string;
			try {
				BufferedReader buffRead = new BufferedReader(new FileReader(file));
				while((string = buffRead.readLine()) != null) {
					String[] parts = string.split(" ");
					Principal.getPrincipal().inserirFim(new Ponto(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])));
				}
				buffRead.close();
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		
		   public static void escritor(File file, String string)  {
				try {
					BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file,true));
					buffWrite.append(string);
			        buffWrite.close(); 
				} catch (IOException e) {
					e.printStackTrace();
				}
		        
		    }
}
