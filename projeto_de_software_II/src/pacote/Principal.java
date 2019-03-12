package pacote;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;

import arquivos.ManipuladorArquivo;
import lista.encadeada.Iterador;
import lista.encadeada.ListaEncadeada;

public final class Principal {
	
	private static Principal principal = new Principal();
	private ListaEncadeada<Ponto> points = new ListaEncadeada<Ponto>();
	
	public void inserirFim(Ponto ponto) {
		this.points.inserirFim(ponto);
	}
	
	public Iterador<Ponto> getIterador() {
		return this.points.getInicio();
	}
	
	public Integer getTamanho() {
		return this.points.getTamanho();
	}
	
	private Principal() {
		MeuFrame frame = new MeuFrame();
		JLabel status = new JLabel("Arraste o mouse para desenhar");
		File file = new File("PainelDeDesenhar.txt");
		PainelDesenhar paineldesenhar = new PainelDesenhar(status);
		JButton salvarArq = new JButton();
		
		frame.add(status, BorderLayout.SOUTH);
		frame.add(paineldesenhar, BorderLayout.CENTER);
		salvarArq.setText("Salvar Em Arquivo");
		frame.add(salvarArq, BorderLayout.NORTH);
		
		ManipuladorArquivo.leitor(file, points);
		
		salvarArq.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String string;   
			    Iterador<Ponto> it = points.getInicio();
				Ponto ponto;	
				if(e.getSource() == salvarArq) {
					while((ponto = it.proximo()) != null) {
					string = String.format("Ponto %d %d\r\n", ponto.x,ponto.y);
				    ManipuladorArquivo.escritor(file, string);
		      }
			 }
			}
		  });	
		
	}
	
	public static Principal getPrincipal() {
		if(Principal.principal == null)
			Principal.principal = new Principal();
		return Principal.principal;
	}
	
	
	
	public static void main(String[] args) {
			Principal.getPrincipal();	
	}

}
