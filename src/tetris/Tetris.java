package tetris;

import javax.swing.*;
import java.awt.*;

/**
 * Created by AEnterprise
 * All rights reserved
 */
public class Tetris extends JFrame {

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
		setSize(800, 800);
		setLocation(80, 80);
		setTitle("Tetris");
		setResizable(false);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

	}


}
