package tetris.screens.widgets;

import tetris.screens.ScreenBase;

import java.awt.*;

/**
 * Created by AEnterprise
 */
public abstract class WidgetBase {
	protected final int x, y, id, width, height;
	protected final ScreenBase screen;

	public WidgetBase(int id, int x, int y, int width, int height, ScreenBase screen) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.screen = screen;
	}

	public abstract void render(int mouseX, int mouseY, boolean hover);

	public boolean mouseOver(int mouseX, int mouseY) {
		Rectangle rect = new Rectangle(x, y, width, height);
		return rect.contains(mouseX, mouseY);
	}
}
