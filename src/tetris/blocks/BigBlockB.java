package tetris.blocks;

import tetris.utils.Location;
/**
 * Created by AEnterprise
 */
public class BigBlockB extends BigBlock {

	public BigBlockB(int x, int y) {
		super(x, y);
		STATES = new Location[][]{
				//rotation 0
				{
						new Location(1, 0),
						new Location(0, 1),
						new Location(1, 1),
						new Location(2, 1)
				},

				//rotation 1
				{
						new Location(0, 0),
						new Location(0, 1),
						new Location(0, 2),
						new Location(1, 1)
				},

				//rotation 2
				{
						new Location(0, 0),
						new Location(1, 0),
						new Location(2, 0),
						new Location(1, 1),
				},

				//rotation 3
				{
						new Location(0, 1),
						new Location(1, 0),
						new Location(1, 1),
						new Location(1, 2),
				},

                //demo rotation
                {
                        new Location(1, 1),
                        new Location(0, 2),
                        new Location(1, 2),
                        new Location(2, 2)
                }
		};
		resetList();
		addBlocks();
	}
}
