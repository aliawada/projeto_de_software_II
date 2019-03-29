package pacote;

import java.awt.Color;
import java.awt.Graphics;
// Classe de adaptadores utilizada para implementar rotinas de tratamento de evento.
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

import formas.Linha;
import formas.Ponto;
import formas.Triangulo;
import lista.encadeada.Iterador;

public class PainelDesenhar extends JPanel {
	Ponto ponto1;
	Ponto ponto2;
	Ponto ponto3;
	Linha linha1;
	Linha linha2;
	Linha linha3;
	//variaveis de controle 
	public boolean controlePonto = false;
	public boolean controleLinha = false;
	public boolean controleTriangulo = false;
	int mouseClickedCount = 0;
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
				if(controlePonto == true) {
				Principal.getPrincipal().inserirFim(new Ponto(event.getPoint().x, event.getPoint().y));
				status.setText("Dragged in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  Principal.getPrincipal().getTamanho());
				repaint(); // repinta JFrame
				}
			}
		});
			
			addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent event) {
					if(controleLinha == true) {
					ponto2 = new Ponto(event.getPoint().x, event.getPoint().y);	
					Principal.getPrincipal().inserirFim(new Linha(ponto1, ponto2));
					status.setText("Realeased in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  Principal.getPrincipal().getTamanho());
					repaint();
					}
						
				}

				@Override
				public void mousePressed(MouseEvent event) {
					if(controleLinha == true) {
					ponto1 = new Ponto(event.getPoint().x, event.getPoint().y);
					status.setText("Pressed in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  Principal.getPrincipal().getTamanho());
					}
					
					
					
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
				public void mouseClicked(MouseEvent event) {
					
					mouseClickedCount++;
					
					if(controleTriangulo == true && mouseClickedCount == 1) {
						ponto1 = new Ponto(event.getPoint().x, event.getPoint().y);
						status.setText("Clicked One Time in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  Principal.getPrincipal().getTamanho());
					} 
					
					if(controleTriangulo == true && mouseClickedCount == 2) {
						ponto2 = new Ponto(event.getPoint().x, event.getPoint().y);	
						status.setText("Clicked Two Times in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  Principal.getPrincipal().getTamanho());
					} 
					
					if(controleTriangulo == true && mouseClickedCount == 3) {
						ponto3 = new Ponto(event.getPoint().x, event.getPoint().y);
						linha1 = new Linha(ponto1, ponto2);
						linha2 = new Linha(ponto1, ponto3);
						linha3 = new Linha(ponto2, ponto3);
						Principal.getPrincipal().inserirFim(new Triangulo(linha1, linha2, linha3));
						status.setText("Clicked Three Times in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  Principal.getPrincipal().getTamanho());
						repaint();
						mouseClickedCount = 0;
					}

				}
			});
		super.setBackground(Color.pink);
	}


	@Override
	public void paintComponent(Graphics g) {

		Iterador<FormaGeometrica> it = Principal.getPrincipal().getIterador();
		FormaGeometrica forma;

		super.paintComponent(g); // limpa a área de desenho
		
		while((forma = it.proximo()) != null) {
			forma.desenhar(g);
		}
	}

}// fim da classe PaintPanel
