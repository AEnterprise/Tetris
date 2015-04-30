package tetris.blocks;

import tetris.screens.ScreenGame;

/**
 * Created by AEnterprise
 */
public abstract class BigBlock {
	public int x, y, rotation;

	public BigBlock(int x, int y) {
		this.x = x;
		this.y = y;
		rotation = 0;
		addBlocks();
	}

	public void moveDown() {
		if (canMoveDown()) {
			y++;
		}
		addBlocks();
	}

	public void moveLeft() {
		if (canMoveLeft()) {
			x--;
		}
		addBlocks();
	}

	public void moveRight() {
		if (canMoveRight()) {
			x++;
		}
		addBlocks();
	}

	public abstract void rotate();

	public abstract void removeBlocks();

	public abstract void addBlocks();

	public abstract boolean canMoveDown();

	public abstract boolean canMoveLeft();

	public abstract boolean canMoveRight();

	public abstract boolean canRotate();

	protected boolean isEmpty(int x, int y) {
		return ScreenGame.blockManager.isEmpty(x, y);
	}
}
