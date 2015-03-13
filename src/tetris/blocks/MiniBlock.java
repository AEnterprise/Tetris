package tetris.blocks;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glRecti;
/**
 * Created by AEnterprise
 */
public class MiniBlock {
	public int x, y;

	public MiniBlock(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void render() {
		glColor3f(0.55f, 0.92f, 1f);
		glRecti(300 + 25 * x, 100 + 25 * y, 325 + 25 * x, 125 + 25 * y);
		glColor3f(1f, 0f, 0f);
		glRecti(300 + 25 * x, 100 + 25 * y, 325 + 25 * x, 101 + 25 * y);
		glRecti(300 + 25 * x, 124 + 25 * y, 325 + 25 * x, 125 + 25 * y);
		glRecti(300 + 25 * x, 100 + 25 * y, 301 + 25 * x, 125 + 25 * y);
		glRecti(324 + 25 * x, 100 + 25 * y, 325 + 25 * x, 125 + 25 * y);
	}
}
