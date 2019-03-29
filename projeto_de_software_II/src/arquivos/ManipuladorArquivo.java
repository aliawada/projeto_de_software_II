package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import lista.encadeada.Iterador;
import pacote.FormaGeometrica;
import pacote.Linha;
import pacote.Ponto;
import pacote.Principal;

public class ManipuladorArquivo {
		
		public static void leitor(File file) {
			String string;
			try {
				BufferedReader buffRead = new BufferedReader(new FileReader(file));
				while((string = buffRead.readLine()) != null) {
					String[] parts = string.split(" ");
					//if Ponto
					if(parts[0].equals("Ponto")){
					Principal.getPrincipal().inserirFim(new Ponto(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])));
					}
					else if(parts[0].equals("Linha")){
						Principal.getPrincipal().inserirFim(new Linha(new Ponto(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])), new Ponto(Integer.valueOf(parts[3]), Integer.valueOf(parts[4]))));
					}
				}
				buffRead.close();
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		
		   public static void escritor(File file)  {
				try {
					BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file,true));
					String string;   
				    Iterador<FormaGeometrica> it = Principal.getPrincipal().getIterador();
					FormaGeometrica forma;
					while((forma = it.proximo()) != null) {
					string = String.format(forma.getClass().getSimpleName() + " " + forma.toString() + "\r\n");
					buffWrite.append(string);
					}
			        buffWrite.close(); 
				} catch (IOException e) {
					e.printStackTrace();
				}
		        
		    }
}
