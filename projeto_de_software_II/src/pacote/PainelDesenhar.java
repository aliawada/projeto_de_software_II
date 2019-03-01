package pacote;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Classe de adaptadores utilizada para implementar rotinas de tratamento de evento.
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

import arquivos.ManipuladorArquivo;
import lista.encadeada.Iterador;
import lista.encadeada.ListaEncadeada;

public class PainelDesenhar extends JPanel {
	// lista das referências Point
	private final ListaEncadeada<Ponto> points;

	// configura GUI e registra rotinas de tratamento de evento de mouse
	public PainelDesenhar(JLabel status, ListaEncadeada<Ponto> points) {
		// trata evento de movimento de mouse do frame
		addMouseMotionListener(new MouseMotionAdapter() // classe interna anônima
		{

			@Override
			public void mouseMoved(MouseEvent event) {
				super.mouseMoved(event);
				status.setText("Moved in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " + points.getTamanho());
			}

			// armazena coordenadas da ação de arrastar e repinta
			@Override
			public void mouseDragged(MouseEvent event) {
				points.inserirFim(new Ponto(event.getPoint().x, event.getPoint().y));
				repaint(); // repinta JFrame
				status.setText("Dragged in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " + points.getTamanho());
			}
		});
		this.points = points;
	}

	// desenha ovais em um quadro delimitador de 4 x 4 nas localizações
	// especificadas na janela
	@Override
	public void paintComponent(Graphics g) {

		Iterador<Ponto> it = points.getInicio();
		Ponto ponto;

		super.paintComponent(g); // limpa a área de desenho

		// desenha todos os pontos
		while((ponto = it.proximo()) != null) {
			g.fillOval(ponto.x, ponto.y, 4, 4);
		}
	}

}// fim da classe PaintPanel
