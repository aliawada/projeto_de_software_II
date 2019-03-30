package formas;

import java.awt.Color;
import java.awt.Graphics;

import pacote.FormaGeometrica;

public class Triangulo implements FormaGeometrica {
	Linha linha1;
	Linha linha2;
	Linha linha3;
	
	public Triangulo() {
		this.linha1 = new Linha();
		this.linha2 = new Linha();
		this.linha3 = new Linha();
	}
	
	public Triangulo(Linha linha1, Linha linha2, Linha linha3) {
		this.linha1 = (Linha) linha1;
		this.linha2 = (Linha) linha2;
		this.linha3 = (Linha) linha3;
	}

	public Linha getLinha1() {
		return linha1;
	}

	public void setLinha1(Linha linha1) {
		this.linha1 = linha1;
	}

	public Linha getLinha2() {
		return linha2;
	}

	public void setLinha2(Linha linha2) {
		this.linha2 = linha2;
	}

	public Linha getLinha3() {
		return linha3;
	}

	public void setLinha3(Linha linha3) {
		this.linha3 = linha3;
	}

	@Override
	public void desenhar(Graphics g) {
		g.drawLine(linha1.ponto1.x, linha1.ponto1.y, linha1.ponto2.x, linha1.ponto2.y);
		g.drawLine(linha2.ponto1.x, linha2.ponto1.y, linha2.ponto2.x, linha2.ponto2.y);
		g.drawLine(linha3.ponto1.x, linha3.ponto1.y, linha3.ponto2.x, linha3.ponto2.y);
	}
	
	public String toString() {
		return String.format("%d %d %d %d %d %d %d %d %d %d %d %d", linha1.ponto1.x, linha1.ponto1.y, linha1.ponto2.x, linha1.ponto2.y,
																	linha2.ponto1.x, linha2.ponto1.y, linha2.ponto2.x, linha2.ponto2.y,
																	linha3.ponto1.x, linha3.ponto1.y, linha3.ponto2.x, linha3.ponto2.y);
	}
	
}
