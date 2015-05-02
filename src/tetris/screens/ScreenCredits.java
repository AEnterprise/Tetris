package tetris.screens;

import tetris.Tetris;
import tetris.screens.widgets.WidgetMenuButton;
import tetris.utils.Colors;
import tetris.utils.Images;

import java.awt.*;

/**
 * Created by AEnterprise
 */
public class ScreenCredits extends ScreenBase {

	@Override
	public void init() {
		widgets.add(new WidgetMenuButton(200, 280, "BACK TO MAIN MENU", Images.buttons[Colors.PURPLE.ordinal()], Color.YELLOW, Color.RED, new ScreenMain(), this));
	}

	@Override
	public void tick() {

	}

	@Override
	protected void renderForeground(Graphics g, int mouseX, int mouseY) {
		super.renderForeground(g, mouseX, mouseY);
		Font old = g.getFont();
		g.drawImage(Images.credits, 100, 0, Tetris.INSTANCE);
		g.setFont(new Font("", Font.BOLD, 20));
		g.setColor(Color.RED);
		String name = "Code: Tim De Keyser";
		g.drawChars(name.toCharArray(), 0, name.length(), 200, 200);
		name = "Graphics: Mikael Rozee (GustoniaEagle)";
		g.drawChars(name.toCharArray(), 0, name.length(), 200, 240);
		g.setFont(old);
	}
}
