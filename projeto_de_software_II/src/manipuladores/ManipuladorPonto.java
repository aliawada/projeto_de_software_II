package manipuladores;

import java.awt.Graphics;

import formas.Ponto;

public class ManipuladorPonto implements ManipuladorForma {

	private Ponto ponto;

	public ManipuladorPonto(Ponto p) {
		this.ponto = p;
	}

	@Override
	public void click(int x, int y) {
		ponto.setX(x);
		ponto.setY(y);
	}

	@Override
	public void press(int x, int y) {
		ponto.setX(x);
		ponto.setY(y);
	}

	@Override
	public void release(int x, int y) {
		ponto.setX(x);
		ponto.setY(y);
	}

	@Override
	public void drag(int x, int y) {
		ponto.setX(x);
		ponto.setY(y);
	}

	@Override
	public void paint(Graphics g) {
		g.fillOval(ponto.getX(), ponto.getY(), 7, 7);
	}

}
