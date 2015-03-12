package tetris;

import tetris.blocks.*;
import tetris.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by AEnterprise
 */
public class Tetris extends JFrame implements ActionListener {
	private Timer timer;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Tetris();
			}
		});
	}

	public Tetris() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(1200, 900);
		setTitle("Tetris");
		setResizable(false);
		setLocationRelativeTo(null);
		timer = new Timer(200, this);
		timer.setRepeats(true);
		timer.start();
		setBackground(Color.lightGray);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		drawBackground(g);
		MiniBlock block = new MiniBlock(new Location(10, 10));
		block.render(g);
		drawGrid(g);
	}

	private void drawBackground(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 1200, 900);

		g.setColor(new Color(0, 0, 0));
		g.fillRect(50, 75, 600, 750);

	}

	private void drawGrid(Graphics g) {
		g.setColor(Color.RED);
		for (int t = 0; t < 25; t++) {
			g.drawLine(50 + t * 25, 75, 50 + t * 25, 825);
		}

		for (int t = 0; t < 30; t++) {
			g.drawLine(50, 75 + 25 * t, 650, 75 + 25 * t);
		}
	}
}
