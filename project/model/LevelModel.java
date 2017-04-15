package model;

public class LevelModel {
	private int m, n;
	private int turn;
	private int x;

	public LevelModel(int x) {
		this.setX(x);
		setLevel(x);
	}

	public void setLevel(int lv) {
		int m = 0, n = 0;
		switch (lv) {
		case 1:
			m = 2;
			n = 3;
			break;
		case 2:
			m = 3;
			n = 4;
			break;
		case 3:
			m = 4;
			n = 5;
			break;
		case 4:
			m = 5;
			n = 6;
			break;
		case 5:
			m = 5;
			n = 6;
			break;
		case 6:
			m = 5;
			n = 6;
			break;
		case 7:
			m = 5;
			n = 6;
			break;
		case 8:
			m = 5;
			n = 6;
			break;
		case 9:
			m = 5;
			n = 6;
			break;
		case 10:
			m = 3;
			n = 4;
			break;
		}
		setX(lv);
		this.m = m;
		this.n = n;
		this.turn = m * n * 4;
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

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}
