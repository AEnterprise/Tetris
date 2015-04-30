package tetris.screens;

import tetris.Tetris;
import tetris.screens.widgets.WidgetBase;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by AEnterprise
 */
public abstract class ScreenBase {
	private Font awtFont = new Font("", Font.PLAIN, 18);
	protected ArrayList<WidgetBase> widgets = new ArrayList<WidgetBase>();


	public abstract void init();

	public void render(Graphics g, int mouseX, int mouseY) {
		renderBackground(g, mouseX, mouseY);
		renderForeground(g, mouseX, mouseY);
	}

	protected void renderBackground(Graphics g, int mouseX, int mouseY) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Tetris.WIDTH, Tetris.HEIGHT);
	}

	protected void renderForeground(Graphics g, int mouseX, int mouseY) {
		for (WidgetBase widget : widgets) {
			widget.render(g, mouseX, mouseY, widget.mouseOver(mouseX, mouseY));
		}
	}

	public void click(int mouseX, int mouseY) {
		for (WidgetBase widget : widgets) {
			if (widget.mouseOver(mouseX, mouseY)) {
				widget.clicked();
			}
		}
	}

	public abstract void tick();

	public void reset() {
		widgets.clear();
		init();
	}

}
