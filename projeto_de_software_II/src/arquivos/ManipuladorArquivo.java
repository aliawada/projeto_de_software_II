package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import formas.Circulo;
import formas.Linha;
import formas.Ponto;
import formas.Retangulo;
import formas.Triangulo;
import lista.encadeada.Iterador;
import pacote.Documento;
import pacote.FormaGeometrica;
import pacote.Principal;

public class ManipuladorArquivo {
		
		public static void leitor(File file, Documento doc) {
			String string;
			try {
				BufferedReader buffRead = new BufferedReader(new FileReader(file));
				while((string = buffRead.readLine()) != null) {
					String[] parts = string.split(" ");
					//if Ponto
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
				    Iterador<FormaGeometrica> it = Principal.getPrincipal().getDocumentoAtivo().getIterador();
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
