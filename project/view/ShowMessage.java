package view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.BoardGameController;
import controller.HomeController;
import controller.SaveGame;
import model.BoardGameModel;
import model.RankModel;
import model.RecordModel;
import view.rank.RankView;

@SuppressWarnings("serial")
public class ShowMessage extends JInternalFrame {
	BoardGame boardGame;
	// BoardGame2Player boardGame2;

	public ShowMessage(BoardGame boardGameTurn) {
		this.boardGame = boardGameTurn;

	}

	BoardGameController boardController;

	public ShowMessage(BoardGameController boardController) {
		this.boardController = boardController;
	}

	// public ShowMessage(BoardGame2Player board2) {
	// this.boardGame2 = board2;
	// }

	public ShowMessage() {

	}

	/*
	 * hien thong bao khi nguoi choi muon choi lan moi
	 */
	public boolean showMessageNewGame() {
		String[] option = { "New Game", "Cancel" };

		int choice = JOptionPane.showOptionDialog(null, "Are you really want to play?", "New Game",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
		if (choice == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

	// hien thi thong bao nguoi choi muon choi tiep
	public boolean showMessageResumeGame() {
		String[] option = { "Resume", "Cancel" };
		int choice = JOptionPane.showOptionDialog(null, "Are you really want to resume?", "Resume Game",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
		if (choice == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

	/*
	 * hien thong bao khi nguoi choi muon thoat khoi tro choi
	 */
	public void showMessageQuit() {
		String[] option = { "Quit", "Cancel" };

		int choice = JOptionPane.showOptionDialog(null, "Are you really want to quit?", "Quit Game",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
		if (choice == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	/*
	 * hien thi thong bao khi nguoi choi het thoi gian ma game chua hoan thanh
	 */
	public void showMessageOverTime() {
		String[] option = { "Play Again", "Cancel" };
		int choice = JOptionPane.showOptionDialog(null, "Time out!!! You lose\nAre you want to play again?",
				"Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
		if (choice == JOptionPane.YES_OPTION) {

		}
	}

	/*
	 * hien thi thong bao khi nguoi choi het luot chon ma game chua hoan thanh
	 */
	public void showMessageOverFlip() {
		String[] option = { "Play", "Cancel" };
		int choice = JOptionPane.showOptionDialog(null, "Flip over!!! You lose\nAre you want to play again?",
				"Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
		if (choice == JOptionPane.YES_OPTION) {
		}
	}

	/*
	 * hien thong bao khi nguoi choi hoan thanh 1 lv
	 */
	public void showMessageCompleteLevel() {
		int choice = JOptionPane.showOptionDialog(null, "Level complete\nNext Level", "Level Complete",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
	}

	/*
	 * hien thong bao khi nguoi choi muon thoát khoi man hinh newgame de ve
	 * trang chu
	 */
	public static void showSaveAndBack(BoardGameModel boardModel, RecordModel rcModel, BoardGame boardGame) {
		int choice = JOptionPane.showOptionDialog(null, "Are you  want to save game and back home?", "Come back",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (choice == JOptionPane.NO_OPTION) {
			// removeAll();
			// JFrame frame = (JFrame) SwingUtilities.getRoot(boardGame);
			// frame.dispose();
			// new Home();
		} else {
			SaveGame saveGame = new SaveGame(boardModel, rcModel);
			saveGame.saveBoard();
			saveGame.saveImages();
			// removeAll();
			JFrame frame = (JFrame) SwingUtilities.getRoot(boardGame);
			frame.dispose();
			HomeView home = new HomeView();
			HomeController homeController = new HomeController(home);
			homeController.initMouseAction();
		}
	}

	public JFrame showMessageHelp() {
		JFrame frame = new JFrame("Help");
		JLabel lbl = new JLabel(new ImageIcon("images/help.png"));
		frame.add(lbl);

		frame.setSize(725, 575);
		frame.setVisible(true);
		 frame.setLocationRelativeTo(null);
		return frame;

	}

	/*
	 * hien thong bao khi nguoi choi thang game
	 */
	public void showMessageWinGame() {
		String[] option = new String[] { "View top rank", "Cancel" };

		int choice = JOptionPane.showOptionDialog(null, "You win!!!", "Complete Game", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
		if (choice == JOptionPane.YES_OPTION || choice == JOptionPane.NO_OPTION
				|| choice == JOptionPane.CLOSED_OPTION) {
			RankView rank = new RankView();
			String name = showMessageInputName();
			System.out.println(boardController.getScore());
			int score = Integer.parseInt(boardController.	 rcController.view.lbScoreNum.getText().trim());
			RankModel elemt = new RankModel(rank.arraylistTurn.size() + 1, name, score);
			System.out.println("Them elemt vao file: " + elemt.toString());
			rank.addTurnRank(elemt);
			rank.saveRankElemtToFile(RankView.FILETURN, elemt);
			rank.setPreferredSize(new Dimension(250, 290));
			JPanel pntmp = new JPanel();
			pntmp.setOpaque(false);
			pntmp.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			pntmp.setAlignmentY(JLabel.CENTER_ALIGNMENT);
			pntmp.add(rank);
			boardController.	boardGame.add(pntmp);
			rank.setVisible(true);
		}
	}

	// public void showMessage2Play(String s) {
	// JOptionPane.showMessageDialog(null, s);
	// JFrame frame = (JFrame) SwingUtilities.getRoot(boardGame2);
	// frame.dispose();
	// new Home();
	// }

	public String showMessageInputName() {
		StringBuffer s = new StringBuffer();
		String input = null;
		do {
			input = JOptionPane.showInputDialog("Input your name");
			char[] c = input.toCharArray();
			for (int i = 0; i < c.length; i++) {
				if (c[i] == ' ' || c[i] == ':') {
					c[i] = '_';
				}
				s.append(c[i]);
			}
		} while (JOptionPane.UNINITIALIZED_VALUE.equals(input) || input.trim().length() == 0 || input == null);
		return s.toString();
	}
}