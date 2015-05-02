package tetris.blocks;

import tetris.utils.Location;

/**
 * Created by AEnterprise
 */
public class BigBlockA extends BigBlock {

	public BigBlockA(int x, int y) {
		super(x, y);
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
				},

                //demo rotation
                {
                        new Location(0, 2),
                        new Location(1, 2),
                        new Location(2, 2),
                        new Location(3, 2)
                }

		};
		resetList();
	}
}
