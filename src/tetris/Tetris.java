package tetris;


import tetris.screens.ScreenBase;
import tetris.screens.ScreenMain;
import tetris.utils.MouseListener;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by AEnterprise
 */
public class Tetris extends Applet implements ActionListener {
	public static final int WIDTH = 1000, HEIGHT = 750;
	private static ScreenBase currentScreen;
	private int counter = 7;


	@Override
	public void init() {
		super.init();
		setSize(WIDTH, HEIGHT);
		new Timer(20, this).start();
		switchToScreen(new ScreenMain());
		addMouseListener(new MouseListener());
		addMouseMotionListener(new MouseListener());
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setSize(WIDTH, HEIGHT);
		currentScreen.render(g, MouseListener.mouseX, MouseListener.mouseY);

	}

	@Override
	public boolean action(Event evt, Object what) {
		return super.action(evt, what);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		currentScreen.tick();
		counter--;
		if (counter == 0) {
			this.repaint();
			counter = 7;
		}
	}

	public static void switchToScreen(ScreenBase screen) {
		currentScreen = screen;
		screen.init();
	}

	public static void click(int x, int y) {
		currentScreen.click(x, y);
	}
}
