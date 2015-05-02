package tetris.screens.widgets;

import tetris.screens.ScreenBase;
import tetris.screens.ScreenGame;
import tetris.utils.Images;

/**
 * Created by AEnterprise
 */
public class WidgetButtonLeft extends WidgetButton {

    public WidgetButtonLeft(int x, int y, ScreenBase screen) {
        super(x, y, 75, 75, Images.leftButton, screen);
    }

	@Override
	public void clicked() {
		((ScreenGame) screen).bigBlock.moveLeft();
	}
}
