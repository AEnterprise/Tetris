package tetris.screens.widgets;

import tetris.screens.ScreenBase;
import tetris.screens.ScreenGame;

/**
 * Created by AEnterprise
 */
public class WidgetDownButton extends WidgetButton {

	public WidgetDownButton(int x, int y, int width, int height, String text, ScreenBase screen) {
		super(x, y, width, height, text, screen);
	}

	@Override
	public void clicked() {
		((ScreenGame) screen).bigBlock.moveDown();
	}
}
