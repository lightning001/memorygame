package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;

public class BoardGameModel {
	int m;
	int n;
	public LevelModel obLevel;
	ArrayList<Integer> luuVtri = new ArrayList<>();
	public ArrayList<Integer> saveImages = new ArrayList<Integer>();

	public ArrayList<Integer> getLuuVtri() {
		return luuVtri;
	}

	public void setLevel(LevelModel lv) {
		this.obLevel = lv;
		m = lv.getM();
		n = lv.getN();
	}

	public void increaseLevel() {
		int x = obLevel.getX();
		x++;
		obLevel.setLevel(x);
		m = obLevel.getM();
		n = obLevel.getN();
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public LevelModel getObLevel() {
		return obLevel;
	}

	public void setObLevel(LevelModel obLevel) {
		this.obLevel = obLevel;
	}

	public BoardGameModel(LevelModel lv) {
		setLevel(lv);
	}

	public String convertLuuVtriToString() {
		String s = "";
		for (int i = 0; i < luuVtri.size(); i++) {
			if (i == luuVtri.size() - 1) {
				s += luuVtri.get(i);
			} else
				s += luuVtri.get(i) + ",";
		}
		return s;
	}

	public ArrayList<Integer> getSaveImages() {
		return saveImages;
	}

	public void setSaveImages(ArrayList<Integer> saveImages) {
		this.saveImages = saveImages;
	}

	public String converLuuiMagesToString() {
		String s = "";
		for (int i = 0; i < saveImages.size(); i++) {
			if (i == saveImages.size() - 1) {
				s += saveImages.get(i);
			} else
				s += saveImages.get(i) + ",";
		}
		return s;
	}

	public ArrayList<Integer> randomImages() {
		Random r = new Random();
		int tmp = r.nextInt(70);
		ArrayList<Integer> index = new ArrayList<>();
		for (int i = 0; i < obLevel.getM() * obLevel.getN() / 2; i++) {
			index.add(i);
			index.add(i);
		}
		// dao vi tri cua cac so trong indexList
//		Collections.shuffle(index);
		for (int i = 0; i < obLevel.getM() * obLevel.getN(); i++) {
			saveImages.add((index.get(i) + tmp) % 70);
		}
		return saveImages;
	}
}
