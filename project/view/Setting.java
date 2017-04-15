package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.ButtonManagement;

@SuppressWarnings("serial")
public class Setting extends JPanel{
	JButton btSetting;
	ButtonManagement btMana = new ButtonManagement();

	public Setting() {
		BorderLayout bor = new BorderLayout();
		setLayout(bor);
		ImageIcon icon = new ImageIcon("images\\setting.png");
		btSetting = btMana.paintButton(icon);
		add(btSetting, BorderLayout.SOUTH);
		setVisible(true);
	}

	public void paint(Graphics g) {
		Color cl = new Color(10, 177, 22, 150);
		g.setColor(cl);
		g.fillOval(-80, 0, 160, 160);
		Color cl2 = new Color(38, 221, 211, 150);
		g.setColor(cl2);
		g.drawOval(-80, 0, 160, 160);
		super.paint(g);
	}

	public JButton getBtSetting() {
		return btSetting;
	}

	public void setBtSetting(JButton btSetting) {
		this.btSetting = btSetting;
	}

}
