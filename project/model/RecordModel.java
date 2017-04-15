package model;

public class RecordModel {

	int score = 0;
	int turn;
	LevelModel lv;

	public RecordModel(LevelModel lv) {
		this.lv = lv;
		this.turn =lv.getTurn();
	}

	public LevelModel getLv() {
		return lv;
	}

	public void setLv(LevelModel lv) {
		this.lv = lv;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void increaseLevel() {
		int x = lv.getX();
		x++;
		lv.setLevel(x);
		turn = lv.getM() * lv.getN() * 4;

	}
}
