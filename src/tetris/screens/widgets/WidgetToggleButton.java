package tetris.screens.widgets;

import tetris.Tetris;
import tetris.screens.ScreenBase;
import tetris.utils.Colors;
import tetris.utils.Images;

import java.awt.*;

/**
 * Created by AEnterprise
 */
public class WidgetToggleButton extends WidgetButton {
	public boolean active;
	private String text;

	public WidgetToggleButton(int x, int y, String text, boolean active, ScreenBase screen) {
		super(x, y, 200, 50, null, screen);
		this.active = active;
		this.text = text;
	}

	@Override
	public void clicked() {
		active = !active;
	}

	@Override
	public void render(Graphics g, int mouseX, int mouseY, boolean hover) {
		if (active) {
			g.drawImage(Images.buttons[Colors.GREEN.ordinal()], x, y, Tetris.INSTANCE);
		} else {
			g.drawImage(Images.buttons[Colors.RED.ordinal()], x, y, Tetris.INSTANCE);
		}
		g.setColor(Color.ORANGE);
		g.drawChars(text.toCharArray(), 0, text.length(), x + width/2 - text.length()*4, y + height / 2);
	}
}
