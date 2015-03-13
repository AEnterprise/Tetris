package tetris.utils;

import org.lwjgl.Sys;

/**
 * Created by AEnterprise
 */
public class Time {
	private static long lastFrame;

	public static boolean shouldTick() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		if (delta >= 25) {
			lastFrame = time;
			return true;
		}
		return false;
	}

	private static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
}
