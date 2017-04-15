package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ButtonManagement extends JButton {
	JPanel pn = new JPanel();
	private ImageIcon icon;

	/* set lai kich thuoc cua hinh anh duoc set trong Button */
	@SuppressWarnings("static-access")
	public void resetSize(JButton button, String fileName) {
		try {
			BufferedImage image = ImageIO.read(new File(fileName));

			int h = button.getHeight();
			int w = button.getWidth();
			int ix = image.getWidth();
			int iy = image.getHeight();
			int dx = 0, dy = 0;

			if (h / w > ix / iy) {
				dy = w;
				dx = dy * ix / iy;
			} else {
				dx = h;
				dy = dx * iy / ix;
			}
			ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
			button.setIcon(icon);
//			button.setBackground(new Color(0, 0, 0, 0));
			 button.setBorderPainted(false);
			 button.setContentAreaFilled(false);
			 button.setFocusPainted(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// tạo button vẽ background là 1 hinh cho truoc
	public JButton paintButton(ImageIcon icon) {
		JButton btn = new JButton(icon);
		btn.setBorder(null);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		return btn;

	}

	/*
	 * Tham khao tai dia chi web
	 * http://www.nguyenvanquan7826.com/2014/02/17/javaswing-jlabel/
	 */
	// Tao Label voi nen la 1 hinh anh va chu viet phia tren
	public JButton paintButton(ImageIcon icon, String st, Font font, Color color) {
		JButton btn = new JButton(icon);
		btn.setBorder(null);
		btn.setFont(font);
		btn.setForeground(color);
		btn.setHorizontalAlignment(JLabel.CENTER);
		btn.setVerticalAlignment(JLabel.CENTER);
		btn.setHorizontalTextPosition(SwingConstants.CENTER);
		btn.setText(st);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		return btn;

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(icon.getImage(), 0, 0, null);
	}
}
