package tetris.utils;

import tetris.blocks.Block;


/**
 * Created by AEnterprise
 */
public class BlockManager {
	private Block blocks[][] = new Block[10][20];

	public void setBlock(int x, int y, Block block) {
		blocks[x][y] = block;
	}

	public void removeBlock(int x, int y) {
		blocks[x][y] = null;
	}

	public boolean isEmpty(int x, int y) {
		return x < 10 && y < 20 && x >= 0 && y >= 0 && blocks[x][y] == null;
	}

	public void renderBlocks() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				Block block = blocks[i][j];
				if (block != null)
					block.render(i, j);
			}
		}
	}


}
