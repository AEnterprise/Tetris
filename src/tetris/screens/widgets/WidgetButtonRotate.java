package tetris.screens.widgets;

import tetris.screens.ScreenBase;
import tetris.screens.ScreenGame;

/**
 * Created by AEnterprise
 */
public class WidgetButtonRotate extends WidgetButton {

	public WidgetButtonRotate(int id, int x, int y, int width, int height, String text, ScreenBase screen) {
		super(id, x, y, width, height, text, screen);
	}

	@Override
	public void clicked() {
		ScreenGame.bigBlock.rotate();
	}
}
