package formas;

import java.nio.ByteBuffer;

import manipuladores.ManipuladorForma;
import manipuladores.ManipuladorRetangulo;
import pacote.FormaGeometrica;

public class Retangulo implements FormaGeometrica {

	public static final byte ID = 4;
	public static final String NOME = "Retangulo";
	private Ponto a;
	private Ponto b;

	private Ponto c;
	private Ponto d;

	public Retangulo() {
		this.a = new Ponto();
		this.b = new Ponto();
		this.c = new Ponto();
		this.d = new Ponto();
	}

	public Retangulo(Ponto p) {
		this.a = new Ponto(p);
		this.b = new Ponto(p);
		this.c = new Ponto(p);
		this.d = new Ponto(p);
	}
	
	public Retangulo(Ponto a, Ponto b) {
		this.a = new Ponto(a);
		this.b = new Ponto(b);
	}

	public Retangulo(Retangulo r) {
		this.a = r.getA();
		this.b = r.getB();
		this.c = r.getC();
		this.d = r.getD();
	}

	public Retangulo(byte arrayForma[]) {
		ByteBuffer bb = ByteBuffer.allocate(8);
//		bb.order(ByteOrder.LITTLE_ENDIAN);//ordem de bits esq p/ direita
		bb.put(arrayForma[1]);// x
		bb.put(arrayForma[2]);// x
		bb.put(arrayForma[3]);// y
		bb.put(arrayForma[4]);// y

		bb.put(arrayForma[5]);// x
		bb.put(arrayForma[6]);// x
		bb.put(arrayForma[7]);// y
		bb.put(arrayForma[8]);// y

		int x1 = bb.getShort(0);
		int y1 = bb.getShort(2);

		int x2 = bb.getShort(4);
		int y2 = bb.getShort(6);

		this.a = new Ponto(x1, y1);
		this.b = new Ponto(x2, y2);
	}
	
	@Override
	public String toTextLine() {
		return NOME + " " + a.getX() + " " + a.getY() + " " + b.getX() + " " + b.getY();
	}

	@Override
	public String toTextLineBD() {
		return a.getX() + "," + a.getY() + " | " + b.getX() + "," + b.getY();
	}
	
	@Override
	public String getStrPosition() {
		return NOME+" ("+a.getX()+", "+a.getY()+"),("+b.getX()+", "+b.getY()+");";
	}
	
	@Override
	public String toString() {
		return NOME;
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

	public Ponto getD() {
		return d;
	}

	public void setD(Ponto d) {
		this.d = d;
	}

	@Override
	public ManipuladorForma getManipulador() {
		return new ManipuladorRetangulo(this);
	}
	
	public String toStringArq() {
		return String.format("%d %d %d %d", a.x, a.y, b.x, b.y);
	}
}
