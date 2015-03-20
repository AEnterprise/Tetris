package tetris.screens;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import tetris.Tetris;
import tetris.screens.widgets.WidgetBase;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by AEnterprise
 */
public abstract class ScreenBase {
	private Font awtFont = new Font("", Font.PLAIN, 12);
	private TrueTypeFont font;
	protected ArrayList<WidgetBase> widgets = new ArrayList<WidgetBase>();


	public abstract void init();

	public void render() {
		GL11.glColor3f(0.91f, 0.91f, 0.91f);
		GL11.glRecti(0, 0, Tetris.WIDTH, Tetris.HEIGHT);
		boolean mouseDown = false;
		for (WidgetBase widget : widgets) {
			widget.render(Mouse.getX(), (Mouse.getY() - Tetris.HEIGHT) * -1, widget.mouseOver(Mouse.getX(), (Mouse.getY() - Tetris.HEIGHT) * -1));
		}
		while (Mouse.next()) {
			if (Mouse.getEventButton() > -1) {
				if (Mouse.getEventButtonState()) {
					System.out.println("PRESSED MOUSE BUTTON: " + Mouse.getEventButton());
				} else System.out.println("RELEASED MOUSE BUTTON: " + Mouse.getEventButton());
			}
		}
	}

	public abstract void tick();

	public void drawText(String text, int x, int y, Color color) {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		font = new TrueTypeFont(awtFont, false);
		font.drawString(x, y, text, color);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
	}

	public void drawText(String text, int x, int y) {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		font = new TrueTypeFont(awtFont, true);
		font.drawString(x, y, text);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
	}

	public void setFont(int style, int size) {
		awtFont = new Font("", style, size);
	}

	public void reset() {
		widgets.clear();
		init();
	}

}
