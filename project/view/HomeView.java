package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class HomeView extends JFrame {
	public JButton btnewgame, btresume, bttype, btrank, bthelp, btquit;

	public HomeView() {
		setLayout(null);
		setTitle("Memory Game");
		setContentPane(new JLabel(new ImageIcon("images\\background5.jpg")));
		// setOpaque(true);

		JPanel pnInMain = new JPanel();
		pnInMain.add(createPanel());
		pnInMain.setOpaque(false);
		pnInMain.setBounds(380, 60, 300, 700);

		add(pnInMain);
		setSize(1050, 720);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setVisible(true);
		// Dimension d2 = new Dimension(1000, 700);
		// setPreferredSize(d2);
		// setMinimumSize(d2);
		// setMaximumSize(d2);
	}

	public JPanel createPanel() {
		// Font font = new Font("Blackadder ITC", Font.BOLD | Font.ITALIC, 40);
		// Font font = new Font("VNI-Slogan", Font.BOLD | Font.ITALIC, 40);
		Font font = new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 28);
		Color color = new Color(0, 0, 0);

		ImageIcon icon = new ImageIcon(("images\\bt.png"));
		ImageIcon rollIcon = new ImageIcon("images\\bt_enter.png");
		JPanel pnInMain = new JPanel();
		pnInMain.setOpaque(false);
		pnInMain.setLayout(new BoxLayout(pnInMain, BoxLayout.Y_AXIS));

		btnewgame = createButton(icon, "New Game", font, color);
		btresume = createButton(icon, "Resume", font, color);
		 bttype = createButton(icon, "Type Game", font, color);
		btrank = createButton(icon, "Top Rank", font, color);
		bthelp = createButton(icon, "Help", font, color);
		btquit = createButton(icon, "Quit", font, color);

		btnewgame.setRolloverIcon(rollIcon);
		btresume.setRolloverIcon(rollIcon);
		 bttype.setRolloverIcon(rollIcon);
		btrank.setRolloverIcon(rollIcon);
		bthelp.setRolloverIcon(rollIcon);
		btquit.setRolloverIcon(rollIcon);

		pnInMain.add(btnewgame);
		pnInMain.add(btresume);
		// pnInMain.add(bttype);
		pnInMain.add(btrank);
		pnInMain.add(bthelp);
		pnInMain.add(btquit);
		return pnInMain;
	}

	public JButton createButton(ImageIcon icon, String text, Font font, Color color) {
		JButton btn = new JButton();
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setIcon(icon);
		btn.setText(text);
		btn.setHorizontalTextPosition(SwingConstants.CENTER);
		btn.setVerticalTextPosition(SwingConstants.CENTER);
		btn.setFont(font);
		btn.setForeground(color);
		return btn;
	}
}