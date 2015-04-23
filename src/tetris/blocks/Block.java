package tetris.blocks;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glRecti;

/**
 * Created by AEnterprise
 */
public class Block {
	private final int SIZE = 30;


	public void render(int x, int y) {
		glColor3f(255, 0, 0);
		glRecti(300 + SIZE * x, 100 + SIZE * y, (300 + SIZE) + SIZE * x, (100 + SIZE) + SIZE * y);
		glColor3f(0.55f, 0.92f, 1f);
		glRecti((300 + SIZE * x) + 1, (100 + SIZE * y) + 1, ((300 + SIZE) + SIZE * x) - 1, ((100 + SIZE) + SIZE * y) - 1);
	}
}
