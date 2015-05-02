package tetris;

import tetris.screens.ScreenBase;
import tetris.screens.ScreenMain;
import tetris.utils.Images;
import tetris.utils.MouseListener;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.setName("TETRIX");
        setSize(WIDTH, HEIGHT);
        addMouseListener(new MouseListener());
        addMouseMotionListener(new MouseListener());
        image = createImage(WIDTH, HEIGHT);
        buffer = image.getGraphics();
        INSTANCE = this;
        Images.loadImages();
        switchToScreen(new ScreenMain());
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
