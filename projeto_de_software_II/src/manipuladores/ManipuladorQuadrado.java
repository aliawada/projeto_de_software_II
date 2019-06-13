package manipuladores;

import java.awt.Graphics;

import formas.Ponto;
import formas.Quadrado;

public class ManipuladorQuadrado implements ManipuladorForma {
    private Quadrado quadrado;

    public ManipuladorQuadrado(Quadrado l) {
        this.quadrado = l;
    }

    @Override
    public void paint(Graphics g) {
    	double ax, ay, bx, by;
        ax = quadrado.getA().getX();
        ay = quadrado.getA().getY();
        bx = quadrado.getB().getX();
        by = quadrado.getB().getY();
     
        int r = (int) Math.sqrt( Math.pow(bx - ax, 2) + Math.pow(by - ay, 2) );

        int x = quadrado.getA().getX() - (r/2);
        int y = quadrado.getA().getY() - (r/2);
        
        g.drawRect(x,y,r,r);
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
        quadrado.setB(new Ponto(x, y));
    }


}