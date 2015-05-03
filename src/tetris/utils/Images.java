package tetris.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by AEnterprise
 */
public class Images {
    private static final Random random = new Random();
    public static Image[] blocks, buttons;
    public static Image logo, downButton, leftButton, rightButton, rotateButton, background, board, gridOverlay, credits, settingsTitle, settingsButton, level, score, nextBlock, gameOver, highScores;

    public static Image getRandomTexture() {
        return blocks[random.nextInt(blocks.length)];
    }

    public static void loadImages() {
        blocks = new Image[Colors.values().length];
        buttons = new Image[Colors.values().length];
        for (Colors color: Colors.values()) {
            blocks[color.ordinal()] = loadImage("block" + color.name + ".png");
            buttons[color.ordinal()] = loadImage("button" + color.name + ".png");
        }
        logo = loadImage("logo.png");
        downButton = loadImage("arrowDown.png");
        leftButton = loadImage("arrowLeft.png");
        rightButton = loadImage("arrowRight.png");
        rotateButton = loadImage("arrowRotate.png");
        background = loadImage("background1000x750.png");
        board = loadImage("boardVersionC.png");
        gridOverlay = loadImage("gridOverlay.png");
        credits = loadImage("titleCredits.png");
        settingsTitle = loadImage("titleSettings.png");
        settingsButton = loadImage("buttonSettings.png");
        level = loadImage("levelPreview.png");
        score = loadImage("scorePreview.png");
        nextBlock = loadImage("nextBlockPreview.png");
		gameOver = loadImage("titleGameover.png");
		highScores = loadImage("titleHighscores.png");
        System.out.println("Images loaded");
    }

    public static Image loadImage(String name) {
		try {
			InputStream stream = Images.class.getResourceAsStream("/" + name);
			return ImageIO.read(stream);
		} catch (Throwable e) {
			System.out.println("Failed to load image: " + name);
		}
		return null;
    }
}
