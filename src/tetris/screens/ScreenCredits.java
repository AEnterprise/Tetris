package tetris.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import tetris.screens.widgets.WidgetMenuButton;
/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class ScreenCredits extends ScreenBase {

	@Override
	public void init() {
		widgets.add(new WidgetMenuButton(200, 280, 400, 50, "BACK TO MAIN MENU", new ScreenMain(), this).setColors(Color.YELLOW, Color.RED, Color.RED, Color.YELLOW));
	}

	@Override
	public void tick() {

	}

	@Override
	protected void renderForeground(Graphics g, int mouseX, int mouseY) {
		super.renderForeground(g, mouseX, mouseY);
		Font old = g.getFont();
		g.setFont(new Font("", Font.BOLD, 30));
		g.setColor(Color.ORANGE);
		String title = "CREDITS";
		g.drawChars(title.toCharArray(), 0, title.length(), 470, 60);
		g.setFont(new Font("", Font.BOLD, 20));
		g.setColor(Color.RED);
		String name = "Code: Tim De Keyser";
		g.drawChars(name.toCharArray(), 0, name.length(), 200, 200);
		name = "Graphics: Mikael Rozee (GustoniaEagle)";
		g.drawChars(name.toCharArray(), 0, name.length(), 200, 240);
		g.setFont(old);
	}
}
