package tetris.blocks;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glRecti;

/**
 * Created by AEnterprise
 */
public class Block {
	public int x, y;
	private final int SIZE = 30;

	public Block(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void render() {
		glColor3f(0.55f, 0.92f, 1f);
		glRecti(300 + SIZE * x, 100 + SIZE * y, (300 + SIZE) + SIZE * x, (100 + SIZE) + SIZE * y);
	}
}
