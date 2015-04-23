package tetris;


import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import tetris.screens.ScreenBase;
import tetris.screens.ScreenMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by AEnterprise
 */
public class Tetris implements ActionListener {
	public static final int WIDTH = 1000, HEIGHT = 750;
	private static ScreenBase currentScreen;


	public static void main(String[] args) {
		new Tetris();
	}

	private Tetris() {
		initGL();
		new Timer(20, this).start();
		switchToScreen(new ScreenMain());
		Display.setResizable(false);
		while (!Display.isCloseRequested()) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			currentScreen.render();
			Display.update();
			//Display.sync(60);
		}

		Display.destroy();
		System.exit(0);
	}

	private void initGL() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("Tetris");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}

		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		GL11.glClearDepth(1);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glViewport(0, 0, WIDTH, HEIGHT);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		currentScreen.tick();
	}

	public static void switchToScreen(ScreenBase screen) {
		currentScreen = screen;
		screen.init();
	}
}
