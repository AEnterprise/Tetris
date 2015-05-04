package tetris.blocks;

import tetris.utils.Location;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class BigBlockG extends BigBlock {

	public BigBlockG(int x, int y) {
		super(x, y);
		STATES = new Location[][] {
				//all rotations are the same
				{
						new Location(0, 0),
						new Location(1, 0),
						new Location(1, 1),
						new Location(0, 1)
				},
				{
						new Location(0, 0),
						new Location(1, 0),
						new Location(1, 1),
						new Location(0, 1)
				},
				{
						new Location(0, 0),
						new Location(1, 0),
						new Location(1, 1),
						new Location(0, 1)
				},
				{
						new Location(0, 0),
						new Location(1, 0),
						new Location(1, 1),
						new Location(0, 1)
				},
				{
						new Location(1, 1),
						new Location(2, 1),
						new Location(2, 2),
						new Location(1, 2)
				}
		};
		resetList();
	}
}
