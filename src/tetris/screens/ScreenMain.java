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
		widgets.add(new WidgetMenuButton(0, 500, 180, 250, 30, "START", this).setColors(Color.yellow, Color.red, Color.red, Color.yellow));
	}

	@Override
	public void render() {
		super.render();
		setFont(Font.BOLD, 30);
		drawText("Main menu", 530, 100, Color.cyan);
		reset();
	}

	@Override
	public void tick() {

	}
}
