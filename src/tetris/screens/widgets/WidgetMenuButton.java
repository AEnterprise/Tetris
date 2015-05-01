package tetris.screens.widgets;

import tetris.Tetris;
import tetris.screens.ScreenBase;

/**
 * Created by AEnterprise
 */
public class WidgetMenuButton extends WidgetButton {
	private final ScreenBase newScreen;

	public WidgetMenuButton(int x, int y, int width, int height, String text, ScreenBase newScreen, ScreenBase screen) {
		super(x, y, width, height, text, screen);
		this.newScreen = newScreen;
	}

	@Override
	public void clicked() {
		Tetris.INSTANCE.switchToScreen(newScreen);
	}
}
