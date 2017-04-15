package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.BoardGameModel;
import model.ButtonManagement;
import model.LevelModel;

public class BoardGame extends JPanel {
	public int m;
	public int n;
	public LevelModel observableLevel;
	public ArrayList<Integer> index = new ArrayList<>();
	public ArrayList<ImageIcon> listBt = new ArrayList<>();
	public JButton[] gameBt;
	public ArrayList<Observable> observer_p = new ArrayList<>();

	public BoardGame(LevelModel observableLevel) {
		this.observableLevel = observableLevel;
		setLayout(new BorderLayout());
		setSize(800, 600);
		setBounds(180, 15, 800, 600);
		setOpaque(false);
		setVisible(true);
	}

	int[] A;
	public ButtonManagement btMana = new ButtonManagement();
	public JPanel pn = new JPanel();

	public void initBoardGame(LevelModel lv) {
		index.clear();
		listBt.clear();
		this.A = new int[lv.getM() * lv.getN()];
		pn.setLayout(new GridLayout(lv.getM(), lv.getN(), 3, 3));
	}

	public void randomImage(BoardGameModel model) {
		ArrayList<Integer> images = model.randomImages();
		for (int i = 0; i < images.size(); i++) {
			 listBt.add(new ImageIcon("images\\hi" +images.get(i) +".jpg"));
		}
	}

	public void drawBoardGame(LevelModel lv) {
		// tao mat lung cua tam the
		gameBt = new JButton[lv.getM() * lv.getN()];
		for (int i = 0; i < gameBt.length; i++) {
//			A[i] = i;
			gameBt[i] = new JButton();
			gameBt[i].setSize(800 / lv.getN(), 600 / lv.getM());
			btMana.resetSize(gameBt[i], "images\\card2.png");
			// set hinh anh cau button khi nhan xuong
			gameBt[i].setSelectedIcon(listBt.get(i));
			// gameBt[i].setRolloverIcon(new ImageIcon("images\\card.png"));
			pn.add(gameBt[i]);
		}
		pn.setOpaque(false);
		add(pn, BorderLayout.CENTER);
	}

	public void nextLevel(BoardGameModel model) {
		pn.removeAll();
		initBoardGame(model.obLevel);
		randomImage(model);
		drawBoardGame(model.obLevel);
		repaint();
	}

	public LevelModel getObservable() {
		return observableLevel;
	}

	public void setObservable(LevelModel observableLevel) {
		this.observableLevel = observableLevel;
	}
}
