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
		
	
	}

	@Override
	public void paint(Graphics g) {
		

		int px = Math.min( retangulo.getA().getX(), retangulo.getB().getX() );
        int py = Math.min( retangulo.getA().getY(), retangulo.getB().getY() );
        int pw = Math.abs( retangulo.getA().getX() - retangulo.getB().getX() );
        int ph = Math.abs( retangulo.getA().getY() - retangulo.getB().getY() );
        
		
		g.drawRect(px, py, pw, ph);
	}

}
