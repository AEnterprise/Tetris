package tetris.utils;

import java.awt.Color;
import java.util.Random;

import tetris.blocks.BigBlock;
import tetris.blocks.BigBlockA;
import tetris.blocks.BigBlockB;
/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class Utils {
	private static final Random random = new Random();
	private static final Color[] COLORS = {
			Color.BLACK,
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
		return COLORS[random.nextInt(COLORS.length)];
	}

	public static BigBlock getRandomBlock(int x, int y) {
		switch (random.nextInt(2)) {
			case 0:
				return new BigBlockA(x, y);
			default:
				return new BigBlockB(x, y);
		}
	}
}
