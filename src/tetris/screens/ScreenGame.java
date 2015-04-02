package tetris.screens;

import org.newdawn.slick.Color;
import tetris.blocks.Block;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glRecti;

/**
 * Created by AEnterprise
 */
public class ScreenGame extends ScreenBase {
	private int score, level;
	private Block blocks[][] = new Block[10][20];

	@Override
	public void init() {
		score = 0;
		level = 1;
		blocks[0][0] = new Block(9, 19);
		blocks[0][1] = new Block(8, 19);
	}

	@Override
	public void renderBackground() {
		super.renderBackground();
		glColor3f(1, 1, 1);
		glRecti(300, 100, 600, 700);
		glColor3f(0, 0, 0);
	}

	@Override
	protected void renderForeground() {
		super.renderForeground();

		drawText("Level: " + level, 100, 110, Color.orange);
		drawText("Score: " + score, 100, 130, Color.orange);

		for (Block blocklist[] : blocks) {
			for (Block block : blocklist) {
				if (block == null)
					continue;
				block.render();
			}
		}
	}

	@Override
	public void tick() {
		reset();
	}
}
