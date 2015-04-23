package tetris.screens.widgets;

import tetris.screens.ScreenBase;
import tetris.screens.ScreenGame;

/**
 * Created by AEnterprise
 */
public class WidgetButtonLeft extends WidgetButton {

	public WidgetButtonLeft(int id, int x, int y, int width, int height, String text, ScreenBase screen) {
		super(id, x, y, width, height, text, screen);
	}

	@Override
	public void clicked() {
		ScreenGame.bigBlock.moveLeft();
	}
}
