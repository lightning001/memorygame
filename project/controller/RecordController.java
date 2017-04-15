package controller;

import model.RecordModel;
import view.RecordView;

public class RecordController {
	public RecordView view;
	RecordModel model;

	public RecordController(RecordView view, RecordModel model) {
		this.view = view;
		this.model = model;
	}

	public void updateRecordView(RecordModel rcModel) {
		view.lbLevelNum.setText(rcModel.getLv().getX() + "");
		view.lbScoreNum.setText(rcModel.getScore() + "");
		view.lbTurnNum.setText(rcModel.getTurn() + "");
		view.btn.setText(rcModel.getLv().getX() + "");
	}

	public void update(RecordModel rcModel) {
		this.model = rcModel;

		updateRecordView(this.model);
	}
}
