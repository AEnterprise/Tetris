package tetris.utils;


import tetris.Tetris;
import tetris.screens.ScreenGame;

import java.awt.event.KeyEvent;

/**
 * Created by AEnterprise
 */
public class KeyListener implements java.awt.event.KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (Tetris.INSTANCE.getCurrentScreen() instanceof ScreenGame) {
			ScreenGame game = ((ScreenGame) Tetris.INSTANCE.getCurrentScreen());
			int key = e.getKeyCode();
			switch (key) {
				case KeyEvent.VK_UP:
					game.bigBlock.rotate();
					break;
				case KeyEvent.VK_LEFT:
					game.bigBlock.moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					game.bigBlock.moveRight();
					break;
				case KeyEvent.VK_DOWN:
					game.bigBlock.moveDown();
					break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
