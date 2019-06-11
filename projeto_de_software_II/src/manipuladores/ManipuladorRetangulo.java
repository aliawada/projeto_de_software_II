package manipuladores;

import java.awt.Graphics;
import java.awt.Polygon;

import formas.Ponto;
import formas.Retangulo;

public class ManipuladorRetangulo implements ManipuladorForma {
	private Retangulo retangulo;

	public ManipuladorRetangulo(Retangulo r) {
		this.retangulo = r;
	}

	@Override
	public void click(int x, int y) {

	}

	@Override
	public void press(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void release(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drag(int x, int y) {
		retangulo.setB(new Ponto(x, y));

		int px = Math.min(retangulo.getA().getX(), retangulo.getB().getX());
		int py = Math.min(retangulo.getA().getY(), retangulo.getB().getY());
		int pw = Math.abs(retangulo.getA().getX() - retangulo.getB().getX());
		int ph = Math.abs(retangulo.getA().getY() - retangulo.getB().getY());

		retangulo.setA(new Ponto(px, py));
		retangulo.setB(new Ponto(px + pw, py));
		retangulo.setC(new Ponto(px + pw, py + ph));
		retangulo.setD(new Ponto(px, py + ph));

	}

	@Override
	public void paint(Graphics g) {
		Polygon p = new Polygon();

		p.addPoint(retangulo.getA().getX(), retangulo.getA().getY());
		p.addPoint(retangulo.getB().getX(), retangulo.getB().getY());
		p.addPoint(retangulo.getC().getX(), retangulo.getC().getY());
		p.addPoint(retangulo.getD().getX(), retangulo.getD().getY());

		g.drawPolygon(p);

	}

}
