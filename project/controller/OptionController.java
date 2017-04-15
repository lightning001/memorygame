package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.RecordModel;
import view.Option;
import view.ShowMessage;

public class OptionController implements ActionListener {
	Option optionView;
	BoardGameController boardController;
	RecordModel rcModel;
	ShowMessage sh = new ShowMessage();

	public OptionController(Option optionView, BoardGameController boardController, RecordModel rcModel) {
		this.optionView = optionView;
		this.rcModel = rcModel;
		this.boardController = boardController;
		optionView.btnew.addActionListener(this);
		optionView.btback.addActionListener(this);
		optionView.btmusic.addActionListener(this);
		optionView.btquit.addActionListener(this);
		optionView.btsound.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == optionView.btnew) {
			sh.showMessageNewGame();
		}
		if (e.getSource() == optionView.btback) {
			ShowMessage.showSaveAndBack(boardController.model, rcModel, boardController.boardGame);
		}
		if(e.getSource()== optionView.btquit){
			sh.showMessageQuit();
		}
	}
}
