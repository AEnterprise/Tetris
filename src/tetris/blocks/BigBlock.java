package tetris.blocks;

import tetris.screens.ScreenGame;
import tetris.utils.Images;
import tetris.utils.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AEnterprise
 */
public abstract class BigBlock {
	protected static Location[][] STATES;
	public int x, y, rotation;
	protected List<Location> locations = new ArrayList<>();
    private final Image TEXTURE;

	public BigBlock(int x, int y) {
		this.x = x;
		this.y = y;
		rotation = 0;
        TEXTURE = Images.getRandomTexture();
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
			if (!ScreenGame.blockManager.isEmpty(x + location.getX(), y + location.getY())) {
				rotateLeft();
				resetList();
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
			ScreenGame.blockManager.setBlock(x + location.getX(), y + location.getY(), new Block(TEXTURE));
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
