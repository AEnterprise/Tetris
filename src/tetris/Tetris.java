package tetris;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import tetris.screens.ScreenBase;
import tetris.screens.ScreenMain;
import tetris.utils.MouseListener;
/**
 * Created by AEnterprise
 */
public class Tetris extends Applet implements ActionListener {
	public static final int WIDTH = 1000, HEIGHT = 750;
	public static Tetris INSTANCE;
	private ScreenBase currentScreen;
	private Graphics buffer;
	private Image image;


	@Override
	public void init() {
		super.init();
		setSize(WIDTH, HEIGHT);
		switchToScreen(new ScreenMain());
		addMouseListener(new MouseListener());
		addMouseMotionListener(new MouseListener());
		image = createImage(WIDTH, HEIGHT);
		buffer = image.getGraphics();
		INSTANCE = this;
		new Timer(20, this).start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setSize(WIDTH, HEIGHT);
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public boolean action(Event evt, Object what) {
		return super.action(evt, what);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		currentScreen.tick();
		buffer.clearRect(0, 0, WIDTH, HEIGHT);
		currentScreen.render(buffer, MouseListener.mouseX, MouseListener.mouseY);
		repaint();
	}

	public void switchToScreen(ScreenBase screen) {
		currentScreen = screen;
		screen.init();
	}

	public void click(int x, int y) {
		currentScreen.click(x, y);
	}

	public ScreenBase getCurrentScreen() {
		return currentScreen;
	}
}
