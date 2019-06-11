package manipuladores;

import java.awt.Graphics;

import formas.Linha;
import formas.Ponto;

public class ManipuladorLinha implements ManipuladorForma{
	private Linha linha;
	
	public ManipuladorLinha(Linha linha) {
		this.linha = linha;
	}

	@Override
	public void click(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void press(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void release(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drag(int x, int y) {
		linha.setPonto2(new Ponto(x, y));
		
	}

	@Override
	public void paint(Graphics g) {
		g.drawLine(linha.getPonto1().getX(), linha.getPonto1().getY(), linha.getPonto2().getX(), linha.getPonto2().getY());
		
	}
}
