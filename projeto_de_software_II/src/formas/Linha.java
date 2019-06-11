package formas;

import java.io.Serializable;
import java.nio.ByteBuffer;

import manipuladores.ManipuladorForma;
import manipuladores.ManipuladorLinha;
import pacote.FormaGeometrica;

@SuppressWarnings("serial")
public class Linha implements FormaGeometrica,Serializable {

	public static final byte ID = 2;
	public static final String NOME = "Linha";
	Ponto ponto1;
	Ponto ponto2;
	
	public Linha() {
		this.ponto1 = new Ponto();
		this.ponto2 = new Ponto();
	}
	
	public Linha(Ponto p) {
		this.ponto1 = new Ponto(p);
		this.ponto2 = new Ponto(p);
	}
	
	public Linha(Ponto ponto1, Ponto ponto2) {
		this.ponto1 = (Ponto) ponto1;
		this.ponto2 = (Ponto) ponto2;
	}
	
	public Linha(byte[] arrayForma){
		ByteBuffer bb = ByteBuffer.allocate(8);
//		bb.order(ByteOrder.LITTLE_ENDIAN);//ordem de bits esq p/ direita
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

		this.ponto1 = new Ponto(x1,y1);
		this.ponto2 = new Ponto(x2,y2);
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
	
	@Override
	public String toString() {
		return NOME;
	}

	
	@Override
	public String toTextLine() {
		return NOME+" "+ponto1.getX()+" "+ponto1.getY()+" "+ponto2.getX()+" "+ponto2.getY();
	}
	
	@Override
    public String toTextLineBD() {
		return ponto1.getX()+","+ponto1.getY()+" | "+ponto2.getX()+","+ponto2.getY();

	}
	
	public String toStringArq(){
		return String.format("%d %d %d %d", ponto1.x, ponto1.y, ponto2.x, ponto2.y);
	}

	@Override
	public ManipuladorForma getManipulador() {
		return new ManipuladorLinha(this);
	}
	
	@Override
	public String getStrPosition() {
		return NOME+" ("+ponto1.getX()+", "+ponto1.getY()+"),("+ponto2.getX()+", "+ponto2.getY()+");";
	}
	
}
