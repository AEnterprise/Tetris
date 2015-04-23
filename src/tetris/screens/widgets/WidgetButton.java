package tetris.screens.widgets;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import tetris.screens.ScreenBase;

import java.awt.*;

/**
 * Created by AEnterprise
 */
public abstract class WidgetButton extends WidgetBase {
	private String text;
	private Color backgroundNormal, backgroundHover, textNormal, textHover;


	public WidgetButton(int id, int x, int y, int width, int height, String text, ScreenBase screen) {
		super(id, x, y, width, height, screen);
		this.text = text;
	}

	@Override
	public void render(int mouseX, int mouseY, boolean hover) {
		GL11.glColor3f(hover ? backgroundHover.getRed() : backgroundNormal.getRed(), hover ? backgroundHover.getGreen() : backgroundNormal.getGreen(), hover ? backgroundHover.getBlue() : backgroundNormal.getBlue());
		GL11.glRecti(x, y, x + width, y + height);
		screen.setFont(Font.BOLD, 15);
		screen.drawText(text, x + width / 2 - (text.length() / 2) * 15, y + height / 4, hover ? textHover : textNormal);
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
