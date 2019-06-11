package formas;

import java.io.Serializable;
import java.nio.ByteBuffer;

import manipuladores.ManipuladorForma;
import manipuladores.ManipuladorTriangulo;
import pacote.FormaGeometrica;

@SuppressWarnings("serial")
public class Triangulo implements FormaGeometrica,Serializable {

	public static final String NOME = "Triangulo";
	public static final byte ID = 3;
	Ponto a;
	Ponto b;
	Ponto c;
	
	public Triangulo() {
		this.a = new Ponto();
		this.b = new Ponto();
		this.c = new Ponto();
	}
	
	public Triangulo(Ponto p) {
		this.a = new Ponto(p);
		this.b = new Ponto(p);
		this.c = new Ponto(p);
	}
	
	public Triangulo(Ponto a,Ponto b, Ponto c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Triangulo(byte arrayForma[]) {
		ByteBuffer bb = ByteBuffer.allocate(12);
//		bb.order(ByteOrder.LITTLE_ENDIAN);//ordem de bits esq p/ direita
		bb.put(arrayForma[1]);//x
		bb.put(arrayForma[2]);//x
		bb.put(arrayForma[3]);//y
		bb.put(arrayForma[4]);//y

		bb.put(arrayForma[5]);//x
		bb.put(arrayForma[6]);//x
		bb.put(arrayForma[7]);//y
		bb.put(arrayForma[8]);//y
		
		bb.put(arrayForma[9]);//x
		bb.put(arrayForma[10]);//x
		bb.put(arrayForma[11]);//y
		bb.put(arrayForma[12]);//y

		int x1 = bb.getShort(0);
		int y1 = bb.getShort(2);

		int x2 = bb.getShort(4);
		int y2 = bb.getShort(6);
		
		int x3 = bb.getShort(8);
		int y3 = bb.getShort(10);

		this.a = new Ponto(x1,y1);
		this.b = new Ponto(x2,y2);
		this.c = new Ponto(x3,y3);
	}
	
	@Override
	public String getStrPosition() {
		return NOME+" ("+a.getX()+", "+a.getY()+"),("+b.getX()+", "+b.getY()+"),("+c.getX()+", "+ c.getY() +");";
	}
	
	public Ponto getA() {
		return a;
	}


	public void setA(Ponto a) {
		this.a = a;
	}


	public Ponto getB() {
		return b;
	}


	public void setB(Ponto b) {
		this.b = b;
	}


	public Ponto getC() {
		return c;
	}


	public void setC(Ponto c) {
		this.c = c;
	}


	public String toString() {
		return NOME;
	}

	@Override
	public ManipuladorForma getManipulador() {
		return new ManipuladorTriangulo(this);
	}
	
	@Override
	public String toTextLine() {
		return NOME + " " + a.getX()+" "+a.getY()+" "+b.getX()+" "+b.getY()+" "+c.getX()+" "+c.getY();
	}

	@Override
	public String toTextLineBD() {
		return a.getX()+","+a.getY()+" | "+b.getX()+","+b.getY()+" | "+c.getX()+","+c.getY();
	}
	
	public String toStringArq() {
		return String.format("%d %d %d %d %d %d", a.x, a.y, b.x, b.y, c.x, c.y);
	}
	
	
}
