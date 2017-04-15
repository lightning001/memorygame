package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.SaveGame;
import model.ButtonManagement;

@SuppressWarnings("serial")
public class Option extends JPanel implements ActionListener {
	public JButton btsound, btmusic;
	public JButton btnew;
	public JButton btpause;
	public JButton btquit;
	public JButton btback;
	ButtonManagement btMana = new ButtonManagement();
	Setting set = new Setting();
	JPanel pn0, pn, pn1, pn2;
	JButton close;
	BoardGame boardGame;
	SaveGame saveGame;

	public Option() {
		super(true);

		setLayout(new BorderLayout());
		// setOpaque(false);
		// setBackground(Color.BLACK);
		pn0 = new JPanel();
		close = btMana.paintButton(new ImageIcon("images\\close.png"));
		pn0.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pn0.add(close);
		pn0.setBackground(new Color(0, 0, 0));

		pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setLayout(new BoxLayout(pn2, BoxLayout.Y_AXIS));
		pn2.setSize(230, 170);
		pn2.setBounds(0, close.getHeight(), 250, 320);

		Dimension d = new Dimension(250, 54);
		btsound = createButtonMenu("images\\sound.png", "Sound Setting", d);
		btmusic = createButtonMenu("images\\music.png", "Music Setting", d);
		btnew = createButtonMenu("images\\newgame.png", "New Game", d);
		btpause = createButtonMenu("images\\pause.png", "Pause", d);
		btback = createButtonMenu("images\\comeback.png", "Back Home", d);
		btquit = createButtonMenu("images\\quit.png", "Quit", d);

		// btsound = btMana.paintButton(new ImageIcon("images\\sound.png"));
		// btsound.setToolTipText("Sound Setting");
		//
		// btmusic = btMana.paintButton(new ImageIcon("images\\music.png"));
		// btmusic.setToolTipText("Music Setting");
		//
		// btnew = btMana.paintButton(new ImageIcon("images\\newgame.png"));
		// btnew.setToolTipText("New Game");
		//
		// btpause = btMana.paintButton(new ImageIcon("images\\pause.png"));
		// btpause.setToolTipText("Pause");
		//
		// btquit = btMana.paintButton(new ImageIcon("images\\quit.png"));
		// btquit.setToolTipText("Exit");
		//
		// btback = btMana.paintButton(new ImageIcon("images\\comeback.png"));
		// btback.setToolTipText("Back Home");
		btsound.addActionListener(this);
		btmusic.addActionListener(this);
		btnew.addActionListener(this);
		// btpause.addActionListener(this);
		btback.addActionListener(this);
		btquit.addActionListener(this);

		pn2.add(btsound);
		pn2.add(btmusic);
		pn2.add(btnew);
		// pn2.add(btpause);
		pn2.add(btback);
		pn2.add(btquit);

		// pn1 = new JPanel();
		// pn1.setBackground(new Color(80, 150, 80));
		// JPanel setsound = new SettingSound();
		// setsound.setSize(200, 180);
		// setsound.setVisible(true);
		// pn1.add(setsound);

		pn = new JPanel();
		// pn.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3),
		// "Option"));
		// pn.setBackground(new Color(80, 150, 80));

		add(pn0, BorderLayout.NORTH);
		pn.add(pn2, BorderLayout.CENTER);
		// pn.add(pn1, BorderLayout.SOUTH);
		add(pn);

		setVisible(true);
		setSize(230, 320);
	}

	// ham dung, khoi tao lai bien Option been tren
	public Option(BoardGame boOption) {
		this();
		this.boardGame = boOption;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ShowMessage sh = new ShowMessage(boardGame);
		if (e.getSource() == btsound) {
//			pn1.setVisible(true);
		}
		if (e.getSource() == btmusic) {

		}
		if (e.getSource() == btnew) {
			sh.showMessageNewGame();
		}
		if (e.getSource() == btpause) {
			if (btpause.getIcon().toString() == "images\\resume.png") {
				btpause.setIcon(new ImageIcon("images\\pause.png"));
				btpause.setToolTipText("Pause");
			} else if (btpause.getIcon().toString() == "images\\pause.png") {
				btpause.setIcon(new ImageIcon("images\\resume.png"));
				btpause.setToolTipText("Resume");
			}
		}
		if (e.getSource() == btquit) {
			sh.showMessageQuit();
		}
		if (e.getSource() == btback) {
			// sh.showSaveAndBack();
		}
	}

	public JButton getClose() {
		return close;
	}

	public JButton createButtonMenu(String iconName, String text, Dimension d) {
		ImageIcon icon = new ImageIcon(iconName);
		JButton btn = new JButton(text, icon);
		btn.setFont(new Font("Arial", Font.BOLD, 15));
		btn.setHorizontalAlignment(JLabel.LEFT);
		btn.setBackground(Color.WHITE);
		btn.setIconTextGap(20);
		setSizeAndBound(btn, d);
		return btn;
	}

	public static void setSizeAndBound(JButton btn, Dimension d) {
		btn.setPreferredSize(d);
		btn.setMinimumSize(d);
		btn.setMaximumSize(d);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
	}

}
