package model;

import view.BoardGame;

public class BonusScore {
	int subTime;
	int bonus;

	public BonusScore() {
		super();
	}

	public int bonus(String s , int remain) {
		int bonus = 0;
		if (s.equals("time")) {
			bonus = remain * 4;
		}
		if (s.equals("turn")) {
			bonus = remain * 6;
		}
		return bonus;
	}

}
