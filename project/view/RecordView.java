package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.ObserverTest;

public class RecordView extends ObserverTest{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5079093620742230685L;
	public JLabel lbTurn, lbTurnNum, lbScore, lbLevel;
	public JLabel lbScoreNum;
	public JLabel lbLevelNum;
	private int turn, score, lv;
	ImageIcon imgfront = new ImageIcon("images\\treo23.png");
	ImageIcon imgunder = new ImageIcon("images\\treoduoi22.png");
	Font font = new Font("Blackadder ITC", Font.BOLD | Font.ITALIC, 35);
	Font font2 = new Font("Blackadder ITC", Font.BOLD | Font.ITALIC, 50);
	Color color = Color.BLACK;
	public JButton btn;

	public RecordView() {
		btn = new JButton("sds");
		add(createPane());
		add(btn);
		setOpaque(false);
		setSize(185, 500);
		// setDefaultCloseOperation(3);
		// setVisible(true);
	}

	public JPanel createPane() {
		JPanel pn = new JPanel();
		pn.setOpaque(false);
		pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
		lbTurn = createLabel(imgfront, "Turn", font, color);
		lbTurnNum = createLabel(imgunder, turn + "", font2, color);
		lbScore = createLabel(imgfront, "Score", font, color);
		lbLevel = createLabel(imgfront, "Level", font, color);
		lbScoreNum = createLabel(imgunder, score + "", font2, color);
		lbLevelNum = createLabel(imgunder, lv + "", font2, color);

		ArrayList<JLabel> list = new ArrayList<>();
		list.add(lbTurn);
		list.add(lbTurnNum);
		list.add(lbScore);
		list.add(lbScoreNum);
		list.add(lbLevel);
		list.add(lbLevelNum);
		for (int i = 0; i < list.size(); i++) {
			pn.add(list.get(i));
		}
		
		return pn;
	}

	public JLabel createLabel(ImageIcon icon, String text, Font font, Color color) {
		JLabel lbl = new JLabel(icon);
		lbl.setText(text);
		lbl.setFont(font);
		lbl.setForeground(color);
		lbl.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl.setVerticalTextPosition(SwingConstants.CENTER);
		return lbl;
	}
	public void update(){
		
	}

	public void updateScore(int score, int turn) {
		lbScoreNum.setText(score + "");
		lbTurnNum.setText(turn + "");
	}

	public JLabel getLbTurnNum() {
		return lbTurnNum;
	}

	public void setLbTurnNum(JLabel lbTurnNum) {
		this.lbTurnNum = lbTurnNum;
	}

	public JLabel getLbScoreNum() {
		return lbScoreNum;
	}

	public void setLbScoreNum(JLabel lbScoreNum) {
		this.lbScoreNum = lbScoreNum;
	}

	public JLabel getLbLevelNum() {
		return lbLevelNum;
	}

	public void setLbLevelNum(JLabel lbLevelNum) {
		this.lbLevelNum = lbLevelNum;
	}
}
