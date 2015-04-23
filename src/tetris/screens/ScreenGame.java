package tetris.screens;

import org.newdawn.slick.Color;
import tetris.blocks.BigBlock;
import tetris.blocks.BigBlockA;
import tetris.screens.widgets.WidgetButtonLeft;
import tetris.screens.widgets.WidgetButtonRight;
import tetris.screens.widgets.WidgetDownButton;
import tetris.utils.BlockManager;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glRecti;

/**
 * Created by AEnterprise
 */
public class ScreenGame extends ScreenBase {
	private int score, level;
	public static BlockManager blockManager;
	public static BigBlock bigBlock;

	@Override
	public void init() {
		score = 0;
		level = 1;
		blockManager = new BlockManager();
		bigBlock = new BigBlockA(0, 0);
		widgets.add(new WidgetDownButton(0, 10, 180, 80, 30, "DOWN", this).setColors(Color.yellow, Color.red, Color.red, Color.yellow));
		widgets.add(new WidgetButtonLeft(0, 10, 220, 80, 30, "LEFT", this).setColors(Color.yellow, Color.red, Color.red, Color.yellow));
		widgets.add(new WidgetButtonRight(0, 10, 260, 80, 30, "RIGHT", this).setColors(Color.yellow, Color.red, Color.red, Color.yellow));
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

		blockManager.renderBlocks();
	}

	@Override
	public void tick() {

	}
}
