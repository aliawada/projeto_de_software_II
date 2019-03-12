package pacote;

import java.awt.Color;
import java.awt.Graphics;
// Classe de adaptadores utilizada para implementar rotinas de tratamento de evento.
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lista.encadeada.Iterador;
import lista.encadeada.ListaEncadeada;

public class PainelDesenhar extends JPanel {
	// lista das referências Point
	//private final ListaEncadeada<Ponto> points;

	// configura GUI e registra rotinas de tratamento de evento de mouse
	public PainelDesenhar(JLabel status) {
		// trata evento de movimento de mouse do frame
		addMouseMotionListener(new MouseMotionAdapter() // classe interna anônima
		{

			@Override
			public void mouseMoved(MouseEvent event) {
				super.mouseMoved(event);
				status.setText("Moved in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " + Principal.getPrincipal().getTamanho());
			}

			// armazena coordenadas da ação de arrastar e repinta
			@Override
			public void mouseDragged(MouseEvent event) {
				Principal.getPrincipal().inserirFim(new Ponto(event.getPoint().x, event.getPoint().y));
				repaint(); // repinta JFrame
				status.setText("Dragged in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  Principal.getPrincipal().getTamanho());
			}
		});
			
			addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					paintImmediately(100, 100, 100, 100);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
		super.setBackground(Color.white);
	}

	// desenha ovais em um quadro delimitador de 4 x 4 nas localizações
	// especificadas na janela
	@Override
	public void paintComponent(Graphics g) {

		Iterador<Ponto> it = Principal.getPrincipal().getIterador();
		Ponto ponto;

		super.paintComponent(g); // limpa a área de desenho

		// desenha todos os pontos
		while((ponto = it.proximo()) != null) {
			g.fillOval(ponto.x, ponto.y, 7, 7);
		}
	}

}// fim da classe PaintPanel
