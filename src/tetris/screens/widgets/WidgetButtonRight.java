package tetris.screens.widgets;

import tetris.screens.ScreenBase;
import tetris.screens.ScreenGame;
import tetris.utils.Images;

/**
 * Created by AEnterprise
 */
public class WidgetButtonRight extends WidgetButton {

    public WidgetButtonRight(int x, int y, ScreenBase screen) {
        super(x, y, 75, 75, Images.rightButton, screen);
    }

	@Override
	public void clicked() {
		((ScreenGame) screen).bigBlock.moveRight();
	}
}
