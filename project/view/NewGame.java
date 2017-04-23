package view;

import javax.swing.JLayeredPane;

import controller.BoardGameController;
import controller.OptionController;
import controller.RecordController;
import controller.SettingController;
import model.BoardGameModel;
import model.LevelModel;
import model.RecordModel;
import model.Sound;

public class NewGame extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	Sound sound = new Sound("sound\\LegendOfZelda.wav");
	// add object record vao boardgame
	BoardGame board;
	ShowMessage sh = new ShowMessage();
	RecordController rcController;
	BoardGameController boardController;
	Setting setting = new Setting();
	

	@SuppressWarnings("unused")
	public NewGame(boolean isResume) {
		setLayout(null);
		setOpaque(false);
		LevelModel ob = new LevelModel(1);
		RecordView rc = new RecordView();
		RecordModel rcModel = new RecordModel(ob);
		board = new BoardGame(ob);
		rcController = new RecordController(rc, rcModel);
		rcController.updateRecordView(rcModel);
//		JLabel lb  = new JLabel("jsjfsfjksjfks");
//		lb.setFont(new Font("Arial", Font.BOLD, 45));
//		lb.setBounds(100,15,200,200);
//		add(lb);
		BoardGameModel boardModel = new BoardGameModel(ob);
		boardController = new BoardGameController(board, boardModel, rcController);
		if(isResume ){
			boardController.resumeGame();
		}else{
			boardController.draw();	
		}
		boardController.initAction();
		
		board.setSize(800, 600);
		board.setBounds(180, 15, 800, 600);
		board.setOpaque(false);
		add(board, JLayeredPane.DEFAULT_LAYER);
		add(rc, JLayeredPane.DEFAULT_LAYER);
		
		Option option = new Option();
		OptionController opController = new OptionController(option, boardController, rcModel);
		SettingController stController = new SettingController(setting, option,board);
		setting.setSize(80, 80);
		setting.setOpaque(false);
		setting.setBounds(0, 600, 80, 80);

		add(setting, JLayeredPane.DEFAULT_LAYER);

		add(option, JLayeredPane.POPUP_LAYER);
		option.setVisible(false);

		setSize(1050, 720);
		return;
		// sound.start();
		// setOpaque(false);
		// setSize(1050, 720);
	}

	

}
