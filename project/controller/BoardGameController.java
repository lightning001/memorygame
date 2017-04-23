package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.BoardGameModel;
import model.BonusScore;
import model.LevelModel;
import model.RecordModel;
import model.Sound;
import view.BoardGame;
import view.ShowMessage;

public class BoardGameController implements ActionListener {
	public BoardGame boardGame;
	BoardGameModel model;
	public RecordController rcController;
	ShowMessage sh = new ShowMessage(this);
	SaveGame saveGame;

	public BoardGameController(BoardGame boardGame, BoardGameModel model, RecordController rcController) {
		this.boardGame = boardGame;
		this.model = model;
		this.rcController = rcController;
		saveGame = new SaveGame(model, rcController.model);

	}

	public void initAction() {
		for (int i = 0; i < boardGame.gameBt.length; i++) {
			boardGame.gameBt[i].addActionListener(this);
		}
	}

	public void draw() {

		boardGame.initBoardGame(model.obLevel);
		boardGame.randomImage(model);
		boardGame.drawBoardGame(model.obLevel);
		for (int i = 0; i < model.getLuuVtri().size(); i++) {
			boardGame.gameBt[model.getLuuVtri().get(i)].setVisible(false);

		}
	}

	int c1;
	int c2;
	int score = 0;
	int lv;
	int count = 0;
	public int turn;
	Sound sound = new Sound();
	String name;
	JButton[] btselected = new JButton[2];

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < boardGame.gameBt.length; i++) {
			boardGame.validate();
			if (boardGame.gameBt[i] == e.getSource()) {
				if (btselected[0] == null && btselected[1] == null) {
					sound.playSound("sound\\click.wav");
					c1 = i;// lay vi tri cua button dc
							// chon cho c1
					boardGame.btMana.resetSize(boardGame.gameBt[i], boardGame.listBt.get(i).toString());
					btselected[0] = boardGame.gameBt[i];
					boardGame.gameBt[i].removeActionListener(this);
					// rc.lbTurnNum.setText(turn + "");
					boardGame.validate();
					return;
				}
				if (btselected[0] != null && btselected[1] == null) {
					sound.playSound("sound\\click.wav");

					c2 = i;// lay vi tri cua button dc
							// chon cho
					System.out.println("button " + boardGame.listBt.get(c2).toString() + " duoc chon");
					boardGame.btMana.resetSize(boardGame.gameBt[i], boardGame.listBt.get(i).toString());
					btselected[1] = boardGame.gameBt[i];
					boardGame.gameBt[c2].removeActionListener(this);
					boardGame.validate();
					tartTimerCheckCard(boardGame.listBt.get(c1).toString(), boardGame.listBt.get(c2).toString());
				}
				boardGame.validate();

			}
		}
	}

	public void checkCard(String b1, String b2) {
		RecordModel rcModel = rcController.model;
		if (b1.toString().equals(b2.toString())) {

			sound.playSound("sound\\true.wav");
			boardGame.gameBt[c1].setVisible(false);
			boardGame.gameBt[c2].setVisible(false);
			rcModel.setScore(rcModel.getScore() + 10);
			System.out.println("Score:" + rcModel.getScore());
			rcModel.setTurn(rcModel.getTurn() - 1);
			count += 2;
			rcController.updateRecordView(rcModel);
			btselected[0] = null;
			btselected[1] = null;
			boardGame.validate();

			model.getLuuVtri().add(c1);
			model.getLuuVtri().add(c2);

		} else {
			System.out.println("===>Score:" + rcModel.getScore());
			sound.playSound("sound\\miss.wav");
			boardGame.gameBt[c1].setIcon(new ImageIcon("images\\card2.png"));
			boardGame.btMana.resetSize(boardGame.gameBt[c1], "images\\card2.png");
			boardGame.gameBt[c2].setIcon(new ImageIcon("images\\card2.png"));
			boardGame.btMana.resetSize(boardGame.gameBt[c2], "images\\card2.png");
			boardGame.gameBt[c1].addActionListener(this);
			boardGame.gameBt[c2].addActionListener(this);

			rcModel.setScore(rcModel.getScore() - 2);
			rcModel.setTurn(rcModel.getTurn() - 1);
			rcController.updateRecordView(rcModel);
			btselected[0] = null;
			btselected[1] = null;
			boardGame.validate();

		}
		boardGame.validate();
		LevelModel currentLevel = model.obLevel;
		if (count == boardGame.gameBt.length) {
			if (currentLevel.getX() == 10) {
				BonusScore bonus = new BonusScore();
				int bonusScore = bonus.bonus("turn", rcModel.getTurn());
				rcModel.setScore(rcModel.getScore() + bonusScore);
				rcController.update(rcModel);

				System.out.println("total " + rcModel.getScore());
				sound.playSound("sound\\wingame.wav");
				sh.showMessageWinGame();

			} else {
				BonusScore bonus = new BonusScore();
				int bonusScore = bonus.bonus("turn", rcModel.getTurn());
				rcModel.setScore(rcModel.getScore() + bonusScore);
				rcController.update(rcModel);

				count = 0;
				// score += bonus.bonus("time");
				rcModel.increaseLevel();
				sound.playSound("sound\\levelcomplete.wav");
				sh.showMessageCompleteLevel();
				rcController.update(rcModel);
				model.increaseLevel();
				boardGame.nextLevel(model);
				initAction();
				model.getLuuVtri().clear();
				System.out.println("total " + rcModel.getScore());

			}
		}
		boardGame.validate();
		return;
	}

	static final int COUNT_DOWN_TIMER = 2;
	java.util.Timer checkCardTimer;

	void tartTimerCheckCard(String card1, String card2) {
		if (checkCardTimer == null) {
			checkCardTimer = new java.util.Timer();
		}
		// start timer delay 3s truoc khi goi ham checkCard
		checkCardTimer.scheduleAtFixedRate(new TimerTask() {
			int c = COUNT_DOWN_TIMER;

			@Override
			public void run() {
				while (c >= 0) {
					if (c == 0) {
						checkCardTimer.cancel(); // cancel timer
						checkCardTimer = null;
						checkCard(card1, card2);
					}
					c--;
				}
			}

		}, 500, 500);
	}

	public void resumeBoardGame() {
		String s = saveGame.readBoard();
		if (s != null) {
			s = s.replaceAll("(\\r|\\n)", "");
			String arr[] = s.split("-");
			model.setM(Integer.parseInt(arr[0]));
			model.setN(Integer.parseInt(arr[1]));
			rcController.model.setTurn(Integer.parseInt(arr[2]));
			rcController.model.setScore(Integer.parseInt(arr[3]));
			lv = Integer.parseInt(arr[4]);
			LevelModel levelModel = new LevelModel(lv);
			this.model.setLevel(levelModel);
			if (arr.length > 5) {
				String ss[] = arr[5].split(",");
				for (int i = 0; i < ss.length; i++) {
					String sViTri = ss[i].trim();
					sViTri = sViTri.replace("\\r", "");
					sViTri = sViTri.replace("\\n", "");
					model.getLuuVtri().add(Integer.parseInt(ss[i]));
				}
			}
		}
		rcController.update(rcController.model);
		count = model.getLuuVtri().size() + count;

	}

	public void resumeImages() {
		String s = saveGame.readImages();
		s = s.replaceAll("(\\r|\\n)", "");
		String ss[] = s.split(",");
		for (int i = 0; i < ss.length; i++) {
			model.getSaveImages().add(Integer.parseInt(ss[i]));
			boardGame.listBt.add(new ImageIcon("images\\hi" + ss[i] + ".jpg"));
		}
	}

	public void resumeGame() {
		boardGame.initBoardGame(model.obLevel);
		resumeBoardGame();
		boardGame.randomImage(model);
		// resumeImages();
		boardGame.drawBoardGame(model.obLevel);
		for (int i = 0; i < model.getLuuVtri().size(); i++) {
			boardGame.gameBt[model.getLuuVtri().get(i)].setVisible(false);

		}
	}

	public int getScore() {
		return score;
	}

	public int getTurn() {
		return turn;
	}
}
