package formas;

import java.awt.Graphics;

import pacote.FormaGeometrica;

public class Circulo implements FormaGeometrica{
	int x,y;
	int r;
	
	public Circulo() {
		this.x = 0;
		this.y = 0;
		this.r = 0;
	}
	
	public Circulo(int x, int y, int r) {
		this.x = x - (r/2);
		this.y = y - (r/2);
		this.r = r;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	@Override
	public void desenhar(Graphics g) {
		g.drawOval(x, y, r, r);
	}
	
	public String toString() {
		return String.format("%d %d %d", x,y,r);
	}
	
	
}
