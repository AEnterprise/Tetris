package tetris.blocks;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tetris.screens.ScreenGame;
import tetris.utils.Location;

/**
 * Created by AEnterprise
 */
public abstract class BigBlock {
	protected static Location[][] STATES;
	public int x, y, rotation;
	protected Color color;
	protected List<Location> locations = new ArrayList<>();

	public BigBlock(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		rotation = 0;
		this.color = color;
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

	public void rotate() {
		removeBlocks();
		rotateRight();
		resetList();
		for (Location location : locations) {
			if (!ScreenGame.blockManager.isEmpty(x + location.getY(), x + location.getY())) {
				rotateLeft();
				resetList();
				return;
			}
		}
		addBlocks();
	}

	public void rotateLeft() {
		if (rotation == 0)
			rotation = 3;
		else
			rotation--;
	}

	public void rotateRight() {
		if (rotation == 3)
			rotation = 0;
		else
			rotation++;
	}

	protected void resetList() {
		locations.clear();
		locations.addAll(Arrays.asList(STATES[rotation]));
	}

	private void removeBlocks() {
		for (Location location : locations)
			ScreenGame.blockManager.removeBlock(x + location.getX(), y + location.getY());
	}

	public void addBlocks() {
		for (Location location : locations) {
			ScreenGame.blockManager.setBlock(x + location.getX(), y + location.getY(), new Block(color));
		}
	}

	public boolean canMoveDown() {
		removeBlocks();
		for (Location location : locations) {
			if (!isEmpty(x + location.getX(), y + 1 + location.getY()))
				return false;
		}
		return true;
	}

	public boolean canMoveLeft() {
		removeBlocks();
		for (Location location : locations) {
			if (!isEmpty(x - 1 + location.getX(), y + location.getY()))
				return false;
		}
		return true;
	}

	public boolean canMoveRight() {
		removeBlocks();
		for (Location location : locations) {
			if (!isEmpty(x + 1 + location.getX(), y + location.getY()))
				return false;
		}
		return true;
	}


	protected boolean isEmpty(int x, int y) {
		return ScreenGame.blockManager.isEmpty(x, y);
	}
}
