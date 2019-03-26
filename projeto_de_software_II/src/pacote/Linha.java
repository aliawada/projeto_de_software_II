package pacote;

public class Linha extends FiguraGeometrica {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Ponto ponto1;
	Ponto ponto2;
	
	public Linha() {
		this.ponto1 = null;
		this.ponto2 = null;
	}
	
	public Linha(Ponto ponto1, Ponto ponto2) {
		this.ponto1 = ponto1;
		this.ponto2 = ponto2;
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
	
	
}
