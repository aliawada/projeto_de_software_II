package pacote;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import arquivos.LerArqTexto;
import lista.encadeada.ListaEncadeada;

public class Principal {

	public static void main(String[] args) {

		MeuFrame frame = new MeuFrame();
		
		ListaEncadeada<Ponto> points = new ListaEncadeada<Ponto>();
		
		LerArqTexto arq = new LerArqTexto();
		arq.openFile();
		arq.lerArquivo(points);
		arq.closeFile();
		
		JLabel status = new JLabel("Arraste o mouse para desenhar");
		frame.add(status, BorderLayout.SOUTH);
		
		PainelDesenhar paineldesenhar = new PainelDesenhar(status, points);
		frame.add(paineldesenhar, BorderLayout.CENTER);
		
		
		/*JButton salvarArq = new JButton();
		salvarArq.setText("Salvar Em Arquivo");
		frame.add(salvarArq, BorderLayout.NORTH);
		
		salvarArq.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String string;   
			    Iterador<Ponto> it = points.getInicio();
				Ponto ponto;
				if(e.getSource() == salvarArq) {
					while((ponto = it.proximo()) != null) {
					string = String.format("%d %d\r\n", ponto.x,ponto.y);
				    ManipuladorArquivo.escritor("PainelDeDesenhar.txt", string);
		      }
			 }
			}
		  });*/
		
	}

}
