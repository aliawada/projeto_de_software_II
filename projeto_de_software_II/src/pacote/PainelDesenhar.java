package pacote;

import java.awt.Color;
import java.awt.Graphics;
// Classe de adaptadores utilizada para implementar rotinas de tratamento de evento.
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import formas.Circulo;
import formas.Linha;
import formas.Ponto;
import formas.Retangulo;
import formas.Triangulo;
import lista.encadeada.Iterador;

@SuppressWarnings("serial")
public class PainelDesenhar extends JPanel {
	
	private Documento doc;
	
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
	public boolean controleRetangulo = false;
	public boolean controleCirculo = false;
	public boolean mouseDragged = false;
	int mouseClickedCountTriang = 0;
	int mouseClickedCountRetang = 0;
	private int width;
	public Color color = Color.white;
	
	// configura GUI e registra rotinas de tratamento de evento de mouse
	public PainelDesenhar(JLabel status, Documento doc) {
		this.doc = doc;
		// trata evento de movimento de mouse do frame
		addMouseMotionListener(new MouseMotionAdapter() // classe interna anônima
		{

			@Override
			public void mouseMoved(MouseEvent event) {
				super.mouseMoved(event);
				status.setText("Moved in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " + doc.getTamanho());
			}

			// armazena coordenadas da ação de arrastar e repinta
			@Override
			public void mouseDragged(MouseEvent event) {
				if(controlePonto == true) {
				doc.inserirFim(new Ponto(event.getPoint().x, event.getPoint().y));
				status.setText("Dragged in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  doc.getTamanho());
				repaint(); // repinta JFrame
				}
			}
		});
			
			addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent event) {
					repaint();
					if(controleLinha == true) {
					ponto2 = new Ponto(event.getPoint().x, event.getPoint().y);	
					doc.inserirFim(new Linha(ponto1, ponto2));
					status.setText("Realeased in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  doc.getTamanho());
					repaint();
					}
					
				    
				    if(controleCirculo == true) {
						//Calcula o radiano
						ponto2 = new Ponto(event.getPoint().x, event.getPoint().y);
						double xTop = Math.min(ponto2.x, ponto1.x);
                        double yTop = Math.min(ponto2.y, ponto1.y);
                        double xBottom = Math.max(ponto2.x, ponto1.x);
                        double yBottom = Math.max(ponto2.y, ponto1.y);

                        double radius = Math.max(xBottom - xTop, yBottom - yTop);
                        xTop = ponto1.x - radius;
                        yTop = ponto1.y - radius;

                        radius *= 2;
                        
                        int r = (int) Math.round(radius);
                        
						doc.inserirFim(new Circulo(ponto1.x, ponto1.y, r));
						status.setText("Realeased in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  doc.getTamanho());
					}
						
				}

				@Override
				public void mousePressed(MouseEvent event) {
					repaint();
					if(controleLinha == true) {
					ponto1 = new Ponto(event.getPoint().x, event.getPoint().y);
					status.setText("Pressed in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  doc.getTamanho());			
					}
					
					
					if(controleCirculo == true) {
						ponto1 = new Ponto(event.getPoint().x, event.getPoint().y);
						status.setText("Pressed in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  doc.getTamanho());			
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
					
					mouseClickedCountTriang++;
					mouseClickedCountRetang++;
					
					if(controleTriangulo == true && mouseClickedCountTriang == 1) {
						ponto1 = new Ponto(event.getPoint().x, event.getPoint().y);
						status.setText("Clicked One Time in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  doc.getTamanho());
					} 
					
					if(controleTriangulo == true && mouseClickedCountTriang == 2) {
						ponto2 = new Ponto(event.getPoint().x, event.getPoint().y);	
						status.setText("Clicked Two Times in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  doc.getTamanho());
					} 
					
					if(controleTriangulo == true && mouseClickedCountTriang == 3) {
						ponto3 = new Ponto(event.getPoint().x, event.getPoint().y);
						linha1 = new Linha(ponto1, ponto2);
						linha2 = new Linha(ponto1, ponto3);
						linha3 = new Linha(ponto2, ponto3);
						doc.inserirFim(new Triangulo(linha1, linha2, linha3));
						status.setText("Clicked Three Times in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  doc.getTamanho());
						repaint();
						mouseClickedCountTriang = 0;
					}
					
					
					if(controleRetangulo == true && mouseClickedCountRetang == 1) {
						ponto1 = new Ponto(event.getPoint().x, event.getPoint().y);
						status.setText("Clicked One Time in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  doc.getTamanho());			
					}
					
					
					if(controleRetangulo == true && mouseClickedCountRetang == 2) {
				    	
				    	ponto2 = new Ponto(event.getPoint().x, event.getPoint().y);
				    	
				    	
						int aux = ponto2.x - ponto1.x;
						int aux2 = ponto2.y - ponto1.y;
						double w = Math.sqrt(Math.pow(aux, 2) + Math.pow(aux2, 2));
						
						width = (int) Math.round(w);
						
						mouseDragged = true;
						status.setText("Clicked Two Times in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  doc.getTamanho());
						repaint();
					}
					
					
					
					if(controleRetangulo == true && mouseClickedCountRetang == 3) {
						ponto3 = new Ponto(event.getPoint().x, event.getPoint().y);
						
						int aux = ponto3.x - ponto2.x;
						int aux2 = ponto3.y - ponto2.y;
						double h = Math.sqrt(Math.pow(aux, 2) + Math.pow(aux2, 2));
						
						int height = (int) Math.round(h);
						
						doc.inserirFim(new Retangulo(ponto1, width, height));
						status.setText("Clicked Three Times in [" + event.getPoint().getX() + "," + event.getPoint().getY() + "]" + " - Tamanho Total = " +  doc.getTamanho());
						repaint();
						mouseClickedCountRetang = 0;
					}

				}
			});
		super.setBackground(Color.pink);
	}


	@Override
	public void paintComponent(Graphics g) {

		Iterador<FormaGeometrica> it = doc.getIterador();
		FormaGeometrica forma;

		super.paintComponent(g); // limpa a área de desenho
	
		while((forma = it.proximo()) != null) {
			g.setColor(color);
			forma.desenhar(g);
		}
	}

}// fim da classe PaintPanel
