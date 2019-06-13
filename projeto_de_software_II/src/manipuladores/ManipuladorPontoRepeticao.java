package manipuladores;

import java.awt.Graphics;

import formas.Ponto;
import formas.PontoRepeticao;

public class ManipuladorPontoRepeticao implements ManipuladorForma {
    private PontoRepeticao pr;

    public ManipuladorPontoRepeticao(PontoRepeticao pr) {
        this.pr = pr;
    }

    @Override
    public void paint(Graphics g) {
    	pr.getListaPontos().forEach(ponto ->
                g.fillOval(ponto.getX(), ponto.getY(), 4, 4));

    }

    @Override
    public void click(int x, int y) {

    }

    @Override
    public void press(int x, int y) {

    }

    @Override
    public void release(int x, int y) {

    }

    @Override
    public void drag(int x, int y) {
    	pr.getListaPontos().add( new Ponto(x, y) );
    }


}
