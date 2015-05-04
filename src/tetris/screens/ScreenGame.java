package tetris.screens;

import tetris.Tetris;
import tetris.blocks.BigBlock;
import tetris.blocks.Block;
import tetris.screens.widgets.*;
import tetris.utils.*;

import java.awt.*;

/**
 * Created by AEnterprise
 */
public class ScreenGame extends ScreenBase {
	public static BlockManager blockManager;
	public BigBlock bigBlock, nextBlock;
	private int score, level, delay, lvlDelay;
	private boolean gameOver = false;
	private WidgetButton menu = new WidgetMenuButton(380, 600, "BACK TO MAIN MENU", Images.buttons[Colors.RED.ordinal()], Color.BLACK, Color.WHITE, new ScreenMain(), this).dissable();

	@Override
	public void init() {
		score = 0;
		level = 1;
		blockManager = new BlockManager();
		newBlock();
		widgets.add(new WidgetDownButton(800, 600, this));
		widgets.add(new WidgetButtonLeft(725, 600, this));
		widgets.add(new WidgetButtonRight(875, 600, this));
		widgets.add(new WidgetButtonRotate(800, 525, this));
		lvlDelay = delay = 40;
	}

	@Override
	public void renderBackground(Graphics g, int mouseX, int mouseY) {
		super.renderBackground(g, mouseX, mouseY);
		g.drawImage(Images.board, 290, 90, Tetris.INSTANCE);
		g.drawImage(Images.nextBlock, 645, 110, Tetris.INSTANCE);
		if (Tetris.INSTANCE.OPTIONS.showGrid)
			g.drawImage(Images.gridOverlay, 290, 90, Tetris.INSTANCE);
	}

	@Override
	protected void renderForeground(Graphics g, int mouseX, int mouseY) {
		super.renderForeground(g, mouseX, mouseY);
		Font old = g.getFont();
		g.setColor(Color.CYAN);
		g.setFont(new Font("", Font.BOLD, 38));
		g.drawImage(Images.level, 10, 100, Tetris.INSTANCE);
		g.drawImage(Images.score, 10, 200, Tetris.INSTANCE);
		String lvl = String.valueOf(level);
		g.drawChars(lvl.toCharArray(), 0, lvl.length(), 180, 155);
		String s = String.valueOf(score);
		g.drawChars(s.toCharArray(), 0, s.length(), 180, 255);
		g.setFont(old);



		blockManager.renderBlocks(g);

		for (Location location: nextBlock.getLocations()) {
			Block block = new Block(nextBlock.TEXTURE);
			block.render(g, 12 + location.getX(), 1 + location.getY());
		}
		if (gameOver) {
			Color color = new Color(0, 0, 0, .6f);
			g.setColor(color);
			g.fillRect(0, 0, Tetris.INSTANCE.WIDTH, Tetris.INSTANCE.HEIGHT);
			g.drawImage(Images.gameOver, 100, 300, Tetris.INSTANCE);
			menu.render(g, mouseX, mouseY, menu.mouseOver(mouseX, mouseY));

		}
	}

	@Override
	public void tick() {
		if (gameOver)
			return;
		level = ((int)Math.floor(score / 30)) + 1;
		lvlDelay = Math.max(40 - 3 * level, 3);
		delay--;
		if (delay <= 0) {
			delay = lvlDelay;
			int y = bigBlock.y;
			bigBlock.moveDown();
			if (y == bigBlock.y)
				newBlock();
		}
	}

	private void newBlock() {
		checkLines();
		if (nextBlock == null)
			nextBlock = Utils.getRandomBlock(3, 0);
		bigBlock = nextBlock;
		bigBlock.start();
		bigBlock.addBlocks();
		nextBlock = Utils.getRandomBlock(3, 0);
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
				score += 15;
			}
		}
		if (score > 0 && olcScore != score) {
			Tetris.INSTANCE.repaint();
			checkLines();
		}
	}

	public void gameOver() {
		gameOver = true;
		widgets.add(menu);
		menu.enable();
	}
}
