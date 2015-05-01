package tetris.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import tetris.screens.widgets.WidgetMenuButton;

/**
 * Created by AEnterprise
 */
public class ScreenMain extends ScreenBase {

	@Override
	public void init() {
		widgets.add(new WidgetMenuButton(0, 400, 180, 250, 30, "START", this).setColors(Color.yellow, Color.red, Color.red, Color.yellow));
	}

	@Override
	public void renderForeground(Graphics g, int mouseX, int mouseY) {
		super.renderForeground(g, mouseX, mouseY);
		Font old = g.getFont();
		g.setFont(new Font("", Font.BOLD, 30));
		g.setColor(Color.ORANGE);
		String title = "TETRIS";
		g.drawChars(title.toCharArray(), 0, title.length(), 470, 60);
		g.setFont(old);
		reset();
	}

	@Override
	public void tick() {

	}
}
