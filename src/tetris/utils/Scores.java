package tetris.utils;

import java.util.ArrayList;

/**
 * Created by AEnterprise
 */
public class Scores {
	private ArrayList<HighScore> scores = new ArrayList<>(10);

	public void addScore(HighScore score) {
		if (scores.size() == 0){
			for (int i = 0; i < 10; i++){
				scores.add(null);
			}
		}
		for (int i = 0; i < 10; i++) {
			HighScore old = scores.get(i);
			if (old == null) {
				scores.add(score);
				return;
			}
			if (score.score > old.score) {
				insertScore(i, score);
				return;
			}
		}
	}

	private void insertScore(int index, HighScore score) {
		for (int i = 8; i >= index; i--) {
			if (i < scores.size())
				scores.set(i + 1, scores.get(i));
		}
		scores.set(index, score);
	}
}
