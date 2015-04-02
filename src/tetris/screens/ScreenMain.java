package tetris.screens;

import org.newdawn.slick.Color;
import tetris.screens.widgets.WidgetMenuButton;

import java.awt.*;

/**
 * Created by AEnterprise
 */
public class ScreenMain extends ScreenBase {

	@Override
	public void init() {
		widgets.add(new WidgetMenuButton(0, 400, 180, 250, 30, "START", this).setColors(Color.yellow, Color.red, Color.red, Color.yellow));
	}

	@Override
	public void renderForeground() {
		super.renderForeground();
		setFont(Font.BOLD, 30);
		drawText("Main menu", 430, 100, Color.cyan);
		reset();
	}

	@Override
	public void tick() {

	}
}
