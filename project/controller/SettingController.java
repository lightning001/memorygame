package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.BoardGame;
import view.Option;
import view.Setting;
import view.ShowMessage;

public class SettingController implements ActionListener {
	Setting settingView;
	Option option;
	ShowMessage sh = new ShowMessage();
	BoardGame board ;

	public SettingController(Setting view, Option option,BoardGame board) {
		this.settingView = view;
		this.option = option;
		this.board = board;
		view.getBtSetting().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == settingView.getBtSetting()) {
			settingView.getBtSetting().setVisible(false);
			option.setVisible(true);
			option.setInheritsPopupMenu(true);
			option.setBackground(new Color(255, 255, 255, 90));
			option.setBounds(0, 720 - option.getHeight() - 35, 245, 340);
			// add(option);
			option.getClose().addActionListener(this);
			// option.setOpaque(false);
			for (int i = 0; i < board.gameBt.length; i++) {
				board.gameBt[i].setEnabled(false);
			}
		}
		if (e.getSource() == option.getClose()) {
			settingView.getBtSetting().setVisible(true);
			settingView.setVisible(true);
			option.setVisible(false);
			for (int i = 0; i < board.gameBt.length; i++) {
				board.gameBt[i].setEnabled(true);
			}
		}
	}

}
