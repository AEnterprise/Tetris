package tetris.utils;

import tetris.blocks.*;

import java.util.Random;

/**
 * Created by AEnterprise
 */
public class Utils {
	    private static final Random random = new Random();

	public static BigBlock getRandomBlock(int x, int y) {
		switch (random.nextInt(7)) {
			case 0:
				return new BigBlockA(x, y);
			case 1:
				return new BigBlockB(x, y);
			case 2:
				return new BigBlockC(x, y);
			case 3:
				return new BigBlockD(x, y);
			case 4:
				return new BigBlockE(x, y);
			case 5:
				return new BigBlockF(x, y);
			default:
				return new BigBlockG(x, y);
		}
	}


}
