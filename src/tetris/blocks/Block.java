package tetris.blocks;

import java.awt.Graphics;
import java.awt.Image;

import tetris.Tetris;

/**
 * Created by AEnterprise
 */
public class Block {
	private static final int SIZE = 30;
	private final Image TEXTURE;

	public Block(Image texture) {
		this.TEXTURE = texture;
	}


	public void render(Graphics g, int x, int y) {
		g.drawImage(TEXTURE, 300 + SIZE * x, 100 + SIZE * y, SIZE, SIZE, Tetris.INSTANCE);
	}
}
