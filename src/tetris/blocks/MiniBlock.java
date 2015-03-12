package tetris.blocks;

import tetris.utils.*;

import java.awt.*;

/**
 * Created by AEnterprise
 */
public class MiniBlock {
	private Location location;

	public MiniBlock(Location location) {
		this.location = location;
	}

	public void render(Graphics g) {
		g.setColor(new Color(139, 235, 255));
		g.fillRect(50 + 25 * location.x, 75 + 25 * location.y, 25, 25);
	}
}
