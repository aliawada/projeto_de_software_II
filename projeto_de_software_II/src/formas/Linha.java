package formas;

import java.awt.Graphics;

import pacote.FormaGeometrica;

public class Linha implements FormaGeometrica {
	Ponto ponto1;
	Ponto ponto2;
	
	public Linha() {
		this.ponto1 = new Ponto();
		this.ponto2 = new Ponto();
	}
	
	public Linha(Ponto ponto1, Ponto ponto2) {
		this.ponto1 = (Ponto) ponto1;
		this.ponto2 = (Ponto) ponto2;
	}

	public Ponto getPonto1() {
		return ponto1;
	}

	public void setPonto1(Ponto ponto1) {
		this.ponto1 = ponto1;
	}

	public Ponto getPonto2() {
		return ponto2;
	}

	public void setPonto2(Ponto ponto2) {
		this.ponto2 = ponto2;
	}
	
	public void desenhar(Graphics g){
		g.drawLine(ponto1.x, ponto1.y, ponto2.x, ponto2.y);
	}
	
	public String toString(){
		return String.format("%d %d %d %d", ponto1.x, ponto1.y, ponto2.x, ponto2.y);
	}
	
	
}
