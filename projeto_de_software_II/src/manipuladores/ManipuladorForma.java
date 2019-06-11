package manipuladores;

import java.awt.Graphics;

public interface ManipuladorForma {
	void click(int x, int y);
	void press(int x, int y);
	void release(int x, int y);
	void drag(int x, int y);
	
	void paint(Graphics g);
}
