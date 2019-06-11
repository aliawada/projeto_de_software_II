package manipuladores;

import java.awt.Graphics;

import formas.Lapis;
import formas.Ponto;

public class ManipuladorLapis implements ManipuladorForma {
    private Lapis lapis;

    public ManipuladorLapis(Lapis l) {
        this.lapis = l;
    }

    @Override
    public void paint(Graphics g) {
        lapis.getListaPontos().forEach(ponto ->
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
        lapis.getListaPontos().add( new Ponto(x, y) );
    }


}
