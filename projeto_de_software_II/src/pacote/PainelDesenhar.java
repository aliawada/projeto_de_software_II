package pacote;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import formas.Circulo;
import formas.Linha;
import formas.Ponto;
import formas.PontoRepeticao;
import formas.Quadrado;
import formas.Retangulo;
import lista.encadeada.Iterador;
import manipuladores.ManipuladorForma;

@SuppressWarnings("serial")
public class PainelDesenhar extends JPanel implements MouseListener, MouseMotionListener, OuvintePaineis {
	private JLabel status;

	Documento doc;

	private FormaGeometrica novaForma;
	ManipuladorForma manipulador;
	
	public PainelDesenhar(JLabel status, Documento doc) {
		this.status = status;
		this.doc = doc;

		this.novaForma = null;

		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	

	// desenha oval em um quadro delimitador de 4x4 no local especificada na janela
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // limpa a área de desenho

		Iterador<FormaGeometrica> it = doc.getIterador();
		FormaGeometrica forma;
		while ((forma = it.proximo()) != null) {
			forma.getManipulador().paint(g);
		}
	}

	// Handlers de evento de MouseListener
	// trata evento quando o mouse é liberado logo depois de pressionado
	public void mouseClicked(MouseEvent event) {
		if (novaForma != null) {
			if (novaForma.getClass().equals(Ponto.class)) {
				Ponto p = (Ponto) novaForma;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);
				doc.inserirFim(novaForma);

				novaForma = null;
			} else if (novaForma.getClass().equals(Linha.class)) {
				Linha l = (Linha) novaForma;
				l.setPonto1(new Ponto(event.getPoint().x, event.getPoint().y));
				l.setPonto2(new Ponto(event.getPoint().x, event.getPoint().y));
				doc.inserirFim(novaForma);

				novaForma = null;
			} else if (novaForma.getClass().equals(Circulo.class)) {
				Circulo c = (Circulo) novaForma;
				c.setA(new Ponto(event.getPoint().x, event.getPoint().y));
				c.setB(new Ponto(event.getPoint().x, event.getPoint().y));
				doc.inserirFim(novaForma);

				novaForma = null;
			} else if (novaForma.getClass().equals(Retangulo.class)) {
				Retangulo c = (Retangulo) novaForma;
				c.setA(new Ponto(event.getPoint().x, event.getPoint().y));
				c.setB(new Ponto(event.getPoint().x, event.getPoint().y));
				doc.inserirFim(novaForma);

				novaForma = null;
			} else if (novaForma.getClass().equals(Quadrado.class)) {
				Quadrado q = (Quadrado) novaForma;
				q.setA(new Ponto(event.getPoint().x, event.getPoint().y));
				q.setB(new Ponto(event.getPoint().x, event.getPoint().y));
				doc.inserirFim(novaForma);

				novaForma = null;
			} else if (novaForma.getClass().equals(PontoRepeticao.class)) {
				PontoRepeticao pr = (PontoRepeticao) novaForma;
				pr.getListaPontos().add(new Ponto(event.getPoint().x, event.getPoint().y));
				
				doc.inserirFim(novaForma);

				novaForma = null;
			}
		}
		status.setText(
				String.format("Clicked at [%d, %d] - Total formas %d", event.getX(), event.getY(), doc.getTamanho()));
	}

	// trata evento quando mouse é pressionado
	public void mousePressed(MouseEvent event) {
		if (novaForma != null) {
			if (novaForma.getClass().equals(Ponto.class)) {
				Ponto p = (Ponto) novaForma;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);

				atualizar();
			} else if (novaForma.getClass().equals(Linha.class)) {
				Linha l = (Linha) novaForma;
				l.setPonto1(new Ponto(event.getPoint().x, event.getPoint().y));
				l.setPonto2(new Ponto(event.getPoint().x, event.getPoint().y));

				atualizar();
			} else if (novaForma.getClass().equals(Circulo.class)) {
				Circulo c = (Circulo) novaForma;
				c.setA(new Ponto(event.getPoint().x, event.getPoint().y));
				c.setB(new Ponto(event.getPoint().x, event.getPoint().y));

				atualizar();
			} else if (novaForma.getClass().equals(Retangulo.class)) {
				Retangulo r = (Retangulo) novaForma;
				r.setA(new Ponto(event.getPoint().x, event.getPoint().y));
				r.setB(new Ponto(event.getPoint().x, event.getPoint().y));
				
				atualizar();
			} else if (novaForma.getClass().equals(Quadrado.class)) {
				Quadrado q = (Quadrado) novaForma;

				q.setA(new Ponto(event.getPoint().x, event.getPoint().y));
				q.setB(new Ponto(event.getPoint().x, event.getPoint().y));
				
				atualizar();
			} else if (novaForma.getClass().equals(PontoRepeticao.class)) {
				PontoRepeticao pr = (PontoRepeticao) novaForma;
				pr.getListaPontos().add(new Ponto(event.getPoint().x, event.getPoint().y));
				
				atualizar();
			} 
		}
		status.setText(
				String.format("Pressed at [%d, %d] -  %d", event.getX(), event.getY(), doc.getTamanho()));
	}

	// trata evento quando mouse é liberado depois da operação de arrastar
	public void mouseReleased(MouseEvent event) {
		if (novaForma != null) {
			if (novaForma.getClass().equals(Ponto.class)) {
				Ponto p = (Ponto) novaForma;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);
				doc.inserirFim(novaForma);

				novaForma = null;
			} else if (novaForma.getClass().equals(Linha.class)) {
				Linha l = (Linha) novaForma;
				l.setPonto2(new Ponto(event.getPoint().x, event.getPoint().y));
				doc.inserirFim(novaForma);

				novaForma = null;
			} else if (novaForma.getClass().equals(Circulo.class)) {
				Circulo c = (Circulo) novaForma;
				c.setB(new Ponto(event.getPoint().x, event.getPoint().y));
				doc.inserirFim(novaForma);

				novaForma = null;
			} else if (novaForma.getClass().equals(Retangulo.class)) {
				Retangulo r = (Retangulo) novaForma;
				r.setB(new Ponto(event.getPoint().x, event.getPoint().y));
				doc.inserirFim(novaForma);

				novaForma = null;
			} else if (novaForma.getClass().equals(Quadrado.class)) {
				Quadrado q = (Quadrado) novaForma;
				q.setB(new Ponto(event.getPoint().x, event.getPoint().y));
				doc.inserirFim(novaForma);

				novaForma = null;
			} else if (novaForma.getClass().equals(PontoRepeticao.class)) {
				PontoRepeticao pr = (PontoRepeticao) novaForma;
				pr.getListaPontos().add(new Ponto(event.getPoint().x, event.getPoint().y));
				doc.inserirFim(novaForma);
				
				novaForma = null;
			}
		}
		status.setText(
				String.format("Released at [%d, %d] -  %d", event.getX(), event.getY(), doc.getTamanho()));
	}

	// trata evento quando mouse entra na área
	public void mouseEntered(MouseEvent event) {
		status.setText(String.format("Mouse entered at [%d, %d] -  %d", event.getX(), event.getY(),
				doc.getTamanho()));
		// setBackground( Color.GREEN );
	}

	// trata evento quando mouse sai da área
	public void mouseExited(MouseEvent event) {
		status.setText(String.format("Mouse outside JPanel -  %d", doc.getTamanho()));
		// setBackground( Color.WHITE );
	}

	// Handlers de evento de MouseMotionListener
	// trata evento quando usuário arrasta o mouse com o botão pressionado
	public void mouseDragged(MouseEvent event) {
		if (novaForma != null) {
			if (novaForma.getClass().equals(Ponto.class)) {
				Ponto p = (Ponto) novaForma;
				p.setX(event.getPoint().x);
				p.setY(event.getPoint().y);

				atualizar();
			} else if (novaForma.getClass().equals(Linha.class)) {
				Linha l = (Linha) novaForma;
				l.setPonto2(new Ponto(event.getPoint().x, event.getPoint().y));

				atualizar();
			}else if (novaForma.getClass().equals(Circulo.class)) {
				Circulo c = (Circulo) novaForma;
				c.setB(new Ponto(event.getPoint().x, event.getPoint().y));

				atualizar();
			}else if (novaForma.getClass().equals(Retangulo.class)) {
				Retangulo r = (Retangulo) novaForma;
				r.setB(new Ponto(event.getPoint().x, event.getPoint().y));

				atualizar();
			}else if (novaForma.getClass().equals(Quadrado.class)) {
				Quadrado q = (Quadrado) novaForma;
				q.setB(new Ponto(event.getPoint().x, event.getPoint().y));
				
				atualizar();
			}else if (novaForma.getClass().equals(PontoRepeticao.class)) {
				PontoRepeticao pr = (PontoRepeticao) novaForma;
				pr.getListaPontos().add(new Ponto(event.getPoint().x, event.getPoint().y));
				
				atualizar();
			}
		}
		status.setText(
				String.format("Dragged at [%d, %d] - Total formas %d", event.getX(), event.getY(), doc.getTamanho()));
	}

	// trata evento quando usuário move o mouse
	public void mouseMoved(MouseEvent event) {
		status.setText(
				String.format("Moved at [%d, %d] - Total formas %d", event.getX(), event.getY(), doc.getTamanho()));
	}

	@Override
	public void novaFormaGeometrica(FormaGeometrica forma) {
		this.novaForma = forma;
		this.manipulador = forma.getManipulador();
	}

	@Override
	public void atualizar() {
		repaint();
	}
}
