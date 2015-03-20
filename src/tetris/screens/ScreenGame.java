package tetris.screens;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glRecti;

/**
 * Created by AEnterprise
 */
public class ScreenGame extends ScreenBase {
	//field size: 17x27

	@Override
	public void init() {

	}

	@Override
	public void render() {
		super.render();
		glColor3f(1, 1, 1);
		glRecti(300, 100, 750, 800);

	}

	@Override
	public void tick() {

	}
}
