package manipuladores;

import java.awt.Graphics;

import formas.Ponto;
import formas.Triangulo;

public class ManipuladorTriangulo implements ManipuladorForma {
	
	private Triangulo triangulo;
	
	public ManipuladorTriangulo(Triangulo t) {
		this.triangulo = t;
	}
	
	@Override
	public void click(int x, int y) {
	}

	@Override
	public void press(int x, int y) {
		
	}

	@Override
	public void release(int x, int y) {
		
	}

	@Override
	public void drag(int x, int y) {
	
		
	}

	@Override
	public void paint(Graphics g) {
		g.drawLine(triangulo.getA().getX(), triangulo.getA().getY(), triangulo.getB().getX(), triangulo.getB().getY());
		g.drawLine(triangulo.getB().getX(), triangulo.getB().getY(), triangulo.getC().getX(), triangulo.getC().getY());
		g.drawLine(triangulo.getC().getX(), triangulo.getC().getY(), triangulo.getA().getX(), triangulo.getA().getY());
		
	}

}
