package tetris.utils;

import java.awt.Color;
import java.util.Random;
/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class Colors {
	private static final Random random = new Random();
	private static Color[] colors =
			{Color.BLACK,
					Color.BLUE,
					Color.CYAN,
					Color.DARK_GRAY,
					Color.GRAY,
					Color.GREEN,
					Color.LIGHT_GRAY,
					Color.PINK,
					Color.WHITE,
					Color.YELLOW};

	public static Color getRandomColor() {
		return colors[random.nextInt(colors.length)];
	}
}
