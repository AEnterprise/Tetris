package tetris.screens;

import java.awt.Color;
import java.awt.Graphics;

import tetris.Tetris;
import tetris.blocks.BigBlock;
import tetris.screens.widgets.WidgetButtonLeft;
import tetris.screens.widgets.WidgetButtonRight;
import tetris.screens.widgets.WidgetButtonRotate;
import tetris.screens.widgets.WidgetDownButton;
import tetris.utils.BlockManager;
import tetris.utils.Utils;

/**
 * Created by AEnterprise
 */
public class ScreenGame extends ScreenBase {
	public static BlockManager blockManager;
	public BigBlock bigBlock;
	private int score, level, delay, lvlDelay;

	@Override
	public void init() {
		score = 0;
		level = 1;
		blockManager = new BlockManager();
		newBlock();
		widgets.add(new WidgetDownButton(10, 180, 80, 30, "DOWN", this).setColors(Color.yellow, Color.red, Color.red, Color.yellow));
		widgets.add(new WidgetButtonLeft(10, 220, 80, 30, "LEFT", this).setColors(Color.yellow, Color.red, Color.red, Color.yellow));
		widgets.add(new WidgetButtonRight(10, 260, 80, 30, "RIGHT", this).setColors(Color.yellow, Color.red, Color.red, Color.yellow));
		widgets.add(new WidgetButtonRotate(10, 300, 80, 30, "ROTATE", this).setColors(Color.yellow, Color.red, Color.red, Color.yellow));
		lvlDelay = delay = 40;
	}

	@Override
	public void renderBackground(Graphics g, int mouseX, int mouseY) {
		super.renderBackground(g, mouseX, mouseY);
		g.setColor(Color.ORANGE);
		g.fillRect(300, 100, 300, 600);
	}

	@Override
	protected void renderForeground(Graphics g, int mouseX, int mouseY) {
		super.renderForeground(g, mouseX, mouseY);
		g.setColor(Color.BLUE);
		String lvl = "Level: " + level;
		g.drawChars(lvl.toCharArray(), 0, lvl.length(), 10, 100);
		String s = "Score: " + score;
		g.drawChars(s.toCharArray(), 0, s.length(), 10, 120);

		blockManager.renderBlocks(g);
	}

	@Override
	public void tick() {
		delay--;
		if (delay == 0) {
			delay = lvlDelay;
			int y = bigBlock.y;
			bigBlock.moveDown();
			if (y == bigBlock.y)
				newBlock();
		}
	}

	private void newBlock() {
		checkLines();
		bigBlock = Utils.getRandomBlock(0, 0);
	}

	private void checkLines() {
		int olcScore = score;
		for (int y = 0; y < 20; y++) {
			boolean full = true;
			for (int x = 0; x < 10; x++) {
				if (blockManager.isEmpty(x, y)) {
					full = false;
				}
			}
			if (full) {
				blockManager.removeLine(y);
				score += 10;
			}
		}
		if (score > 0 && olcScore != score) {
			Tetris.INSTANCE.repaint();
			checkLines();
		}
	}
}
