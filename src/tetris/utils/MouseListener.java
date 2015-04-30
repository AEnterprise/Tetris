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

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Tetris.click(e.getX(), e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}