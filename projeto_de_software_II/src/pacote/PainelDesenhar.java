package pacote;

import java.awt.Graphics;
// Classe de adaptadores utilizada para implementar rotinas de tratamento de evento.
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lista.encadeada.Iterador;
import lista.encadeada.ListaEncadeada;

public class PainelDesenhar extends JPanel {
	// lista das refer�ncias Point
	private final ListaEncadeada<Point> points = new ListaEncadeada<Point>();

	// configura GUI e registra rotinas de tratamento de evento de mouse
	public PainelDesenhar(JLabel status) {
		// trata evento de movimento de mouse do frame
		addMouseMotionListener(new MouseMotionAdapter() // classe interna an�nima
		{

			@Override
			public void mouseMoved(MouseEvent event) {
				super.mouseMoved(event);
				status.setText("Moved in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]");
			}

			// armazena coordenadas da a��o de arrastar e repinta
			@Override
			public void mouseDragged(MouseEvent event) {
				points.inserirFim(event.getPoint());
				repaint(); // repinta JFrame
				status.setText("Dragged in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]");
			}
		});
	}

	// desenha ovais em um quadro delimitador de 4 x 4 nas localiza��es
	// especificadas na janela
	@Override
	public void paintComponent(Graphics g) {

		Iterador it = points.getInicio();
		Object obj;

		super.paintComponent(g); // limpa a �rea de desenho

		// desenha todos os pontos
		for (int j = 1; (obj = it.proximo()) != null; System.out.println(j++ + " -> " + obj)) {
			Point point = obj;
			g.fillOval(point.x, point.y, 4, 4);
		}
	}
} // fim da classe PaintPanel
