package formas;

import java.io.Serializable;
import java.nio.ByteBuffer;

import manipuladores.ManipuladorCirculo;
import manipuladores.ManipuladorForma;
import pacote.FormaGeometrica;

@SuppressWarnings("serial")
public class Circulo implements FormaGeometrica,Serializable {

	public static final String NOME = "Circulo";
	public static final byte ID = 5;
	private Ponto a;
	private Ponto b;
	
	public Circulo() {
		this.a = new Ponto();
		this.b = new Ponto();
	}
	
	public Circulo(Circulo c) {
		this.a = c.getA();
		this.b = c.getB();
	}
	
	public Circulo(Ponto p) {
		this.a = new Ponto(p);
		this.b = new Ponto(p);
	}
	
	public Circulo(Ponto a, Ponto b) {
		this.a = a;
		this.b = b;
	}

	public Circulo(byte arrayForma[]) {
		ByteBuffer bb = ByteBuffer.allocate(8);
		bb.put(arrayForma[1]);//x
		bb.put(arrayForma[2]);//x
		bb.put(arrayForma[3]);//y
		bb.put(arrayForma[4]);//y

		bb.put(arrayForma[5]);//x
		bb.put(arrayForma[6]);//x
		bb.put(arrayForma[7]);//y
		bb.put(arrayForma[8]);//y

		int x1 = bb.getShort(0);
		int y1 = bb.getShort(2);

		int x2 = bb.getShort(4);
		int y2 = bb.getShort(6);

		this.a = new Ponto(x1,y1);
		this.b = new Ponto(x2,y2);
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
	
	@Override
	public String toString() {
		return NOME;
	}

	@Override
    public String toTextLineBD() {
		return a.getX()+","+a.getY()+" | "+b.getX()+","+b.getY();
    }

	@Override
	public ManipuladorForma getManipulador() {
		return new ManipuladorCirculo(this);
	}

	@Override
	public String toTextLine() {
		return NOME+" "+a.getX()+" "+a.getY()+" "+b.getX()+" "+b.getY();
	}
	
	@Override
	public String getStrPosition() {
		return NOME+" ("+a.getX()+", "+a.getY()+"),("+b.getX()+", "+b.getY()+");";
	}
	
	public String toStringArq() {
		return String.format("%d %d %d %d", a.x,a.y,b.x, b.y);
	}
	
}
