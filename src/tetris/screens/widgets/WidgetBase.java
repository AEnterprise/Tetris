package tetris.screens.widgets;

import tetris.screens.ScreenBase;

import java.awt.*;

/**
 * Created by AEnterprise
 */
public abstract class WidgetBase {
	protected final int x, y, width, height;
	protected final ScreenBase screen;

	public WidgetBase(int x, int y, int width, int height, ScreenBase screen) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.screen = screen;
	}

	public abstract void render(Graphics g, int mouseX, int mouseY, boolean hover);

	public boolean mouseOver(int mouseX, int mouseY) {
		Rectangle rect = new Rectangle(x, y, width, height);
		return rect.contains(mouseX, mouseY);
	}

	public void clicked() {
	}
}
