package tetris.screens.widgets;

import java.awt.Color;
import java.awt.Graphics;

import tetris.screens.ScreenBase;

/**
 * Created by AEnterprise
 */
public abstract class WidgetButton extends WidgetBase {
	private String text;
	private Color backgroundNormal, backgroundHover, textNormal, textHover;

	public WidgetButton(int x, int y, int width, int height, String text, ScreenBase screen) {
		super(x, y, width, height, screen);
		this.text = text;
	}

	@Override
	public void render(Graphics g, int mouseX, int mouseY, boolean hover) {
		g.setColor(hover ? backgroundHover : backgroundNormal);
		g.fillRect(x, y, width, height);
		g.setColor(hover ? textHover : textNormal);
		g.drawChars(text.toCharArray(), 0, text.length(), (x + width / 2) - text.length() * 4, y + height / 2);
	}

	public WidgetButton setColors(Color backgroundNormal, Color backgroundHover, Color textNormal, Color textHover) {
		this.backgroundNormal = backgroundNormal;
		this.backgroundHover = backgroundHover;
		this.textNormal = textNormal;
		this.textHover = textHover;
		return this;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public abstract void clicked();
}
