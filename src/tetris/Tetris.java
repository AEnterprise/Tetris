package tetris;


import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import tetris.blocks.BigBlock;
import tetris.blocks.MiniBlock;
import tetris.utils.Time;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glRecti;

/**
 * Created by AEnterprise
 */
public class Tetris {
	public final int WIDTH = 1200, HEIGHT = 900;
	private static List<MiniBlock> blocks = new ArrayList<MiniBlock>();
	private int time = 0;
	private BigBlock bigblock;
	//field size: 17x27

	public static void main(String[] args) {
		new Tetris();
	}

	public Tetris() {
		initGL();
		blocks.add(new MiniBlock(0, 0));
		blocks.add(new MiniBlock(0, 27));
		blocks.add(new MiniBlock(17, 27));
		blocks.add(new MiniBlock(17, 0));
		while (!Display.isCloseRequested()) {
			render();
			Display.update();
			Display.sync(40);
			Display.setResizable(false);
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
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}

	private void tick() {
		if (!Time.shouldTick())
			return;
		bigblock.tick();
	}

	private void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		glColor3f(0.91f, 0.91f, 0.91f);
		glRecti(0, 0, WIDTH, HEIGHT);
		glColor3f(0, 0, 0);
		glRecti(300, 100, 750, 800);
		for (MiniBlock block : blocks) {
			block.render();
		}
	}

	public static boolean isBlockAt(int x, int y) {
		for (MiniBlock block : blocks) {
			if (block.x == x && block.y == y)
				return true;
		}
		return false;
	}
}
