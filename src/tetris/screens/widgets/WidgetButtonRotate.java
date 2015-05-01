package tetris.screens.widgets;

import tetris.screens.ScreenBase;
import tetris.screens.ScreenGame;

/**
 * Created by AEnterprise
 */
public class WidgetButtonRotate extends WidgetButton {

	public WidgetButtonRotate(int x, int y, int width, int height, String text, ScreenBase screen) {
		super(x, y, width, height, text, screen);
	}

	@Override
	public void clicked() {
		((ScreenGame) screen).bigBlock.rotate();
	}
}
