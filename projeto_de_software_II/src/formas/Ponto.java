package formas;

import java.awt.Graphics;

import pacote.FormaGeometrica;

public class Ponto implements FormaGeometrica {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int x;
	public int y;
	
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Ponto(){
		this.x = 0;
		this.y = 0;
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
	
	public void desenhar(Graphics g){
		g.fillOval(x, y, 7, 7);
	}
	
	public String toString(){
		return String.format("%d %d", x, y);
	}
	
	//Para salavar em binário
	
	
}
