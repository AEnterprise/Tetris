package tetris.screens.widgets;

import tetris.screens.ScreenBase;
import tetris.screens.ScreenGame;
import tetris.utils.Images;

/**
 * Created by AEnterprise
 */
public class WidgetButtonRotate extends WidgetButton {

    public WidgetButtonRotate(int x, int y, ScreenBase screen) {
        super(x, y, 75, 75, Images.rotateButton, screen);
    }

	@Override
	public void clicked() {
		((ScreenGame) screen).bigBlock.rotate();
	}
}
