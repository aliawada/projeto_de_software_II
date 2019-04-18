package formas;

import java.awt.Graphics;
import java.io.Serializable;

import pacote.FormaGeometrica;

@SuppressWarnings("serial")
public class Retangulo implements FormaGeometrica,Serializable {
	Ponto ponto;
	int w;
	int h;
	
	public Retangulo() {
		this.ponto = new Ponto();
		this.w = 0;
		this.h = 0;
	}
	
	public Retangulo(Ponto ponto, int w, int h) {
		this.ponto = (Ponto) ponto;
		this.w = w;
		this.h = h;
	}
	
	public Ponto getPonto() {
		return ponto;
	}

	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	@Override
	public void desenhar(Graphics g) {
		g.drawRect(ponto.x, ponto.y, w, h);
	}
	
	public String toString() {
		return String.format("%d %d %d %d", ponto.x, ponto.y, w, h);
	}
	
}
