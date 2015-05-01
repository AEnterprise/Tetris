package tetris.screens.widgets;

import tetris.Tetris;
import tetris.screens.ScreenBase;
import tetris.screens.ScreenGame;

/**
 * Created by AEnterprise
 */
public class WidgetButtonRight extends WidgetButton {
	public WidgetButtonRight(int id, int x, int y, int width, int height, String text, ScreenBase screen) {
		super(id, x, y, width, height, text, screen);
	}

	@Override
	public void clicked() {
		((ScreenGame) Tetris.INSTANCE.getCurrentScreen()).bigBlock.moveRight();
	}
}
