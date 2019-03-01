package pacote;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import arquivos.ManipuladorArquivo;
import lista.encadeada.Iterador;
import lista.encadeada.ListaEncadeada;

public class Principal {

	public static void main(String[] args) {

		MeuFrame frame = new MeuFrame();
		
		ListaEncadeada<Ponto> points = new ListaEncadeada<Ponto>();
		
		JLabel status = new JLabel("Arraste o mouse para desenhar");
		frame.add(status, BorderLayout.SOUTH);
		
		PainelDesenhar paineldesenhar = new PainelDesenhar(status, points);
		frame.add(paineldesenhar, BorderLayout.CENTER);
		
		JButton salvar = new JButton();
		salvar.setText("SALVAR");
		frame.add(salvar, BorderLayout.NORTH);
		
		salvar.addActionListener(new ActionListener() {
		    String string;   
		    Iterador<Ponto> it = points.getInicio();
			Ponto ponto;
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals(salvar)){
				while((ponto = it.proximo()) != null) {
					string = String.format("Ponto %d %d", ponto.x,ponto.y);
				    ManipuladorArquivo.escritor("PainelDeDesenhar.txt", string);
				}
		      }
			}
		  });

	}

}
