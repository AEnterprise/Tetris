package tetris.utils;

import java.util.ArrayList;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
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
