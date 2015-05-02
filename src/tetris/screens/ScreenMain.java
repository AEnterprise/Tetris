package tetris.screens;

import tetris.Tetris;
import tetris.screens.widgets.WidgetMenuButton;
import tetris.utils.Colors;
import tetris.utils.Images;

import java.awt.*;

/**
 * Created by AEnterprise
 */
public class ScreenMain extends ScreenBase {

	@Override
	public void init() {
		widgets.add(new WidgetMenuButton(400, 220, "START", Images.buttons[Colors.GREEN.ordinal()], Color.yellow, Color.red, new ScreenGame(), this));
		widgets.add(new WidgetMenuButton(400, 300, "CREDITS", Images.buttons[Colors.BLUE.ordinal()], Color.yellow, Color.red, new ScreenCredits(), this));
	}

	@Override
	public void renderForeground(Graphics g, int mouseX, int mouseY) {
		super.renderForeground(g, mouseX, mouseY);
        g.drawImage(Images.logo, 100, 10, Tetris.INSTANCE);
	}

	@Override
	public void tick() {

	}
}
