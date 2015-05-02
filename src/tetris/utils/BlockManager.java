package tetris.utils;

import tetris.Tetris;
import tetris.blocks.Block;
import tetris.screens.ScreenGame;

import java.awt.*;


/**
 * Created by AEnterprise
 */
public class BlockManager {
	private Block blocks[][] = new Block[10][20];

	public void setBlock(int x, int y, Block block) {
		if (!isEmpty(x, y)) {
			((ScreenGame) Tetris.INSTANCE.getCurrentScreen()).gameOver();
		}
		blocks[x][y] = block;
	}

	public void removeBlock(int x, int y) {
		blocks[x][y] = null;
	}

	public boolean isEmpty(int x, int y) {
		return x < 10 && y < 20 && x >= 0 && y >= 0 && blocks[x][y] == null;
	}

	public void removeLine(int y) {
		for (int x = 0; x < 10; x++) {
			removeBlock(x, y);
		}
		for (int i = y - 1; i > 0; i--) {
			for (int x = 0; x < 10; x++) {
				setBlock(x, i + 1, blocks[x][i]);
				removeBlock(x, i);
			}
		}
	}

	public void renderBlocks(Graphics g) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				Block block = blocks[i][j];
				if (block != null)
					block.render(g, i, j);
			}
		}
	}


}
