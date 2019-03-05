package arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import lista.encadeada.ListaEncadeada;
import pacote.Ponto;

public class LerArqTexto {
	Scanner scanner;
	
	public void openFile() {
			try {
				scanner = new Scanner( new File("PainelDeDesenhar.txt") );
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.exit(0);
			}
	}
	
	public void closeFile() {
		if(scanner != null) {
			scanner.close();
			scanner = null;
		}
	}
	
	public void lerArquivo(ListaEncadeada<Ponto> points) {	
		while (scanner.hasNext()) { // Laço é encerrado ao ler EOF (fim do arquivo)
			points.inserirFim(new Ponto(scanner.nextInt(), scanner.nextInt()));
		}
	}
}