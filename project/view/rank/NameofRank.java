package view.rank;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

@SuppressWarnings("serial")
public class NameofRank extends JPanel{
	public static final int ONE_TIME = 0;
	public static final int ONE_TURN = 1;
	@SuppressWarnings("unused")
	private int type;
	public NameofRank(int type) {
		this.type = type;
		setLayout(new BorderLayout());
		
		JLabel lb = new JLabel("No.");
		lb.setPreferredSize(new Dimension(35, 20));
		lb.setMinimumSize(new Dimension(35, 20));
		
		JLabel lbName = new JLabel("Name Player");
		lbName.setPreferredSize(new Dimension(100, 20));
		lbName.setMinimumSize(new Dimension(100, 20));
		lbName.setHorizontalAlignment(JLabel.CENTER);
		lbName.setVerticalAlignment(JLabel.CENTER);
		
		JLabel lbType = new JLabel();
		switch(type){
		case 0:
			lbType.setText("Score by Time");
			break;
		case 1:
			lbType.setText("Score by Turn");
			break;
		}
		lbType.setPreferredSize(new Dimension(90, 20));
		lbType.setMinimumSize(new Dimension(90, 20));
		lbType.setHorizontalAlignment(JLabel.CENTER);
		lbType.setVerticalAlignment(JLabel.CENTER);
		
		add(lb, BorderLayout.WEST);
		add(lbName, BorderLayout.CENTER);
		add(lbType, BorderLayout.EAST);
		
	}
}
