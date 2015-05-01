package tetris.screens.widgets;

import tetris.screens.ScreenBase;
import tetris.screens.ScreenGame;

/**
 * Created by AEnterprise
 */
public class WidgetButtonRight extends WidgetButton {
	public WidgetButtonRight(int x, int y, int width, int height, String text, ScreenBase screen) {
		super(x, y, width, height, text, screen);
	}

	@Override
	public void clicked() {
		((ScreenGame) screen).bigBlock.moveRight();
	}
}
