package tetris.screens.widgets;

import tetris.Tetris;
import tetris.screens.ScreenBase;
import tetris.screens.ScreenGame;

/**
 * Created by AEnterprise
 */
public class WidgetDownButton extends WidgetButton {

	public WidgetDownButton(int id, int x, int y, int width, int height, String text, ScreenBase screen) {
		super(id, x, y, width, height, text, screen);
	}

	@Override
	public void clicked() {
		((ScreenGame) Tetris.INSTANCE.getCurrentScreen()).bigBlock.moveDown();
	}
}
