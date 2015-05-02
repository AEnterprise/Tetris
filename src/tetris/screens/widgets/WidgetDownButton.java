package tetris.screens.widgets;

import tetris.screens.ScreenBase;
import tetris.screens.ScreenGame;
import tetris.utils.Images;

/**
 * Created by AEnterprise
 */
public class WidgetDownButton extends WidgetButton {

	public WidgetDownButton(int x, int y, ScreenBase screen) {
		super(x, y, 75, 75, Images.downButton, screen);
	}

	@Override
	public void clicked() {
		((ScreenGame) screen).bigBlock.moveDown();
	}
}
