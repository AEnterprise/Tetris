package tetris.screens.widgets;

import tetris.Tetris;
import tetris.screens.ScreenBase;

import java.awt.*;

/**
 * Created by AEnterprise
 */
public class WidgetMenuButton extends WidgetButton {
	private final ScreenBase newScreen;
	private final Color textNormal, textHover;
	private final String text;

	public WidgetMenuButton(int x, int y, String text, Image background, Color textNormal, Color textHover, ScreenBase newScreen, ScreenBase screen) {
		super(x, y, 200, 50, background, screen);
		this.newScreen = newScreen;
		this.textNormal = textNormal;
		this.textHover = textHover;
		this.text = text;
	}

	@Override
	public void clicked() {
		if (enabled)
			Tetris.INSTANCE.switchToScreen(newScreen);
	}

	@Override
	public void render(Graphics g, int mouseX, int mouseY, boolean hover) {
		super.render(g, mouseX, mouseY, hover);
		g.setColor(hover ? textHover : textNormal);
		g.drawChars(text.toCharArray(), 0, text.length(), x + width/2 - text.length()*4, y + height / 2);
	}
}
