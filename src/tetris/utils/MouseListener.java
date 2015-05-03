package tetris.utils;

import tetris.Tetris;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by AEnterprise
 */
public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {
	public static int mouseX, mouseY;

	@Override
	public void mouseDragged(MouseEvent e) {
		Tetris.INSTANCE.requestFocus();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		Tetris.INSTANCE.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Tetris.INSTANCE.requestFocus();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Tetris.INSTANCE.requestFocus();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Tetris.INSTANCE.click(e.getX(), e.getY());
		Tetris.INSTANCE.requestFocus();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Tetris.INSTANCE.requestFocus();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Tetris.INSTANCE.requestFocus();
	}
}
