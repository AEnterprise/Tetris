package tetris.blocks;

import tetris.utils.Location;
import tetris.utils.Utils;

/**
 * Created by AEnterprise
 */
public class BigBlockA extends BigBlock {

	public BigBlockA(int x, int y) {
		super(x, y, Utils.getRandomColor());
		STATES = new Location[][]{
				//rotation 0
				{
						new Location(0, 0),
						new Location(1, 0),
						new Location(2, 0),
						new Location(3, 0)},

				//rotation 1
				{
						new Location(0, 0),
						new Location(0, 1),
						new Location(0, 2),
						new Location(0, 3)
				},

				//rotation 2
				{
						new Location(0, 0),
						new Location(1, 0),
						new Location(2, 0),
						new Location(3, 0)
				},

				//rotation 3
				{
						new Location(0, 0),
						new Location(0, 1),
						new Location(0, 2),
						new Location(0, 3)
				}
		};
		resetList();
		addBlocks();
	}
}
