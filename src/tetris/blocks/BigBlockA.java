package tetris.blocks;

import tetris.screens.ScreenGame;

/**
 * Created by AEnterprise
 */
public class BigBlockA extends BigBlock {

	public BigBlockA(int x, int y) {
		super(x, y);
	}

	@Override
	public void removeBlocks() {
		ScreenGame.blockManager.removeBlock(x, y);
		ScreenGame.blockManager.removeBlock(x + 1, y);
		ScreenGame.blockManager.removeBlock(x + 2, y);
		ScreenGame.blockManager.removeBlock(x + 3, y);
	}

	@Override
	public void addBlocks() {
		ScreenGame.blockManager.setBlock(x, y, new Block());
		ScreenGame.blockManager.setBlock(x + 1, y, new Block());
		ScreenGame.blockManager.setBlock(x + 2, y, new Block());
		ScreenGame.blockManager.setBlock(x + 3, y, new Block());
	}

	@Override
	public boolean canMoveDown() {
		for (int i = 0; i < 4; i++) {
			if (!isEmpty(x + i, y + 1))
				return false;
		}
		return y < 19;
	}

	@Override
	public boolean canMoveLeft() {
		for (int i = 0; i < 4; i++) {
			if (!isEmpty(x - 1 + i, y))
				return false;
		}
		return x > 1;
	}

	@Override
	public boolean canMoveRight() {
		for (int i = 0; i < 4; i++) {
			if (!isEmpty(x + 1 + i, y))
				return false;
		}
		return x < 5;
	}
}
