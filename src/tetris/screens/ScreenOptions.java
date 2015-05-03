package tetris.screens;

import tetris.Tetris;
import tetris.screens.widgets.WidgetMenuButton;
import tetris.screens.widgets.WidgetToggleButton;
import tetris.utils.Colors;
import tetris.utils.Images;

import java.awt.*;

/**
 * Created by AEnterprise
 */
public class ScreenOptions extends ScreenBase {
	private WidgetToggleButton showGrid = new WidgetToggleButton(350, 250, "Show Grid", Tetris.INSTANCE.OPTIONS.showGrid, this);

	@Override
	public void init() {
		widgets.add(showGrid);
		widgets.add(new WidgetMenuButton(350, 550, "BACK TO MAIN MENU", Images.buttons[Colors.PURPLE.ordinal()], Color.YELLOW, Color.BLUE, new ScreenMain(), this));
	}

	@Override
	public void tick() {
	}

	@Override
	protected void renderForeground(Graphics g, int mouseX, int mouseY) {
		super.renderForeground(g, mouseX, mouseY);
		g.drawImage(Images.settingsTitle, 80, 30, Tetris.INSTANCE);
	}

	@Override
	public void click(int mouseX, int mouseY) {
		super.click(mouseX, mouseY);
		Tetris.INSTANCE.OPTIONS.showGrid = showGrid.active;
	}
}
