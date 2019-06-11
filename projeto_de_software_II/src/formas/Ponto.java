package formas;

import java.io.Serializable;
import java.nio.ByteBuffer;

import manipuladores.ManipuladorForma;
import manipuladores.ManipuladorPonto;
import pacote.FormaGeometrica;

@SuppressWarnings("serial")
public class Ponto implements FormaGeometrica, Serializable {
	public static final String NOME = "Ponto";
	public static final byte ID = 1;
	public int x;
	public int y;

	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Ponto(Ponto p) {
        x = p.getX();
        y = p.getY();
    }

	public Ponto() {
		this.x = 0;
		this.y = 0;
	}

	public Ponto(byte[] arrayForma) {

		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.put(arrayForma[1]);// x
		bb.put(arrayForma[2]);// x
		bb.put(arrayForma[3]);// y
		bb.put(arrayForma[4]);// y

		this.x = bb.getShort(0);
		this.y = bb.getShort(2);
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
	
	@Override
	public String toTextLine() {
		return NOME + " " + x + " " + y;
	}
	
	@Override
	public String toTextLineBD() {
		return NOME + " " + x + " " + y;
	}

	@Override
	public String toString() {
		return NOME;
	}
	
	public String toStringArq() {
		return String.format("%d %d", x, y);
	}

	@Override
	public ManipuladorForma getManipulador() {
		return new ManipuladorPonto(this);
	}
	
	@Override
    public String getStrPosition() {
        return "Ponto ("+x+", "+y+");";
    }
	
	// Para salavar em binário

}
