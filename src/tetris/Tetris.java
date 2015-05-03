package tetris;

import tetris.screens.ScreenBase;
import tetris.screens.ScreenMain;
import tetris.utils.Images;
import tetris.utils.KeyListener;
import tetris.utils.MouseListener;
import tetris.utils.Options;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by AEnterprise
 */
public class Tetris extends JFrame implements ActionListener {
	public final int WIDTH = 1000, HEIGHT = 750;

	public static Tetris INSTANCE;

	public Options OPTIONS;

	private ScreenBase currentScreen;
	private Graphics buffer;
	private Image image;


	public Tetris() {
		init();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new Tetris();
			}
		});
	}


	public void init() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

		INSTANCE = this;
		this.setName("TETRIX");
		setSize(WIDTH, HEIGHT);
		addMouseListener(new MouseListener());
		addMouseMotionListener(new MouseListener());
		addKeyListener(new KeyListener());
		setFocusable(true);
		requestFocusInWindow();
		this.image = createImage(WIDTH, HEIGHT);
		this.buffer = this.image.getGraphics();
		Images.loadImages();
		this.OPTIONS = new Options();
		this.OPTIONS.init();

		new Timer(20, this).start();

		switchToScreen(new ScreenMain());
	}

	@Override
	public void paint(Graphics g) {
		setSize(WIDTH, HEIGHT);
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
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
