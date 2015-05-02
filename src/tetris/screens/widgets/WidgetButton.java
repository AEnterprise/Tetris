package tetris.screens.widgets;

import tetris.Tetris;
import tetris.screens.ScreenBase;

import java.awt.*;

/**
 * Created by AEnterprise
 */
public abstract class WidgetButton extends WidgetBase {
    private final Image background;

	public WidgetButton(int x, int y, int width, int height, Image background, ScreenBase screen) {
		super(x, y, width, height, screen);
        this.background = background;
	}

	@Override
	public void render(Graphics g, int mouseX, int mouseY, boolean hover) {
		g.drawImage(background, x, y, Tetris.INSTANCE);
	}

	@Override
	public abstract void clicked();
}
