package tetris.blocks;

import tetris.screens.ScreenGame;
import tetris.utils.Colors;

/**
 * Created by AEnterprise
 */
public class BigBlockA extends BigBlock {

	public BigBlockA(int x, int y) {
		super(x, y, Colors.getRandomColor());
	}

	@Override
	public void removeBlocks() {
		switch (rotation) {
			case 0:
			case 2:
				ScreenGame.blockManager.removeBlock(x, y);
				ScreenGame.blockManager.removeBlock(x + 1, y);
				ScreenGame.blockManager.removeBlock(x + 2, y);
				ScreenGame.blockManager.removeBlock(x + 3, y);
				return;
			case 1:
			case 3:
				ScreenGame.blockManager.removeBlock(x, y);
				ScreenGame.blockManager.removeBlock(x, y + 1);
				ScreenGame.blockManager.removeBlock(x, y + 2);
				ScreenGame.blockManager.removeBlock(x, y + 3);
		}
	}

	@Override
	public void addBlocks() {
		switch (rotation) {
			case 0:
			case 2:
				ScreenGame.blockManager.setBlock(x, y, new Block(color));
				ScreenGame.blockManager.setBlock(x + 1, y, new Block(color));
				ScreenGame.blockManager.setBlock(x + 2, y, new Block(color));
				ScreenGame.blockManager.setBlock(x + 3, y, new Block(color));
				return;
			case 1:
			case 3:
				ScreenGame.blockManager.setBlock(x, y, new Block(color));
				ScreenGame.blockManager.setBlock(x, y + 1, new Block(color));
				ScreenGame.blockManager.setBlock(x, y + 2, new Block(color));
				ScreenGame.blockManager.setBlock(x, y + 3, new Block(color));
		}
	}

	@Override
	public boolean canMoveDown() {
		removeBlocks();
		switch (rotation) {
			case 0:
			case 2:
				for (int i = 0; i < 4; i++) {
					if (!isEmpty(x + i, y + 1))
						return false;
				}
				break;
			case 1:
			case 3:
				for (int i = 0; i < 4; i++) {
					if (!isEmpty(x, y + 1 + i))
						return false;
				}

		}
		return y < 19;
	}

	@Override
	public boolean canMoveLeft() {
		removeBlocks();
		switch (rotation) {
			case 0:
			case 2:
				for (int i = 0; i < 4; i++) {
					if (!isEmpty(x - 1 + i, y))
						return false;
				}
				break;
			case 1:
			case 3:
				for (int i = 0; i < 4; i++) {
					if (!isEmpty(x - 1, y + i))
						return false;
				}
		}
		return x >= 0;
	}

	@Override
	public boolean canMoveRight() {
		removeBlocks();
		switch (rotation) {
			case 0:
			case 2:
				for (int i = 0; i < 4; i++) {
					if (!isEmpty(x + 1 + i, y))
						return false;
				}
				break;
			case 1:
			case 3:
				for (int i = 0; i < 4; i++) {
					if (!isEmpty(x + 1, y + i))
						return false;
				}
		}
		return x <= 9;
	}

	@Override
	public void rotate() {
		if (canRotate()) {
			rotation++;
			if (rotation == 4)
				rotation = 0;
		}
		addBlocks();
	}

	@Override
	public boolean canRotate() {
		removeBlocks();
		switch (rotation) {
			case 0:
			case 2:
				for (int i = 0; i < 4; i++) {
					if (!isEmpty(x, y + i))
						return false;
				}
			case 1:
			case 3:
				for (int i = 0; i < 4; i++) {
					if (!isEmpty(x + i, y))
						return false;
				}
		}
		return true;
	}
}
