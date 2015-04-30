package tetris.blocks;


import java.awt.*;

/**
 * Created by AEnterprise
 */
public class Block {
	private static final int SIZE = 30;


	public void render(Graphics g, int x, int y) {
		g.setColor(Color.RED);
		g.fillRect(300 + SIZE * x, 100 + SIZE * y, SIZE, SIZE);
		g.setColor(Color.CYAN);
		g.fillRect(301 + SIZE * x, 101 + SIZE * y, SIZE - 2, SIZE - 2);
	}
}
