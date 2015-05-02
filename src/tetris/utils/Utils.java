package tetris.utils;

import tetris.blocks.BigBlock;
import tetris.blocks.BigBlockA;
import tetris.blocks.BigBlockB;

import java.util.Random;
/**
 * Created by AEnterprise
 */
public class Utils {
	    private static final Random random = new Random();

	public static BigBlock getRandomBlock(int x, int y) {
		switch (random.nextInt(2)) {
			case 0:
				return new BigBlockA(x, y);
			default:
				return new BigBlockB(x, y);
		}
	}


}
