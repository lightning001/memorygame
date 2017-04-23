package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;

import model.Sound;
import view.HomeView;
import view.NewGame;
import view.ShowMessage;
import view.rank.RankView;

public class HomeController implements MouseListener {
	HomeView home;
	Sound backgroundsound;
	Sound sound = new Sound();
	ShowMessage sh = new ShowMessage();

	public HomeController(HomeView home) {
		super();
		this.home = home;
		this.backgroundsound = new Sound("sound\\LegendOfZelda.wav");
		backgroundsound.start();
	}

	public void initMouseAction() {
		home.btnewgame.addMouseListener(this);
		home.btresume.addMouseListener(this);
		home.btrank.addMouseListener(this);
		home.bthelp.addMouseListener(this);
		home.btquit.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == home.btnewgame) {
			if (sh.showMessageNewGame()) {
				// JFrame frame = (JFrame) SwingUtilities.getRoot(home);
				// home.removeAll();
				JLayeredPane pnew = new NewGame(false);
				pnew.setVisible(true);
				pnew.setSize(1050, 720);
				pnew.setBounds(0, 0, pnew.getWidth(), pnew.getHeight());
				home.add(pnew);
				home.btnewgame.setVisible(false);
				home.btresume.setVisible(false);
				// bttype.setVisible(false);
				home.btrank.setVisible(false);
				home.bthelp.setVisible(false);
				home.btquit.setVisible(false);
			}
		}
		if (e.getSource() == home.btresume) {
			if (sh.showMessageResumeGame()) {
				Container content = home.getContentPane();
				JLayeredPane pnew = new NewGame(true);
				pnew.setVisible(true);
				pnew.setSize(1050, 720);
				pnew.setBounds(0, 0, pnew.getWidth(), pnew.getHeight());
				content.add(pnew);
				home.btnewgame.setVisible(false);
				home.btresume.setVisible(false);
				home.bttype.setVisible(false);
				home.btrank.setVisible(false);
				home.bthelp.setVisible(false);
				home.btquit.setVisible(false);
			}
		}
//		 if (e.getSource() == bttype) {
//		 TypeGame type = new TypeGame();
//		 add(type);
//		 type.setLocation(100, 100);
//		 type.setVisible(true);
//		 }
		if (e.getSource() == home.btrank) {
			JInternalFrame rank = new RankView();
			rank.setLocation(50, 50);
			rank.setLayer(JLayeredPane.POPUP_LAYER);
			rank.setSize(250, 290);
			home.add(rank, BorderLayout.WEST);
			rank.setVisible(true);
		}
		if (e.getSource() == home.bthelp) {
			// ShowMessageHelp show = new ShowMessageHelp("help");
			// show.setResizable(false);
			JFrame frame;
			
			frame = sh.showMessageHelp();
			home.add(frame,  JLayeredPane.POPUP_LAYER);
			// frame.setResizable(false);

		}
		if (e.getSource() == home.btquit) {
			sh.showMessageQuit();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == home.btnewgame) {
			sound.playSound("sound\\ploat.wav");
			home.btnewgame.setForeground(Color.YELLOW);
		}
		if (e.getSource() == home.btresume) {
			sound.playSound("sound\\ploat.wav");
			home.btresume.setForeground(Color.YELLOW);
		}
		if (e.getSource() == home.bttype) {
			sound.playSound("sound\\ploat.wav");
			home.bttype.setForeground(Color.YELLOW);
		}
		if (e.getSource() == home.btrank) {
			sound.playSound("sound\\ploat.wav");
			home.btrank.setForeground(Color.YELLOW);
		}
		if (e.getSource() == home.bthelp) {
			sound.playSound("sound\\ploat.wav");
			home.bthelp.setForeground(Color.YELLOW);
		}
		if (e.getSource() == home.btquit) {
			sound.playSound("sound\\ploat.wav");
			home.btquit.setForeground(Color.YELLOW);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
//		ImageIcon icon = new ImageIcon("images\\bt.png");
		if (e.getSource() == home.btnewgame) {
			home.btnewgame.setForeground(Color.BLACK);
			// home.btnewgame.setIcon(icon);
		}
		if (e.getSource() == home.btresume) {
			home.btresume.setForeground(Color.BLACK);
			// home.btresume.setIcon(icon);
		}
		if (e.getSource() == home.bttype) {
			home.bttype.setForeground(Color.BLACK);
			// home.bttype.setIcon(icon);
		}
		if (e.getSource() == home.btrank) {
			home.btrank.setForeground(Color.BLACK);
			// home.btrank.setIcon(icon);
		}
		if (e.getSource() == home.bthelp) {
			home.bthelp.setForeground(Color.BLACK);
			// home.bthelp.setIcon(icon);
		}
		if (e.getSource() == home.btquit) {
			home.btquit.setForeground(Color.BLACK);
			// home.btquit.setIcon(icon);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
